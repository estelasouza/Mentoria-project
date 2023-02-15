package dev.estela.mentoria.Producer;

import dev.estela.mentoria.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicProduce {
    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, Object> kafkaTemplate;
    public void send(User message){
        log.info("message sent");
        System.out.println(message);
        kafkaTemplate.send(topicName,message);
    }
}
