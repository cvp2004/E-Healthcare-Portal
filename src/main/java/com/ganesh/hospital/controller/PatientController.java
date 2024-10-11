package com.ganesh.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.hospital.dto.Patient;

import com.ganesh.hospital.services.PatientService;
import com.ganesh.hospital.util.ResponseStructure;

@RestController
public class PatientController {

	@Autowired
	PatientService patientService;

	@PostMapping("savepatient")
	public ResponseStructure<Patient> savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}

	@GetMapping("getpatient")
	public ResponseStructure<Patient> getPatient(@RequestParam int id) {
		return patientService.getPatient(id);
	}

	@PutMapping("updatepatient")
	public ResponseStructure<Patient> updatePatient(@RequestBody Patient patient, @RequestParam int id) {
		return patientService.updatePatient(patient, id);
	}

	@DeleteMapping("deletepatient")
	public ResponseStructure<Patient> deletePatient(@RequestParam int id) {
		return patientService.deletePatient(id);
	}
}
