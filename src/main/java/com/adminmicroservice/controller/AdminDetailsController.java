package com.adminmicroservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adminmicroservice.model.Admin;
import com.adminmicroservice.repository.AdminRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1/admin")
public class AdminDetailsController {
	
	@Autowired
	AdminRepository adminRepository;
	
	@GetMapping("/alladmin")
	public List<Admin> getAllAdmin(){
		List<Admin> alladmin = adminRepository.findAll();
		return alladmin;
	}
	
	@GetMapping("/{email}")
	public Optional<Admin> getEmpById(@PathVariable("email") String email) {
		return adminRepository.findById(email);
	}
}
