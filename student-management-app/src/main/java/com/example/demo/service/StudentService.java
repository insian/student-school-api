package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;

public interface StudentService {
	List<Student> getAllStudents();
	Student createStudent(Student student);
	Student findStudentById(int studentId) throws StudentNotFoundException;
	void udpate(int studentId, Student student) throws StudentNotFoundException;
	void delete(int studentId) throws StudentNotFoundException;
}
