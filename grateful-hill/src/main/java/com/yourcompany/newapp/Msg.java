package com.yourcompany.newapp;

import javax.ws.rs.DefaultValue;

public class Msg {
    @DefaultValue("Barcelona")
    private String city;
    @DefaultValue("41.38")
    private String lat;
    @DefaultValue("2.15")
    private String lon;
    private String secretKey;



    public Msg() {
    }

    public Msg(String city, String lat, String lon, String secretKey) {
        this.city = city;
        this.lat = lat;
        this.lon = lon;
        this.secretKey = secretKey;
    }
    
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return this.lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    

    @Override
    public String toString() {
        return "{" +
            " city='" + getCity() + "'" +
            ", lat='" + getLat() + "'" +
            ", lon='" + getLon() + "'" +
            ", secretKey='" + getSecretKey() + "'" +
            "}";
    }
    
    
}
