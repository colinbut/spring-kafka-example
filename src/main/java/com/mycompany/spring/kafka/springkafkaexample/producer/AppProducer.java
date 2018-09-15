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
import org.springframework.stereotype.Component;

@Component
public class AppProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Customer> jsonKafkaTemplate;


    public void sendMessage(String message) {
        kafkaTemplate.send(KafkaConfig.TOPIC_NAME_STRING, message);
    }

    public void sendJsonMessage(Customer customer) {
        jsonKafkaTemplate.send(KafkaConfig.TOPIC_NAME_JSON, customer);
    }
}
