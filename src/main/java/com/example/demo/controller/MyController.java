package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Students;
import com.example.demo.repo.StudentRepository;

import jakarta.validation.Valid;


@RestController
public class MyController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students/getAllStudents")
	public List<Students> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@PostMapping("/students")
	public Students createEmployee(@RequestBody Students students) {
		return studentRepository.save(students);
	}
	
	@GetMapping("/students/{uid}")
	public ResponseEntity<Students> getEmployeeById(@PathVariable(value = "uid") Long employeeId)throws ResourceNotFoundException {
		Students students = studentRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(students);
	}
	
	@PutMapping("/students/{uid}")
	public ResponseEntity<Students> updateEmployee(@PathVariable(value = "uid") Long employeeId,
			@Valid @RequestBody Students students) throws ResourceNotFoundException {
		Students students1 = studentRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("students not found for this uid :: " + students));

		students1.setUname(students.getUname());
		students1.setUcity(students.getUcity());	
		students1.setUrollnumber(students.getUrollnumber());
		final Students updatedStudents = studentRepository.save(students1);
		return ResponseEntity.ok(updatedStudents);
	}

	
	@DeleteMapping("/students/{uid}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "uid") Long employeeId)
			throws ResourceNotFoundException {
		Students students = studentRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		studentRepository.delete(students);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
