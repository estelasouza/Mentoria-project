package dev.estela.mentoria.Consumer;

import dev.estela.mentoria.Model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class TopicConsumer {
    @Value("${topic.name.consumer}")
    private String topicName;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
    public void consumer(User payload){
        log.info("CONSUMER MESSAGE TEST");
        log.info("Tópico: {}", topicName);
//        log.info("key: {}", payload.key());
        log.info(String.format("User created -> %s", payload));
//        log.info("Partion: {}", payload.partition());
//        log.info("Order: {}", payload.value());

    }

}

