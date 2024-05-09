package com.demo.repositories;

import com.demo.entities.Student;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Query("SELECT s FROM student s WHERE s.average_mark BETWEEN ?1 and ?2")
    Optional<List<Student>> getStudentsByAverageMarkBetween(Double minMark, Double maxMark);

}
