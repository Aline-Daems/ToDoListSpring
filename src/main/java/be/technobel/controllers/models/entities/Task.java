package be.technobel.controllers.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private LocalDate deadline;

    private LocalDate AddDate;

    private Boolean finish = false;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

}
