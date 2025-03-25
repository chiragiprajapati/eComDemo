package com.example.eComDemo.Repository;

import com.example.eComDemo.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//public interface UserRepository extends JpaRepository<UserModel, Long> {
//    UserModel findByUser_name(String user_name);
//}

public interface UserRepository extends JpaRepository<UserModel, Long> {
    boolean existsByUsername(String username);  // This method should match the field in the UserModel

    Optional<UserModel> findByusername(String username);  // This method should match the field in the UserModel
    Optional<UserModel> findByuseremail(String email);
    Optional<UserModel> findByUsernameAndUseremail(String username,String useremail);
}
