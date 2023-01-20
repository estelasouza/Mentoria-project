package dev.estela.mentoria.Producer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class Producer {
    private final TopicProduce topicProduce;

    @GetMapping(value = "/send")
    public void send(){
        topicProduce.send("message test send to topic");
    }
}
