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

import com.example.demo.exception.SchoolNameAlreadyPresentException;
import com.example.demo.exception.SchoolNotFoundException;
import com.example.demo.model.School;
import com.example.demo.service.SchoolService;
import com.example.demo.ui.ErrorResponse;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/schools")
public class SchoolController {
	private final SchoolService schoolService;
	
	@ExceptionHandler(SchoolNotFoundException.class)
	public ErrorResponse handleException(SchoolNotFoundException e) {
		ErrorResponse response = new ErrorResponse();
		response.setMessage(e.getMessage());
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setToOfError(System.currentTimeMillis());
		return response;
	}
	
	@ExceptionHandler(SchoolNameAlreadyPresentException.class)
	public ErrorResponse handleException(SchoolNameAlreadyPresentException e) {
		ErrorResponse response = new ErrorResponse();
		response.setMessage(e.getMessage());
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setToOfError(System.currentTimeMillis());
		return response;
	}
	
	@GetMapping
	public ResponseEntity<?> listSchools(){
		return ResponseEntity.status(HttpStatus.OK).body(schoolService.getAllSchools());
	}
	
	@PostMapping
	public ResponseEntity<?> createSchool(@RequestBody School school) throws SchoolNameAlreadyPresentException{
		return ResponseEntity.status(HttpStatus.CREATED).body(schoolService.createSchool(school));
	}
	
	@GetMapping("/{schoolId}")
	public ResponseEntity<?> findSchoolById(@PathVariable int schoolId) throws SchoolNotFoundException{
		return ResponseEntity.status(HttpStatus.OK).body(schoolService.findSchoolById(schoolId));
	}
	
	@PutMapping("/{schoolId}")
	public void updateSchoolbyId(@PathVariable int schoolId, @RequestBody School school) throws SchoolNotFoundException, SchoolNameAlreadyPresentException{
		schoolService.update(schoolId, school);
	}
	
	@DeleteMapping("/{schoolId}")
	public void delete(@PathVariable int schoolId) throws SchoolNotFoundException{
		schoolService.delete(schoolId);
	}
}

