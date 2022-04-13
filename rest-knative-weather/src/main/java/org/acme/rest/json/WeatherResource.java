package org.acme.rest.json;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


@Path("/weather")
public class WeatherResource {

    @Inject
    @RestClient
    WeatherService weatherService;

    @GET
    public Weather weatherCity(@QueryParam("lat") String lat, @QueryParam("lon") String lon, @QueryParam("appid") String appid, @QueryParam("units") String units) {
        return weatherService.getByCoordinates(lat, lon, appid, units);
    }
}