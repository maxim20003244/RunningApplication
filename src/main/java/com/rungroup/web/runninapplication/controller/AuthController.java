package com.rungroup.web.runninapplication.controller;

import com.rungroup.web.runninapplication.dto.RegistrationDto;
import com.rungroup.web.runninapplication.models.UserEntity;
import com.rungroup.web.runninapplication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/register")
    public String getRegisterFrom(Model model){
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";

    }

    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user,
                           BindingResult result, Model model){
        UserEntity existingUsersEmail = userService.findByEmail(user.getEmail());
        if(existingUsersEmail!=null && existingUsersEmail.getEmail()!=null && !existingUsersEmail.getEmail().isEmpty()){
            result.rejectValue("email","There is already a user with this email/username");
        }
        UserEntity existingUserUserName = userService.findByUserName(user.getUserName());
        if(existingUserUserName!=null && existingUserUserName.getUsername()!=null && !existingUserUserName.getUsername().isEmpty()){
            result.rejectValue("email","There is already a user with this email/username");
        }
        if(result.hasErrors()){
              model.addAttribute("user", user);
              return "register";
        }
        userService.saveUser(user);
        return "redirect:/clubs?success";
    }
}
