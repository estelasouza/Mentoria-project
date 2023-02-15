package dev.estela.mentoria.Service;

import dev.estela.mentoria.Model.User;
import dev.estela.mentoria.Model.UserModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers(Pageable page);

    User getById(Long id);

    User update(User user, Long id);
}
