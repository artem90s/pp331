package com.example.pp331.controller;

import com.example.pp331.entity.User;
import com.example.pp331.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService (UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public String allUsers(Model model){
        List<User>all=userService.usersList();
        model.addAttribute("users", all);
        return "users";
    }

    @GetMapping("/{id}")
    public String userById(@PathVariable ("id")int id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "one-of-users";
    }
    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "new";
        }
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id")int id, Model model){
        model.addAttribute("user",userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update (@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "edit";
        }
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute ("user") User user){
        userService.deleteUser(user);
        return "redirect:/";

    }


}
