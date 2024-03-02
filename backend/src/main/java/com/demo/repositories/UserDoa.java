package com.demo.repositories;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDoa {
    private static final User user1 = new User(
            "admin.mail@gmail.com",
            "123",
            Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
    );

    private static final User user2 = new User(
            "user.mail@gmail.com",
            "456",
            Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
    );
    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            user1, user2
    );

    public UserDetails findUserByEmail(String email) {
        if (user1.getPassword() == null) {
            return new User(
                    "admin.mail@gmail.com",
                    "123",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            );
        }
        return APPLICATION_USERS
                .stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user was founded"));
    }
}



