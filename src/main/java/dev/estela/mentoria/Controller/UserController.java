package dev.estela.mentoria.Controller;

import dev.estela.mentoria.Model.User;
import dev.estela.mentoria.Model.UserModel;
import dev.estela.mentoria.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(Pageable page){
        return userService.getAllUsers(page);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> get(@PathVariable("id") Long id){
        return new ResponseEntity<User>(userService.getById(id), HttpStatus.OK);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<User> get(@RequestBody User user, @PathVariable("id") Long id){
        User newUser = userService.update(user,id);
        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> save(@Valid @RequestBody UserModel user){
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }
}
