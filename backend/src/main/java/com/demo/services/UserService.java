package com.demo.services;

//import com.demo.entities.StudentUser;
import com.demo.entities.StudentUser;
import com.demo.exeptions.UserNotFoundException;
import com.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public  User findUserByEmail(String username) {
        Optional <StudentUser> test = userRepository.findUserByUsername(username);

        StudentUser studentUser = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("studentUser with email " + username + " does not exist"));
        return new User(studentUser.getUsername(), studentUser.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))) ;
    }

    public void saveAll(List<StudentUser> usersList) {
        userRepository.saveAll(usersList);
    }
}
