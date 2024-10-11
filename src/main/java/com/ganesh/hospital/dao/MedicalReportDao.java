package com.ganesh.hospital.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ganesh.hospital.dto.MedicalReport;
import com.ganesh.hospital.repo.MedicalReportRepo;
@Repository
public class MedicalReportDao {

	@Autowired
	MedicalReportRepo medicalReportRepo;
	
	public MedicalReport saveMedicalReport(MedicalReport medicalReport) {
		return medicalReportRepo.save(medicalReport);

	}

	public MedicalReport getMedicalReport(int id) {
		Optional<MedicalReport> optional=medicalReportRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else
			return null;
	}

	public MedicalReport updateMedicalReport(MedicalReport medicalReport) {
		return medicalReportRepo.save(medicalReport);
	}

	public MedicalReport deleteMedicalReport(MedicalReport medicalReport) {
		medicalReportRepo.delete(medicalReport);
		return medicalReport;
		
	}

}
