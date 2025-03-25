package com.example.eComDemo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_list")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column (name = "user_name")
    private String username;
    @Column (name = "user_email")
    private String useremail;
    @Column (name = "user_password")
    private String userpassword;
    @Column (name = "created_time")
    private LocalDateTime createdtime;

    @PrePersist
    public void prePersist() {
        // Automatically set createdTime before saving
        this.createdtime = LocalDateTime.now();
    }

}
