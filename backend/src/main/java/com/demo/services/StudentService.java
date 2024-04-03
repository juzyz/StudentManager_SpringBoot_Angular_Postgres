package com.demo.services;


import com.demo.entities.Student;
import com.demo.exeptions.BadRequestException;
import com.demo.exeptions.StudentNotFoundException;
import com.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(()-> new StudentNotFoundException(
                        "student with id " + studentId + " does not exist"));
    }
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new BadRequestException( "Email " + student.getEmail() + " taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.findById(studentId)
                .orElseThrow(()-> new StudentNotFoundException(
                        "student with id " + studentId + " does not exist"));
        studentRepository.deleteById(studentId);
    }

//    @Transactional // for multiple updates to assure they happen all-or-none.
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(
                        "student with id " + studentId + " does not exist")
                );
        if(name != null && name.length() >0 &&
                !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if(email != null && email.length() >0 &&
                !Objects.equals(student.getEmail(), email)){
            student.setEmail(email);
        }
        studentRepository.save(student);
    }
}
