package com.demo.repositories;

import com.demo.entities.StudentUser;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<StudentUser, Long> {
    @Query("SELECT * FROM student_user u WHERE u.username = ?1")
    Optional<StudentUser> findUserByUsername(String username);

}
