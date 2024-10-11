package com.ganesh.hospital.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.hospital.dto.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	
}
