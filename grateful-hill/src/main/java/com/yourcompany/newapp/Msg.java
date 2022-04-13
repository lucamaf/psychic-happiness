package com.yourcompany.newapp;

public class Msg {
    private String city;
    private String lat;
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
