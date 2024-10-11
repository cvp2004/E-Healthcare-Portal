package com.ganesh.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ganesh.hospital.dao.DoctorDao;

import com.ganesh.hospital.dto.Doctor;
import com.ganesh.hospital.util.ResponseStructure;

@Service
public class DoctorService {

	@Autowired
	DoctorDao doctorDao;
	ResponseStructure<Doctor> responseStructure = new ResponseStructure<>();

	public ResponseStructure<Doctor> saveDoctor(Doctor doctor) {
		Doctor doctor2 = doctorDao.saveDoctor(doctor);
		responseStructure.setData(doctor2);
		if (doctor2 == null) {
			responseStructure.setMessage("Transaction Denied");
			responseStructure.setStatus(HttpStatus.NO_CONTENT.value());
		} else {
			responseStructure.setMessage("Saved Successfully ");
			responseStructure.setStatus(HttpStatus.CREATED.value());
		}
		return responseStructure;

	}

	public ResponseStructure<Doctor> getDoctor(int id) {
		Doctor doctor = doctorDao.getDoctor(id);
		responseStructure.setData(doctor);
		if (doctor == null) {
			responseStructure.setMessage("Id Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());

		} else {
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
		}
		return responseStructure;
	}

	public ResponseStructure<Doctor> updateDoctor(Doctor doctor, int id) {
		Doctor doctor2 = doctorDao.getDoctor(id);

		if (doctor2 == null) {
			responseStructure.setMessage("Id Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(doctor2);
		} else {
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			doctor.setDoctorId(doctor2.getDoctorId());
			responseStructure.setData(doctorDao.updateDoctor(doctor));
		}
		return responseStructure;
	}

	public ResponseStructure<Doctor> deleteDoctor(int id) {
		Doctor doctor = doctorDao.getDoctor(id);
		responseStructure.setData(doctor);
		if (doctor == null) {
			responseStructure.setMessage("Id not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			doctorDao.deleteDoctor(doctor);
			responseStructure.setMessage("Deleted Successfully !");
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
		}
		return responseStructure;
	}
}
