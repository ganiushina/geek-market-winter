package com.geekbrains.geekmarketwinter.controllers;

import com.geekbrains.geekmarketwinter.entites.User;
import com.geekbrains.geekmarketwinter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    UserRepository userR;

//    @GetMapping
//    public String profilePage(Model model) {
//        return "profile";
//    }

    @GetMapping
    public String currentUser(@ModelAttribute("user") @Valid User userDto, Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String userName = loggedInUser.getName();
        User user = userR.findOneByUserName (userName);
        String firstname = user.getFirstName();
        String email = user.getEmail();
        model.addAttribute("firstName", firstname);
        model.addAttribute("emailAddress", email);

        return "profile";
    }
}
