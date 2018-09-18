package com.mycompany.spring.kafka.springkafkaexample;

import com.mycompany.spring.kafka.springkafkaexample.consumer.AppConsumer;
import com.mycompany.spring.kafka.springkafkaexample.message.Customer;
import com.mycompany.spring.kafka.springkafkaexample.producer.AppProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class SpringKafkaExampleApplication implements CommandLineRunner {

    @Autowired
    private AppProducer appProducer;

    @Autowired
    private AppConsumer appConsumer;

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        new Thread(() -> {
            while (true) {
                appProducer.sendMessage(String.format("String Message-%d", new Random().nextInt()));
            }
        }).start();

        new Thread(() -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            while (true) {

                Customer customer = new Customer();
                customer.setFirstName("FirstName-" + random.nextInt());
                customer.setMiddleNames("MiddleNames-" + random.nextInt());
                customer.setLastName("LastName-" + random.nextInt());
                customer.setDob(new Date());
                customer.setEmail(random.nextInt() + "@email.com");
                customer.setTelephoneNumber(Integer.toString(random.nextInt()));

                appProducer.sendJsonMessage(customer);
            }
        }).start();
    }
}
