package com.ganesh.hospital.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.hospital.dto.MedicalReport;

public interface MedicalReportRepo extends JpaRepository<MedicalReport, Integer>{

}
