package dev.estela.mentoria.Producer;

import dev.estela.mentoria.Model.User;
import dev.estela.mentoria.Model.UserModel;
import dev.estela.mentoria.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class Producer {
    private final TopicProduce topicProduce;
    @Autowired
    private UserService userService;

    @PostMapping(value = "/send")
    public  ResponseEntity<User> send(@Valid @RequestBody UserModel user)
    {
        System.out.println("aqui " +  user);
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        topicProduce.send(newUser);

        return new ResponseEntity<User>(userService.createUser(newUser), HttpStatus.CREATED);
    }
}
