package be.technobel.controllers.models.services.impl;

import be.technobel.controllers.models.entities.Task;
import be.technobel.controllers.models.repositories.TaskRepository;
import be.technobel.controllers.models.services.TaskService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {

        this.taskRepository = taskRepository;
    }


    @Override
    public Task create(Task task) {
        LocalDate addDate = task.getAddDate();


        if(addDate == null){
            task.setAddDate(LocalDate.now());
        }


        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAll() {
        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }

    @Override
    public Task GetOne(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }


    @Override
    public Task delete(Long id) {
        Task existingTask = GetOne(id);
        taskRepository.delete(existingTask);
        return existingTask;
    }

    @Override
    public Task Update(Task task, Long id) {
        Task existingTask = GetOne(id);

        existingTask.setName(task.getName());
        existingTask.setDescription(task.getDescription());
        existingTask.setAddDate(task.getAddDate());
        existingTask.setDeadline(task.getDeadline());

        return taskRepository.save(existingTask);

    }

    @Override
    public Task isFinish(Boolean isFinish, Long id) {

        Task existingTask = GetOne(id);

        existingTask.setFinish(true);
        return taskRepository.save(existingTask);
    }

    @Override
    public Task isNotFinish(Boolean isFinish, Long id) {

        Task existingTask = GetOne(id);

        existingTask.setFinish(false);
        return taskRepository.save(existingTask);

    }

    @Override
    public List<Task> searchFinishTask() {
        return taskRepository.findFinishedTasks();
    }

    @Override
    public List<Task> searchNotFinishTask() {
        return taskRepository.findNotFinishedTasks();
    }


    @Override
    public List<Task> deleteAllFinishedTask() {

      return taskRepository.deleteByFinishIsTrue();


    }
}
