/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.spring.kafka.springkafkaexample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KafkaProperties {

    @Value("${kafka.topic.name.string}")
    private String stringTopic;

    @Value("${kafka.topic.name.json}")
    private String jsonTopic;

    @Value("${kafka.groupid}")
    private int groupId;

    @Value("${kafka.bootstrap.servers}")
    private String bootstrapServers;

    public String getStringTopic() {
        return stringTopic;
    }

    public KafkaProperties setStringTopic(String stringTopic) {
        this.stringTopic = stringTopic;
        return this;
    }

    public String getJsonTopic() {
        return jsonTopic;
    }

    public KafkaProperties setJsonTopic(String jsonTopic) {
        this.jsonTopic = jsonTopic;
        return this;
    }

    public int getGroupId() {
        return groupId;
    }

    public KafkaProperties setGroupId(int groupId) {
        this.groupId = groupId;
        return this;
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public KafkaProperties setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
        return this;
    }
}
