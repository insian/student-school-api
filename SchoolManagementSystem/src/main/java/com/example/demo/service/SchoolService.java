package com.example.demo.service;

import java.util.List;

import com.example.demo.model.School;

public interface SchoolService {
	List<School> getAllSchools();
	School createSchool(School school);
	School findSchoolById(int schoolId);
	void update(School school);
	void delete(int schoolId);
}
