package com.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class StudentUser {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "user_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String username;
    @Email
    @Column(nullable = false, unique = true)
    private String password;
//    @NotBlank
    @Transient
    private  Set<String> authorities;

    public StudentUser(){

    }

//    public StudentUser (String username, String password, Set<String> authorities){
    public StudentUser(String username, String password){
        this.username = username;
        this.password = password;
//        this.authorities = authorities.stream().map(str -> new Role(str)).collect(Collectors.toSet());
//        this.authorities = authorities;
    }


}
