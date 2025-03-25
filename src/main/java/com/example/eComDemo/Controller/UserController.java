package com.example.eComDemo.Controller;

import com.example.eComDemo.Model.UserModel;
import com.example.eComDemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public UserModel createUser(@RequestBody UserModel user)
    {
        return userService.createUser(user.getUsername(), user.getUseremail(), user.getUserpassword());
    }

    @GetMapping("/existsUser")
    public ResponseEntity<Boolean> checkIfUserExists(@RequestParam(required = false) String username,
                                                     @RequestParam(required = false) String useremail) {
        boolean exists = userService.doesUserExist(username, useremail);
        return ResponseEntity.ok(exists);
    }

}

