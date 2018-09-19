/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.spring.kafka.springkafkaexample.config;

public final class KafkaConfig {

    private KafkaConfig(){}

    /**
     * TODO: think about propertising this in a properties file
     */
    public static final String TOPIC_NAME_STRING = "spring.kafka.topic.string";
    public static final String TOPIC_NAME_JSON = "spring.kafka.topic.json";

    public static final String GROUP_ID = "1";

    public static final String KAFKA_BOOTSTRAP_SERVERS = "localhost:9092";
}
