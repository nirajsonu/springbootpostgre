package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Students;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Students,Long>{
		
}
