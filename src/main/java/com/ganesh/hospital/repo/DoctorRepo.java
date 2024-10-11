package com.ganesh.hospital.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.hospital.dto.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer>{
	
}