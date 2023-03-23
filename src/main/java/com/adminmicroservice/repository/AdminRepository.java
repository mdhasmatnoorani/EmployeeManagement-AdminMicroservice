package com.adminmicroservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adminmicroservice.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	
}
