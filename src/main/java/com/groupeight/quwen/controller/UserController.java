package com.groupeight.quwen.controller;

import com.groupeight.quwen.entity.User;
import com.groupeight.quwen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    public UserController ( UserService userService ){
        this.userService = userService;
    }
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String login(@Valid User user, Model model){
        userService.login(user,model);
        return "hello";
    }
}
