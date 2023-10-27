package be.technobel.controllers.models.services;

import be.technobel.controllers.models.entities.Task;

import java.util.List;

public interface TaskService {

    Task create(Task task);
    List<Task> getAll();

    Task delete(Long id);

    Task GetOne(Long id);

    Task Update(Task task, Long id);

    Task isFinish(Boolean isFinish, Long id);
    Task isNotFinish(Boolean isFinish, Long id);

    List<Task> searchFinishTask();

    List<Task> searchNotFinishTask();

    List<Task> deleteAllFinishedTask();



}
