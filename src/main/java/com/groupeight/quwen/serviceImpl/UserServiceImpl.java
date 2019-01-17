package com.groupeight.quwen.serviceImpl;

import com.groupeight.quwen.entity.User;
import com.groupeight.quwen.repository.UserRepository;
import com.groupeight.quwen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.validation.Valid;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void addUser(@Valid User user) {
        userRepository.save(user);
    }

    @Override
    public void login(User user, Model model) {
        if(!userRepository.existsByOpenid(user.getOpenid())){
            addUser(user);
            model.addAttribute("users",userRepository.findAll());
        }
        else{

        }
    }
}
