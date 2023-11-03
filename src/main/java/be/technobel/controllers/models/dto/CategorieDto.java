package be.technobel.controllers.models.dto;

import be.technobel.controllers.models.entities.Categorie;
import be.technobel.controllers.models.entities.Task;
import be.technobel.controllers.models.entities.User;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO for {@link be.technobel.controllers.models.entities.Categorie}
 */
@Data
public class CategorieDto{
    private long id;
    String name;
    LocalDate creationDate;
    LocalDate ModificationDate;
    private List<Task> tasks = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public static CategorieDto fromEntity(Categorie categorie){

        CategorieDto c = new CategorieDto();

        c.setId(categorie.getId());
        c.setName(categorie.getName());
        c.setCreationDate(categorie.getCreationDate());
        c.setModificationDate(categorie.getModificationDate());
        c.setTasks(categorie.getTasks());
        c.setUsers(categorie.getUsers());

        return  c;


    }

}