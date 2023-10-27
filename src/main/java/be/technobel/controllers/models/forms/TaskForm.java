package be.technobel.controllers.models.forms;

import lombok.Data;
import be.technobel.controllers.models.entities.Task;

import java.time.LocalDate;
@Data
public class TaskForm {

    private String name;

    private String description;

    private LocalDate deadline;

    private LocalDate AddDate;

    public Task toEntity(){

        Task task = new Task();

        task.setName(this.name);
        task.setDescription(this.description);
        task.setDeadline(this.deadline);
        task.setAddDate(this.AddDate);

        return task;

    }

    public static TaskForm fromEntity(Task task){

        TaskForm t= new TaskForm();
        t.setName(task.getName());
        t.setDescription(task.getDescription());
        t.setAddDate(task.getAddDate());
        t.setDeadline(task.getDeadline());

        return t;
    }
}

