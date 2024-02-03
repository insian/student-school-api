package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "student")
public class Student {
	private int studentId;
	private String studentName;
	private String division;
	private String schoolName;
	
	
	public Student(String studentName, String division, String schoolName) {
		super();
		this.studentName = studentName;
		this.division = division;
		this.schoolName = schoolName;
	}
	
	
}
