package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	    Optional<Users> findByEmail(String email);
	    Optional<Users> findByUsernameOrEmail(String username, String email);
	    Optional<Users> findByUsername(String username);
	    Boolean existsByUsername(String username);
	    Boolean existsByEmail(String email);
}
