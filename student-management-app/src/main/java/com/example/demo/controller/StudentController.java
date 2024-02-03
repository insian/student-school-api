package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.example.demo.ui.ErrorResponse;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {
	private final StudentService studentService;
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ErrorResponse handleException(StudentNotFoundException e) {
		ErrorResponse response = new ErrorResponse();
		response.setMessage(e.getMessage());
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setToOfError(System.currentTimeMillis());
		return response;
	}
	
	@GetMapping
	public ResponseEntity<?> listStudents(){
		return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
	}
	
	@PostMapping
	public ResponseEntity<?> createStudent(@RequestBody Student student){
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<?> findStudentById(@PathVariable("studentId") int studentId) throws StudentNotFoundException{
		return ResponseEntity.status(HttpStatus.OK).body(studentService.findStudentById(studentId));
	}
	
	@PutMapping("/{studentId}")
	public void updateStudentById(@PathVariable int studentId, @RequestBody Student student) throws StudentNotFoundException{
		studentService.udpate(studentId, student);
	}
	
	@DeleteMapping("/{studentId}")
	public void delete(@PathVariable int studentId) throws StudentNotFoundException{
		studentService.delete(studentId);
	}
	
	
	
}
