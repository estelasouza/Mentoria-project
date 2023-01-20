package dev.estela.mentoria.Producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicProduce {
    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String,String> kafkaTemplate;
    public void send( String message){
        log.info("message sent");
        kafkaTemplate.send(topicName,message);
    }
}
