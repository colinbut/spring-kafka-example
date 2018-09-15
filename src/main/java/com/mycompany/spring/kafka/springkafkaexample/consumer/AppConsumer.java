/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.spring.kafka.springkafkaexample.consumer;

import com.mycompany.spring.kafka.springkafkaexample.config.KafkaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AppConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppConsumer.class);

    @KafkaListener(
        topicPartitions = @TopicPartition(topic = KafkaConfig.TOPIC_NAME,
            partitionOffsets = {
                @PartitionOffset(partition = "0", initialOffset = "0"),
                @PartitionOffset(partition = "3", initialOffset = "0")
            }),
        groupId = KafkaConfig.GROUP_ID,
        containerFactory = "filterKafkaListenerContainerFactory"
    )
    public void listen(@Header(KafkaHeaders.PARTITION_ID) int partition,
                       @Payload String message) {
        LOGGER.info(String.format("Received Message %s in group id: %s from partition: %d",
            KafkaConfig.GROUP_ID, message, partition));
    }
}
