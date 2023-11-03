package be.technobel.controllers.models.dto;

import be.technobel.controllers.models.entities.User;
import lombok.Data;

import java.time.LocalDate;
@Data
public class UserDTO {

    private long id;

    private String firstname;

    private String lastname;

    private String login;

    private String password;

    private LocalDate birthday;

    public static UserDTO fromEntity(User user){

        UserDTO u = new UserDTO();

        u.setId(user.getId());
        u.setFirstname(user.getFirstname());
        u.setLastname(user.getLastname());
        u.setLogin(user.getLogin());
        u.setBirthday(user.getBirthday());
        return u;
    }

}
