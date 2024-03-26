package com.demo.repositories;

//import org.springframework.security.core.userdetails.StudentUser;


import com.demo.entities.StudentUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

//@Repository
public class UserDoa {

//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository repository) {
//        return args -> {
//            StudentUser user1 = new StudentUser(
//                    "admin.mail@gmail.com",
//                    "123",
//                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
//            );
//
//            StudentUser user2 = new StudentUser(
//                    "user.mail@gmail.com",
//                    "456",
//                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
//            );
//            repository.saveAll(
//                    List.of(user1, user2)
//            );
//        };
//    }
    private static final StudentUser user1 = new StudentUser(
            "admin.mail@gmail.com",
            "123"

    );
//
//    private static final StudentUser user2 = new StudentUser(
//            "user.mail@gmail.com",
//            "456",
//            Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
//    );
//    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
//            user1, user2
//    );

//    public StudentUser findUserByEmail(String email) {
////        if (user1.getPassword() == null) {
////            return new StudentUser(
////                    "admin.mail@gmail.com",
////                    "123",
////                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
////            );
////        }
//        return APPLICATION_USERS
//                .stream()
//                .filter(u -> u.getUsername().equals(email))
//                .findFirst()
//                .orElseThrow(() -> new UsernameNotFoundException("No user was founded"));
//    }
}



