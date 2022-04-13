package org.acme.rest.json;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/weather")
@RegisterRestClient
public interface WeatherService {

    @GET
    Weather getByCoordinates(@QueryParam("lat") String lat, @QueryParam("lon") String lon, @QueryParam("appid") String appid, @QueryParam("units") String units);
}