package be.technobel.controllers.models.dto;

import lombok.Data;
import be.technobel.controllers.models.entities.Task;

import java.time.LocalDate;

@Data
public class TaskDTO {

    private long id;

    private String name;

    private String description;

    private LocalDate deadline;

    private LocalDate AddDate;

    private Boolean finish;

    public static TaskDTO fromEntity(Task task){

        TaskDTO t= new TaskDTO();

        t.setId(task.getId());
        t.setName(task.getName());
        t.setDescription(task.getDescription());
        t.setDeadline(task.getDeadline());
        t.setAddDate(task.getAddDate());
        t.setFinish(task.getFinish());

        return t;
    }
}


