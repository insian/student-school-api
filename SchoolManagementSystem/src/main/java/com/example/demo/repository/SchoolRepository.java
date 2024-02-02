package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.School;

public interface SchoolRepository extends CrudRepository<School, Integer>{

}