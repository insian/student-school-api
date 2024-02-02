package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.School;
import com.example.demo.service.SchoolService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/schools")
public class SchoolController {
	private final SchoolService schoolService;
	
	@GetMapping
	public ResponseEntity<?> listSchools(){
		return ResponseEntity.status(HttpStatus.OK).body(schoolService.getAllSchools());
	}
	
	@PostMapping
	public ResponseEntity<?> createSchool(@RequestBody School school){
		return ResponseEntity.status(HttpStatus.CREATED).body(schoolService.createSchool(school));
	}
}
