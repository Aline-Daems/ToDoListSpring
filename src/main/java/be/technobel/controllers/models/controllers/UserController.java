package be.technobel.controllers.models.controllers;

import be.technobel.controllers.models.dto.UserDTO;
import be.technobel.controllers.models.entities.User;
import be.technobel.controllers.models.forms.UserForm;
import be.technobel.controllers.models.services.UserService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){

        this.userService = userService;

    }

    @GetMapping("/create")
    public String getCreate(Model model){
        model.addAttribute("user", new UserForm());

        return "user/create";

    }

    @PostMapping("/create")
        public String postCreate ( @ModelAttribute("user") UserForm user) {

        userService.create(user.toEntity());

        return "redirect:/user";
    }

    @GetMapping
    public String findAll(Model model){

        List<User> users = userService.getAll();

        List<UserDTO> dtos = users.stream().map(UserDTO::fromEntity).toList();
        model.addAttribute("users", dtos);

        return "user/index";
    }

     @GetMapping("/{id}")
    public String findOne( @PathVariable long id, Model model){

        User user = userService.getOne(id);

        UserDTO dto = UserDTO.fromEntity(user);
        model.addAttribute("user", dto);

        return "user/detail";
     }

     @GetMapping("update/{id}")
    public String getUpdate(@PathVariable long id, Model model){

        User user = userService.getOne(id);

        UserForm form = UserForm.fromEntity(user);

        model.addAttribute("id", id);
        model.addAttribute("user", form);

        return "/user/update";


     }
    @PostMapping("/update/{id}")
    public  String PostUpdate(@PathVariable Long id,  @ModelAttribute UserForm form){

        userService.update(form.toEntity(), id);
        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){

        userService.delete(id);

        return "redirect:/user";
    }

}
