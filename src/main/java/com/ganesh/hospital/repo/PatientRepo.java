package com.ganesh.hospital.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.hospital.dto.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
