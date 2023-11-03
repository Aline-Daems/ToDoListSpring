package be.technobel.controllers.models.forms;

import be.technobel.controllers.models.entities.Categorie;
import be.technobel.controllers.models.entities.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserForm {

    private String firstname;

    private String lastname;

    private String login;

    private String password;

    private LocalDate birthday;
    private Categorie categorie;

    public User toEntity () {

        User user = new User();

        user.setFirstname(this.firstname);
        user.setLastname(this.lastname);
        user.setLogin(this.login);
        user.setPassword(this.password);
        user.setBirthday(this.birthday);
        user.setCategorie(this.categorie);
        return user;
    }

    public static UserForm fromEntity(User user){
        UserForm u = new UserForm();
        u.setFirstname(user.getFirstname());
        u.setLastname(user.getLastname());
        u.setLogin(user.getLogin());
        u.setPassword(user.getPassword());
        u.setBirthday(user.getBirthday());
        u.setCategorie(user.getCategorie());

        return u;
    }
}
