package com.groupeight.quwen.service;

import com.groupeight.quwen.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.validation.Valid;

@Service
public interface UserService {
    public void addUser(@Valid User user);
    public void login(User user, Model model);
}
