package be.technobel.controllers.models.forms;

import be.technobel.controllers.models.entities.Categorie;
import be.technobel.controllers.models.entities.Task;
import be.technobel.controllers.models.entities.User;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class CategorieForm {
    private String name;
    private LocalDate creationDate;
    private LocalDate ModificationDate;
    private List<Task> tasks = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    public  Categorie toEntity(){

        Categorie categorie = new Categorie();

        categorie.setName(this.name);
        categorie.setCreationDate(this.creationDate);
        categorie.setModificationDate(this.ModificationDate);
        categorie.setTasks(this.tasks);
        categorie.setUsers(this.users);
        return categorie;
    }
    public static CategorieForm fromEntity(Categorie categorie){

        CategorieForm c = new CategorieForm();

        c.setName(categorie.getName());
        c.setCreationDate(categorie.getCreationDate());
        c.setModificationDate(categorie.getModificationDate());
        c.setTasks(categorie.getTasks());
        c.setUsers(categorie.getUsers());
        return c;

    }
}
