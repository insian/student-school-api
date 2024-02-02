package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.model.School;
import com.example.demo.repository.SchoolRepository;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class SchoolManagementSystemApplication {
	private final SchoolRepository schoolRepository;
	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementSystemApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		schoolRepository.save(new School("KVS"));
		schoolRepository.save(new School("DPS"));
	}

}
