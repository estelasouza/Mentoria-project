package dev.estela.mentoria.Service;

import dev.estela.mentoria.Exception.ItemAlreadyExistsException;
import dev.estela.mentoria.Exception.ResourceNotFoundException;
import dev.estela.mentoria.Model.User;
import dev.estela.mentoria.Model.UserModel;
import dev.estela.mentoria.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public User createUser(UserModel user) {
        if(userRepo.existsByEmail(user.getEmail())){
            throw new ItemAlreadyExistsException("user is already registered with email:"+ user.getEmail());
        }
        User newUser = new User();
        System.out.println( "aqui o user " + user.toString());
        BeanUtils.copyProperties(user, newUser);
        return userRepo.save(newUser);

    }

    @Override
    public List<User> getAllUsers(Pageable page) {
        return userRepo.findAll(page).toList();
    }

    @Override
    public User getById(Long id) throws ResourceNotFoundException {
        return userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException(("user not found for the id "+ id)));
    }

    @Override
    public User update(User user, Long id) throws ResourceNotFoundException {
        User updateUser = getById(id);
        updateUser.setName(user.getName() != null ? user.getName() : updateUser.getName());
        updateUser.setAge(user.getAge() != null ? user.getAge() : updateUser.getAge());
        updateUser.setPassword(user.getPassword() != null ? user.getPassword() : updateUser.getPassword());
        return userRepo.save(updateUser);
    }
}
