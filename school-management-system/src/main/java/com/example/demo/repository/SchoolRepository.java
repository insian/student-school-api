package com.example.demo.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.School;

public interface SchoolRepository extends CrudRepository<School, Integer>{
	public List<School> findAllByOrderBySchoolIdAsc();
}