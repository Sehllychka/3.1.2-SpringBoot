package ru.web.SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.web.SpringBoot.model.User;
import ru.web.SpringBoot.service.UserService;

import javax.validation.Valid;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("users", userService.getUser());
        return "start";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("newUser", user);
        return "addUserForm";
    }

    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/addUserForm";
        }
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/showUpdateUserForm")
    public String showUpdateUserForm(@RequestParam(value = "id") long id, Model model) {
        User user = userService.findByIdUser(id);
        model.addAttribute("updateUser", user);
        return "updateUserForm";
    }

    @PostMapping("/updateUser")
    public String updateUser(@Valid @ModelAttribute("updateUser") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "/updateUserForm";
        }
        userService.updateUser(user);
        return "redirect:/";
    }


    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam(value = "id") long id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}
