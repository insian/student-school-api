package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.School;
import com.example.demo.repository.SchoolRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SchoolServiceImpl implements SchoolService{
	private final SchoolRepository schoolRepository;
	
	@Override
	public List<School> getAllSchools() {
		// TODO Auto-generated method stub
		return (List<School>) schoolRepository.findAll();
	}

	@Override
	public School createSchool(School school) {
		schoolRepository.save(school);
		return school;
	}
	
	@Override
	public School findSchoolById(int schoolId) {
		Optional<School> result = schoolRepository.findById(schoolId);
		School theSchool = null;
		
		if (result.isPresent()) {
			theSchool = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find school id - " + schoolId);
		}
		return theSchool;
	}

	@Override
	public void update(School school) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int schoolId) {
		// TODO Auto-generated method stub
		
	}

	

}
