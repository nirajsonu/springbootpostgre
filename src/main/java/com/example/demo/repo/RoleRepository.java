package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
	 Optional<Role> findByName(String name);
}
