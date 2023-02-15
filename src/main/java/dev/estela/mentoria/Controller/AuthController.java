package dev.estela.mentoria.Controller;

import dev.estela.mentoria.Model.User;
import dev.estela.mentoria.Model.UserModel;
import dev.estela.mentoria.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(){
        return new ResponseEntity<String>("user is login", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> save(@Valid @RequestBody User user){
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }

}
