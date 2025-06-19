package com.example.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
