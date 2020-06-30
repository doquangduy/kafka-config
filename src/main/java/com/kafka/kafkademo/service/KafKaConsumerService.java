package com.kafka.kafkademo.service;

import com.kafka.kafkademo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumerService {
    private final Logger logger
      = LoggerFactory.getLogger(KafKaConsumerService.class);

    @KafkaListener(topics = "${general.topic.name}",
      groupId = "${general.topic.group.id}")
    public void consume(String message) {
        logger.info(String.format("Message recieved -> %s", message));
    }

    @KafkaListener(topics = "${user.topic.name}",
      groupId = "${user.topic.group.id}",
      containerFactory = "userKafkaListenerContainerFactory")
    public void consume(User user) throws Exception {
        logger.info(String.format("ccxxxx User created -> %s", user));
//        throw new Exception("demo");
    }

    @KafkaListener(topics = "${user.topic.name}",
      groupId = "${user.topic.group.id_2}",
      containerFactory = "userKafkaListenerContainerFactory")
    public void consume2(User user) throws Exception {
        logger.info(String.format("xxxxxxxxxxxx User created -> %s", user));
//        throw new Exception("demo");
    }
}
