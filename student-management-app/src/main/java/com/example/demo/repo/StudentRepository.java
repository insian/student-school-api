package com.example.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	public List<Student> findAllByOrderByStudentIdAsc();
}
