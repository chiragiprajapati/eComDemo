package com.example.eComDemo.Service;

import com.example.eComDemo.Model.UserModel;
import com.example.eComDemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserModel createUser(String userName, String userEmail, String userPassword) {

        if (userRepository.existsByUsername(userName)) {
            throw new RuntimeException("User with this name already exists");
        }

        UserModel newUser = new UserModel(null, userName, userEmail, userPassword, null);
        return userRepository.save(newUser);
    }

    public boolean doesUserExist(String username, String useremail) {
        // Check if the user exists by username
        if (username != null && !username.isEmpty() && useremail == null || useremail.isEmpty()) {
            if (userRepository.findByusername(username).isPresent()) {
                return true; // User exists with this username
            }
        }

        // Check if the user exists by email
        if (useremail != null && !useremail.isEmpty() && username == null || username.isEmpty() ) {
            if (userRepository.findByuseremail(useremail).isPresent()) {
                return true; // User exists with this email
            }
        }

        if (username != null && !username.isEmpty() && useremail != null && !useremail.isEmpty()) {
            if (userRepository.findByUsernameAndUseremail(username, useremail).isPresent()) {
                return true; // User exists with both username and email
            }
        }

        return false; // No user exists with either username or email
    }
}
