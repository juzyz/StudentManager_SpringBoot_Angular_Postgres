package com.demo.config;

//import src.main.java.com.demo.entities.Student;
//import src.main.java.com.demo.repositories.StudentRepository;
import com.demo.entities.Student;
import com.demo.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    // Spring runs CommandLineRunner bean when Spring Boot App starts
    // Inserting initial data into student table
    @Bean
    CommandLineRunner studentCommandLineRunner(StudentRepository repository) {
        return args -> {
            Student piter = new Student(1L, "Piter", "piter.smithon@gmail.com",
                    LocalDate.of(2005, Month.MAY, 17));

            Student alex = new Student(2L, "Alex", "alex.spenser@gmail.com",
                    LocalDate.of(2003, Month.NOVEMBER, 25));
            repository.saveAll(
                    List.of(piter, alex)
            );
        };
    }
}
