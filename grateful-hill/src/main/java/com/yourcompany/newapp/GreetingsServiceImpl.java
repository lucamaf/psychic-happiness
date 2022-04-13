package com.yourcompany.newapp;


import org.apache.camel.Header;
import org.springframework.stereotype.Service;

@Service("greetingsService")
public class GreetingsServiceImpl implements GreetingsService {

    private static final String THE_GREETINGS = "Hello, ";

    @Override
    public Greetings getGreetings(@Header("name") String name ) {
        return new Greetings( THE_GREETINGS + name );
    }

    /** 
    @Override
    public String postMessages(Msg msg) {
        String toSend = "";
        if(msg.getTest()){
            toSend = "This is a test message coming from "+msg.getName();
        }else{
            toSend = "This is a real message coming from "+msg.getName();
        }
        return toSend;
        
    }
    */

}