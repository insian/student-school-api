package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.SchoolNameAlreadyPresentException;
import com.example.demo.exception.SchoolNotFoundException;
import com.example.demo.model.School;

public interface SchoolService {
	List<School> getAllSchools();
	School createSchool(School school) throws SchoolNameAlreadyPresentException;
	School findSchoolById(int schoolId) throws SchoolNotFoundException;
	void update(int schoolId, School school) throws SchoolNotFoundException, SchoolNameAlreadyPresentException;
	void delete(int schoolId) throws SchoolNotFoundException;
}
