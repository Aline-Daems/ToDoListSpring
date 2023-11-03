package be.technobel.controllers.models.controllers;

import be.technobel.controllers.models.dto.CategorieDto;
import be.technobel.controllers.models.dto.TaskDTO;
import be.technobel.controllers.models.dto.UserDTO;
import be.technobel.controllers.models.entities.Categorie;
import be.technobel.controllers.models.entities.Task;
import be.technobel.controllers.models.entities.User;
import be.technobel.controllers.models.forms.CategorieForm;
import be.technobel.controllers.models.services.CategorieService;
import be.technobel.controllers.models.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/categorie")
public class CategorieController {

    private final CategorieService categorieService;
    private final UserService userService;

    public CategorieController(CategorieService categorieService, UserService userService) {
        this.categorieService = categorieService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String getCreate(Model model){

        model.addAttribute("categorie", new CategorieForm());
        List<User> users = userService.getAll();
        List<UserDTO> dtosUser = users.stream().map(UserDTO::fromEntity).toList();
        model.addAttribute("users", dtosUser);
        return "categorie/create";
    }

    @PostMapping("/create")
    public String PostCreate(@ModelAttribute("Categorie") CategorieForm categorieForm){

        categorieService.create(categorieForm.toEntity());

        return "redirect:/categorie";
    }

    @GetMapping
    public String getAll(Model model){

        List<Categorie> categorieList = categorieService.getAll();
        List<CategorieDto> dtos = categorieList.stream().map(CategorieDto::fromEntity).toList();
        model.addAttribute("categories", dtos);
        return "categorie/index";

    }
    @GetMapping("/allCatTasks")
    public String getAllTasks(Model model){

        List<Categorie> categorieList = categorieService.getAll();
        List<CategorieDto> dtos = categorieList.stream().map(CategorieDto::fromEntity).toList();
        model.addAttribute("categories", dtos);
        return "task/create";

    }



    @GetMapping("/{id}")
    public String findOne(@PathVariable Long id, Model model){

        Categorie categorie = categorieService.getOne(id);
        CategorieDto dto = CategorieDto.fromEntity(categorie);
        model.addAttribute("categorie", dto);
        return "catgorie/detail";
    }

    @GetMapping("/delete/{id}")
    public  String delete (@PathVariable Long id){

        categorieService.delete(id);
        return "redirect:/categorie";
    }

    @GetMapping("update/{id}")
    public String getUpdate(@PathVariable long id, Model model){
        Categorie categorie = categorieService.getOne(id);

        CategorieForm form = CategorieForm.fromEntity(categorie);

        model.addAttribute("id", id);
        model.addAttribute("categorie", form);

        return "/categorie/update";
    }

    @PostMapping("/update/{id}")
    public String postUpdate(@PathVariable long id, @ModelAttribute CategorieForm form){
        categorieService.update(form.toEntity(), id);

        return "redirect:/categorie";
    }


    @GetMapping ("CategorieUsers")
    public String CatUsers(Model model){
        List<User> users = categorieService.findUsers();
        users.sort(Comparator.comparing(User::getId));
        List<UserDTO> dtos = users.stream().map(UserDTO::fromEntity).toList();
        model.addAttribute("users", dtos);
        return "categorie/create";


    }
}
