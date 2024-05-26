package com.demo.services;

import com.demo.entities.Student;
import com.demo.exeptions.BadRequestException;
import com.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;

@Service
public class AverageMarkService {
    private final StudentRepository studentRepository;

    @Autowired
    public AverageMarkService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//{
//    75.5: {"studenName 1", email1, 05/05/2000, 75.5},
//    81.3: {"studenName 2", email2, 06/06/2000, 81.3}
//}
    public SortedMap getStudentsByMarkRange(Double min, Double max) {
        List<Student> studentList = studentRepository.findAll();
        //Transfer List to TreeMap
        TreeMap<Double, Student> averageMarkMap = new TreeMap<>();
        for (Student student : studentList) {
            averageMarkMap.put(student.getAverageMark(), student);
        }
        return averageMarkMap.subMap(min, max);
    }


    //    public List<Student> getStudentsByMarkRange(Double min, Double max) {
//        Optional<List<Student>> studentList = studentRepository.getStudentsByMarkRange(min, max);
//        if (studentList.isPresent()){
//            return studentList.get();
//        } else {
//            throw new BadRequestException("Students with average mark between "
//                    + min + " and " + max + " are not founded.");
//        }
//
//    }
}
