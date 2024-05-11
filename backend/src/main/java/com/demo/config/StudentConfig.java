package com.demo.config;

//import src.main.java.com.demo.entities.Student;
//import src.main.java.com.demo.repositories.StudentRepository;
import com.demo.entities.Student;
import com.demo.repositories.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {

    // Spring runs CommandLineRunner bean when Spring Boot App starts
    // Inserting initial data into student table
    @Bean
    CommandLineRunner studentCommandLineRunner(StudentRepository repository) {
        return args -> {
            Student piter = new Student(1L, "Piter", "piter.smithon@gmail.com",
                    LocalDate.of(2005, Month.MAY, 17), 75.5);

            Student alex = new Student(2L, "Alex", "alex.spenser@gmail.com",
                    LocalDate.of(2003, Month.NOVEMBER, 25), 65.6);
            repository.saveAll(
                    List.of(piter, alex)
            );
            repository.saveAll(generateStudents ());
        };
    }

    private List<Student> generateStudents (){
        Faker faker = new Faker();
        List<Student> studentList = new ArrayList<>();
        for (long i=3; i < 33; i++){
            Student student = new Student(i, faker.name().name(), faker.internet().emailAddress(),
                    faker.date().birthday(18, 100).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    faker.random().nextInt(10000)/100.0);
            studentList.add(new Student(i, faker.name().name(), faker.internet().emailAddress(),
                    faker.date().birthday(18, 100).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    faker.random().nextInt(10000)/100.0));
        }
        return studentList;
    }
}
