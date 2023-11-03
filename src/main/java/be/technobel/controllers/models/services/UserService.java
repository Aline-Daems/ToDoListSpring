package be.technobel.controllers.models.services;

import be.technobel.controllers.models.entities.User;

import java.util.List;

public interface UserService {

    User create (User user);

    List<User> getAll();

    User getOne (Long id);

    User update(User user, Long id);

    User delete(Long id);

}
