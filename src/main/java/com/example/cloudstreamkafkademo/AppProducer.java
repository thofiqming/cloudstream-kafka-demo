package com.example.cloudstreamkafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Configuration
@EnableScheduling
@EnableBinding(Source.class)
public class AppProducer {

    @Autowired
    private MessageChannel output;

    @Scheduled(fixedDelay = 2000)
    public void process() {
        this.output.send(MessageBuilder.withPayload(new OrderDetails(UUID.randomUUID().toString())).build());
    }

}


