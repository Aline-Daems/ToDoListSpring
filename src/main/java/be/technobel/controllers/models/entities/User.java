package be.technobel.controllers.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name="User_")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstname;

    private String lastname;

    private String login;

    private String password;

    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

}
