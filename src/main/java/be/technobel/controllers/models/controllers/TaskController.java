package be.technobel.controllers.models.controllers;

import be.technobel.controllers.models.dto.CategorieDto;
import be.technobel.controllers.models.dto.TaskDTO;
import be.technobel.controllers.models.entities.Categorie;
import be.technobel.controllers.models.entities.Task;
import be.technobel.controllers.models.forms.TaskForm;
import be.technobel.controllers.models.services.CategorieService;
import be.technobel.controllers.models.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    private final CategorieService categorieService;
    public TaskController(TaskService taskService, CategorieService categorieService){

        this.taskService= taskService;
        this.categorieService = categorieService;
    }


    @GetMapping("/create")
    public String getCreate(Model model){
        TaskForm taskForm = new TaskForm();
        model.addAttribute("task", new TaskForm());
        taskForm.setAddDate(LocalDate.now());
        List<Categorie> categorieList = categorieService.getAll();
        List<CategorieDto> dtosCat = categorieList.stream().map(CategorieDto::fromEntity).toList();
        model.addAttribute("categories", dtosCat);
        return "task/create";
    }

    @PostMapping("/create")
    public String postCreate(@ModelAttribute ("task") @Valid TaskForm task, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "task/create";
        }
        taskService.create(task.toEntity());
        return"redirect:/task";
    }

    @GetMapping
    public String findAll(Model model) {

        List<Task> tasks= taskService.getAll();
        tasks.sort(Comparator.comparing(Task::getId));
        List<TaskDTO> dtos = tasks.stream().map(TaskDTO::fromEntity).toList();
        model.addAttribute("tasks", dtos);



        return "task/index";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable Long id, Model model){

        Task task = taskService.GetOne(id);
        TaskDTO dto = TaskDTO.fromEntity(task);
        model.addAttribute("task", dto);
        return "task/detail";
    }

    @GetMapping("delete/{id}")
    public String delete (@PathVariable Long id){

        taskService.delete(id);
        return"redirect:/task";
    }

    @GetMapping("update/{id}")
    public String getUpdate(@PathVariable Long id, Model model){

        Task task = taskService.GetOne(id);
        TaskForm form = TaskForm.fromEntity(task);


        model.addAttribute("id", id);
        model.addAttribute("task", form);
        return "/task/update";
    }


    @PostMapping("/update/{id}")
    public String PostUpdate(@PathVariable Long id, @ModelAttribute TaskForm form){

        Task task = form.toEntity();


        taskService.Update(task, id);
        return "redirect:/task";
    }

    @GetMapping("/finish/{id}")
    public String isFinished (@PathVariable Long id, Model model) {

        taskService.isFinish(true,id);
        model.addAttribute("id", id);
        return "redirect:/task";

    }
    @GetMapping("/Notfinish/{id}")
    public String isNotFinished (@PathVariable Long id, Model model) {

        taskService.isNotFinish(false,id);
        model.addAttribute("id", id);
        return "redirect:/task";

    }

    @GetMapping("/TaskFinished/")
    public String finishedTask(Model model){

        List<Task> tasks = taskService.searchFinishTask();
        tasks.sort(Comparator.comparing(Task::getId));
        List<TaskDTO> dtos = tasks.stream().map(TaskDTO::fromEntity).toList();
        model.addAttribute("tasks", dtos);
        return "task/finishedTask";

    }

    @GetMapping("/TaskNotFinished/")
    public String NotfinishedTask(Model model){

        List<Task> tasks = taskService.searchNotFinishTask();
        tasks.sort(Comparator.comparing(Task::getId));
        List<TaskDTO> dtos = tasks.stream().map(TaskDTO::fromEntity).toList();
        model.addAttribute("tasks", dtos);
        return "task/NotFinishedTask";

    }

    @GetMapping("/deleteFinishedTask/")
    public String deleteFinishedTask (){

        taskService.deleteAllFinishedTask();

        return "redirect:/task";
    }



}
