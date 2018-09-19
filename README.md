# Spring Kafka Example

First things First...

1. Download and Install Kafka
2. Start up Kafka Server and Create Topics

### Start Zookeeper

Kafka needs Zookeeper for distribution. So start up the Zookeeper that comes bundled with Kafka

```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```

### Start Kafka Server

```bash
bin/kafka-server-start.sh config/server.properties
```

### Create the topic that takes Strings

```bash
./kafka-topics.sh --create \
  --zookeeper localhost:2181 \
  --replication-factor 1 --partitions 5 \
  --topic spring.kafka.topic.string
```

### Create the topic that takes Json

Create the topic that takes JSON strings

```bash
./kafka-topics.sh --create \
  --zookeeper localhost:2181 \
  --replication-factor 1 --partitions 5 \
  --topic spring.kafka.topic.json
```

### Consumers

```bash
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic spring.kafka.topic.string --from-beginning
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic spring.kafka.topic.json --from-beginning
```

### Running the example

Build the project by doing a

```bash
./mvnw clean install
```

or if you have maven installed locally then you can also do:

```bash
mvn clean install
```

then run:

```bash
java -jar target/spring-kafka-example-0.0.1-SNAPSHOT.jar
```