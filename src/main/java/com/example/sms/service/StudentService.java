package com.example.sms.service;

import com.example.sms.model.Student;
import com.example.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student save(Student s) {
        return repo.save(s);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Optional<Student> getById(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

	public Student update(Long id, Student s) {
		// TODO Auto-generated method stub
		Optional<Student> existingStudent = repo.findById(id);
		if (existingStudent.isPresent()) {
			Student studentToUpdate = existingStudent.get();
			studentToUpdate.setName(s.getName());
			studentToUpdate.setDegree(s.getDegree());
			studentToUpdate.setDob(s.getDob());
			studentToUpdate.setGender(s.getGender());
			studentToUpdate.setContact(s.getContact());
			studentToUpdate.setEmail(s.getEmail());
			return repo.save(studentToUpdate);
		} else {
			return null; // or throw an exception
		}
	}
}
