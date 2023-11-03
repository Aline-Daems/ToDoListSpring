package be.technobel.controllers.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private LocalDate creationDate;
    private LocalDate ModificationDate;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "categorie_id")
    private List<Task> tasks = new ArrayList<>();

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "categorie_id")
    private List<User> users = new ArrayList<>();

}
