package org.acme.rest.json;

import java.net.MalformedURLException;
import java.net.URL;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.RestClientDefinitionException;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

//Example of API call
//https://api.openweathermap.org/data/2.5/weather?lat=33.44&lon=-94.04&exclude=hourly,daily&appid={API key}



@Path("/")
public class MsgResource {

    private static final Logger LOG = Logger.getLogger(MsgResource.class);

    @RestClient
    WeatherService weatherQuery;

    @Channel("weather-requests")
    Emitter<Weather> weatherRequestEmitter;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWeather(Msg msg) throws IllegalStateException, RestClientDefinitionException, MalformedURLException {
        LOG.info("> Activate weather request!");
        //make rest call to openweathermap.org
      
        String lat = msg.getLat();
        String lon = msg.getLon();
        String appid = msg.getSecretKey();
        String units = "metric";
        String baseUrl = "https://api.openweathermap.org/data/2.5";
        weatherQuery = RestClientBuilder.newBuilder().baseUrl(new URL(baseUrl)).build(WeatherService.class);
        LOG.info(">> Calling external openweathermap service");
        Weather res = weatherQuery.getByCoordinates(lat, lon, appid, units);
        //LOG.info("Res: "+res);
        //write the result in kafka topic
        weatherRequestEmitter.send(res);
        LOG.info(">>> Writing result to topic");
        return Response.ok().build();
    }

    @GET    
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {      
      return "test";
  }
}
