package com.example.cloudstreamkafkademo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
@EnableBinding(Sink.class)
public class AppConsumer {

    @StreamListener(Processor.INPUT)
    public void process(@Header(value = KafkaHeaders.MESSAGE_KEY, required = false) String key,
                        @Payload(required = false) Message<?> message){
        System.out.println("key: " +key +" message content: "+ message);
    }
}
