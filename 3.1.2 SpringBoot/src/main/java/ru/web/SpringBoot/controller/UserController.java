package ru.web.SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.web.SpringBoot.model.User;
import ru.web.SpringBoot.service.UserService;


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

    @GetMapping("/showUpdateUserForm/{id}")
    public String showUpdateUserForm(@PathVariable(value = "id") long id, Model model) {
        User user = userService.findByIdUser(id);
        model.addAttribute("updateUser", user);
        return "updateUserForm";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("newUser") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("updateUser") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}
