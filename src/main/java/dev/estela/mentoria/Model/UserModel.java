package dev.estela.mentoria.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserModel {

    @NotBlank(message = "please enter name")
    private String name;

    @NotNull(message = "please enter email")
    @Email(message = "please enter validation email")
    private String email;

    @Size(min = 5, message = "password should be atleast t characters")
    private String password;

    private Long age = 0L;
}
