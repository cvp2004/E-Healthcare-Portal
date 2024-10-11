package com.ganesh.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.hospital.dto.Doctor;
import com.ganesh.hospital.services.DoctorService;
import com.ganesh.hospital.util.ResponseStructure;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping("savedoctor")
	public ResponseStructure<Doctor> saveDoctor(@RequestBody Doctor doctor) {
		return doctorService.saveDoctor(doctor);
	}

	@GetMapping("getdoctor")
	public ResponseStructure<Doctor> getAdmin(@RequestParam int id) {
		return doctorService.getDoctor(id);
	}

	@PutMapping("updatedoctor")
	public ResponseStructure<Doctor> updateAdmin(@RequestBody Doctor doctor, @RequestParam int id) {
		return doctorService.updateDoctor(doctor, id);
	}

	@DeleteMapping("deletedoctor")
	public ResponseStructure<Doctor> deleteAdmin(@RequestParam int id) {
		return doctorService.deleteDoctor(id);
	}

}
