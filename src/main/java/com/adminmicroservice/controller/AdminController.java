package com.adminmicroservice.controller;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adminmicroservice.jwt.JwtUtil;
import com.adminmicroservice.model.Admin;
import com.adminmicroservice.repository.AdminRepository;
import com.adminmicroservice.security.AdminLoginDetails;
import com.adminmicroservice.security.AdminLoginDetailsService;

@CrossOrigin(origins="http://localhost:4200")

@RestController
@RequestMapping("/api/v1/admin/auth")
public class AdminController {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtils;
	
	@Autowired
	AdminLoginDetailsService adminLoginDetailsService;
	
	@PostMapping("/add")
	public String addAdmin(@RequestBody Admin admin) {
		try {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encPass = encoder.encode(admin.getPassword());
		admin.setPassword(encPass);
		adminRepository.save(admin);
		return "Admin Added Successfully!";
		} 
		catch (Exception e){
			e.printStackTrace();
			return "Could not add Admin!";
		}			
	}
	
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody Admin admin) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(admin.getAdminEmailId(), admin.getPassword()));
			if(authentication.isAuthenticated()) {
				AdminLoginDetails adminLoginDetails = (AdminLoginDetails) adminLoginDetailsService.loadUserByUsername(admin.getAdminEmailId()); 
				String token = jwtUtils.generateJwtToken(adminLoginDetails); 
				return token;
			}else {
				return "Authentication Failed!";
			}
		}catch(Exception e) {
			return "Authentication Failed! Check username & password.";
		}
	}
}
