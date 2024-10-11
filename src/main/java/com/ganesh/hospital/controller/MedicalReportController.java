package com.ganesh.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.hospital.dto.MedicalReport;
import com.ganesh.hospital.services.MedicalReportService;
import com.ganesh.hospital.util.ResponseStructure;

@RestController
public class MedicalReportController {

	@Autowired
	MedicalReportService medicalReportService;

	@PostMapping("savemedicalreport")
	public ResponseStructure<MedicalReport> saveMedicalReport(@RequestBody MedicalReport medicalReport,@RequestParam int patientId,@RequestParam int doctorId) {
		return medicalReportService.saveMedicalReport(medicalReport,patientId,doctorId);
	}

	@GetMapping("getmedicalreport")
	public ResponseStructure<MedicalReport> getMedicalReport(@RequestParam int id) {
		return medicalReportService.getMedicalReport(id);
	}

	@PutMapping("updatemedicalreport")
	public ResponseStructure<MedicalReport> updateMedicalReport(@RequestBody MedicalReport medicalReport, @RequestParam int id) {
		return medicalReportService.updateMedicalReport(medicalReport, id);
	}

	@DeleteMapping("deletemedicalreport")
	public ResponseStructure<MedicalReport> deleteMedicalReport(@RequestParam int id) {
		return medicalReportService.deleteMedicalReport(id);
	}
}
