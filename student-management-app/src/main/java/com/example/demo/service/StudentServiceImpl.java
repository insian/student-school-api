package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
	private final StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAllByOrderByStudentIdAsc();
	}

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student findStudentById(int studentId) throws StudentNotFoundException {
		Optional<Student> result = studentRepository.findById(studentId);
		Student theStudent = null;
		if(result.isPresent()) {
			theStudent = result.get();
		}
		else {
			throw new StudentNotFoundException("Student with id: "+studentId+" is not present");
		}
		return theStudent;
	}

	@Override
	public void udpate(int studentId, Student student) throws StudentNotFoundException {
		Student theStudent = findStudentById(studentId);
		theStudent.setStudentName(student.getStudentName());
		theStudent.setDivision(student.getDivision());
		theStudent.setSchoolName(student.getSchoolName());
		studentRepository.save(theStudent);
	}

	@Override
	public void delete(int studentId) throws StudentNotFoundException {
		Student theStudent = findStudentById(studentId);
		studentRepository.delete(theStudent);
	}

}
