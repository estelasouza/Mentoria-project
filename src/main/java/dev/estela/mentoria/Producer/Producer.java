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
        topicProduce.send(user);

        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }
}
