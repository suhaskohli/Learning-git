package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HomeRepository extends JpaRepository<Student,Integer> {
    Optional<Student> findStudentByEmail(String email);
    Student findById(int id);
}
