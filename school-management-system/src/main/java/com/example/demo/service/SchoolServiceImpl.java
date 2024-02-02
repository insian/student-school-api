package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.SchoolNameAlreadyPresentException;
import com.example.demo.exception.SchoolNotFoundException;
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
		return (List<School>) schoolRepository.findAllByOrderBySchoolIdAsc();
	}

	@Override
	public School createSchool(School school) throws SchoolNameAlreadyPresentException{
		try{
			schoolRepository.save(school);
		} catch(Exception e) {
			throw new SchoolNameAlreadyPresentException(school.getSchoolName()+" school name already present");
		}
		return school;
	}
	
	@Override
	public School findSchoolById(int schoolId) throws SchoolNotFoundException{
		Optional<School> result = schoolRepository.findById(schoolId);
		School theSchool = null;
		
		if (result.isPresent()) {
			theSchool = result.get();
		}
		else {
			// we didn't find the employee
			throw new SchoolNotFoundException("Did not find school id - " + schoolId);
		}
		return theSchool;
	}

	@Override
	public void update(int schoolId, School school) throws SchoolNotFoundException, SchoolNameAlreadyPresentException {
		// TODO Auto-generated method stub
		School theSchool =  findSchoolById(schoolId);
		theSchool.setSchoolName(school.getSchoolName());;
		try{
			schoolRepository.save(theSchool);
		} catch(Exception e) {
			throw new SchoolNameAlreadyPresentException(school.getSchoolName()+" school name already present");
		}
	}

	@Override
	public void delete(int schoolId) throws SchoolNotFoundException {
		// TODO Auto-generated method stub
		School theSchool = findSchoolById(schoolId);
		schoolRepository.delete(theSchool);
	}
}
