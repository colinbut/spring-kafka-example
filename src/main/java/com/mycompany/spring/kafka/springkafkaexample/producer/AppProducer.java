/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.spring.kafka.springkafkaexample.producer;

import com.mycompany.spring.kafka.springkafkaexample.config.KafkaConfig;
import com.mycompany.spring.kafka.springkafkaexample.message.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class AppProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Customer> jsonKafkaTemplate;


    public void sendMessage(String message) {
        Message<String> kafkaMessage = MessageBuilder
            .withPayload(message)
            .setHeader(KafkaHeaders.TOPIC, KafkaConfig.TOPIC_NAME_STRING)
            .setHeader(KafkaHeaders.PARTITION_ID, 0)
            .build();
        kafkaTemplate.send(kafkaMessage);
    }

    public void sendJsonMessage(Customer customer) {
        Message<Customer> kafkaMessage = MessageBuilder
            .withPayload(customer)
            .setHeader(KafkaHeaders.TOPIC, KafkaConfig.TOPIC_NAME_JSON)
            .setHeader(KafkaHeaders.PARTITION_ID, 0)
            .build();
        jsonKafkaTemplate.send(kafkaMessage);
    }
}
