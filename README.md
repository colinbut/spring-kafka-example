# Spring Kafka Example

First things First...

1. Download and Install Kafka
2. Start up Kafka Server and Create Topics

Create the topic that takes Strings

```bash
./kafka-topics.sh --create \
  --zookeeper localhost:2181 \
  --replication-factor 1 --partitions 5 \
  --topic spring.kafka.topic.string
```

Create the topic that takes JSON strings

```bash
./kafka-topics.sh --create \
  --zookeeper localhost:2181 \
  --replication-factor 1 --partitions 5 \
  --topic spring.kafka.topic.json
```