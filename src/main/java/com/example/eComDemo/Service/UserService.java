package com.example.eComDemo.Service;

import com.example.eComDemo.Model.UserModel;

public interface UserService {
    UserModel createUser(String userName,String userEmail,String userPassword);
    boolean doesUserExist(String username, String email);
}

