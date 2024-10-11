package com.ganesh.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ganesh.hospital.dao.PatientDao;

import com.ganesh.hospital.dto.Patient;
import com.ganesh.hospital.util.ResponseStructure;

@Service
public class PatientService {
	@Autowired
	private PatientDao patientDao;
	private ResponseStructure<Patient> responseStructure = new ResponseStructure<>();

	public ResponseStructure<Patient> savePatient(Patient patient) {
		Patient patient2 = patientDao.savePatient(patient);

		responseStructure.setData(patient2);
		if (patient2 == null) {
			responseStructure.setMessage("Transaction Denied ?");
			responseStructure.setStatus(HttpStatus.NOT_IMPLEMENTED.value());
		} else {
			responseStructure.setMessage("Saved Succesddfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
		}
		return responseStructure;
	}

	public ResponseStructure<Patient> getPatient(int id) {
		Patient patient = patientDao.getPatient(id);
		responseStructure.setData(patient);
		if (patient == null) {
			responseStructure.setMessage("Id Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());

		} else {
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
		}
		return responseStructure;
	}

	public ResponseStructure<Patient> updatePatient(Patient patient, int id) {
		Patient patient2 = patientDao.getPatient(id);

		if (patient2 == null) {
			responseStructure.setMessage("Id Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(patient2);
		} else {
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			patient.setPatientId(patient2.getPatientId());
			responseStructure.setData(patientDao.updatePatient(patient));
		}
		return responseStructure;
	}

	public ResponseStructure<Patient> deletePatient(int id) {
		Patient patient = patientDao.getPatient(id);
		responseStructure.setData(patient);
		if (patient == null) {
			responseStructure.setMessage("Id not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			patientDao.deletePatient(patient);
			responseStructure.setMessage("Deleted Successfully !");
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
		}
		return responseStructure;
	}

}
