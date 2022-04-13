package com.yourcompany.newapp;


import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;
import org.apache.camel.component.kafka.KafkaConstants;


/**
 * A simple Camel REST DSL route that implements the greetings service.
 * 
 */
@Component
public class CamelRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // @formatter:off
        restConfiguration()
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "Greeting REST API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "false")
                .apiProperty("base.path", "camel/")
                .apiProperty("api.path", "/")
                .apiProperty("host", "")
                .apiContextRouteId("doc-api")
            .component("servlet")
            .bindingMode(RestBindingMode.json);
        
        rest("/greetings").description("Greeting and logging")
            .get("/{name}").outType(Greetings.class).to("direct:greetingsImpl")
            .post("/queue").type(Msg.class).to("direct:loggingImpl");

        from("direct:greetingsImpl").description("Greetings REST service implementation route")
            .streamCaching()
            .to("bean:greetingsService?method=getGreetings");     
        
        from("direct:loggingImpl").description("Logging REST service implementation route")
            .streamCaching().logMask()
            .log("${body}")
            .removeHeaders("*")
            .setHeader(KafkaConstants.KEY, constant("Weather"))
            .marshal().json(JsonLibrary.Jackson)
            .to("kafka:my-events?brokers=my-cluster-kafka-bootstrap.appdev-kafka.svc:9092")
            .setHeader(Exchange.HTTP_RESPONSE_CODE,constant(201))
            .setBody(constant("Weather request received!"));
            // send body to kafka with field city
            // and lat and long
    }

}