package com.yourcompany.newapp;



/**
 * Service interface for name service.
 * 
 */
public interface GreetingsService {

    /**
     * Generate Greetings
     *
     * @return a string greetings
     */
    Greetings getGreetings( String name);
    /**
    String postMessages(Msg msg);
    */
}