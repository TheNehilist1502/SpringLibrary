package com.project.user.controller;

import com.project.commonModule.models.Users;
import com.project.commonModule.repository.UserRepository;
import com.project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
   private final UserService userService;
   private  UserRepository repository;

    @GetMapping("/read")
    public List<Users> getUsers(){

        return userService.readUsers();
    }

    @PostMapping("/create")
    public List<Users> createUsers(@RequestBody List<Users> users){

        return userService.createUsers(users);
    }
    @DeleteMapping("/delete")

    public void deleteUsers(@RequestBody List<String> userNames){

        userService.deleteUsers(userNames);
    }


}
