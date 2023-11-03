package be.technobel.controllers.models.forms;

import be.technobel.controllers.models.entities.Categorie;
import be.technobel.controllers.models.validation.constraints.NotEquals;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import be.technobel.controllers.models.entities.Task;

import java.time.LocalDate;
@Data
public class TaskForm {
    @NotBlank
    @NotEquals
    private String name;
    @NotEquals
    private String description;
    @FutureOrPresent
    @NotNull
    private LocalDate deadline;
    @FutureOrPresent
    private LocalDate AddDate;
    private Categorie categorie;

    public Task toEntity(){

        Task task = new Task();

        task.setName(this.name);
        task.setDescription(this.description);
        task.setDeadline(this.deadline);
        task.setAddDate(this.AddDate);
        task.setCategorie(this.categorie);

        return task;

    }

    public static TaskForm fromEntity(Task task){

        TaskForm t= new TaskForm();
        t.setName(task.getName());
        t.setDescription(task.getDescription());
        t.setAddDate(task.getAddDate());
        t.setDeadline(task.getDeadline());
        t.setCategorie(task.getCategorie());

        return t;
    }
}

