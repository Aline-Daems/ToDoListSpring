package be.technobel.controllers.models.services.impl;

import be.technobel.controllers.models.entities.Task;
import be.technobel.controllers.models.entities.User;
import be.technobel.controllers.models.repositories.UserRepository;
import be.technobel.controllers.models.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
       List<User> users = userRepository.findAll();

       return  users;
    }

    @Override
    public User getOne(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User update(User user, Long id) {
        User existingUser = getOne(id);

        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setPassword(user.getPassword());
        existingUser.setLogin(user.getLogin());
        existingUser.setBirthday(user.getBirthday());
        return userRepository.save(existingUser);
    }

    @Override
    public User delete(Long id) {
        User existingUser = getOne(id);

        userRepository.delete(existingUser);

        return existingUser;
    }


}
