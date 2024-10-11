package com.ganesh.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ganesh.hospital.dao.DoctorDao;
import com.ganesh.hospital.dao.MedicalReportDao;
import com.ganesh.hospital.dao.PatientDao;
import com.ganesh.hospital.dto.Doctor;
import com.ganesh.hospital.dto.MedicalReport;
import com.ganesh.hospital.dto.Patient;
import com.ganesh.hospital.util.ResponseStructure;

@Service
public class MedicalReportService {

	@Autowired
	MedicalReportDao medicalReportDao;
	@Autowired
	PatientDao patientDao;
	@Autowired
	DoctorDao doctorDao;
	ResponseStructure<MedicalReport> responseStructure = new ResponseStructure<>();

	public ResponseStructure<MedicalReport> saveMedicalReport(MedicalReport medicalReport, int patientId, int doctorId) {
		Patient patient=patientDao.getPatient(patientId);
		Doctor doctor=doctorDao.getDoctor(doctorId);
		if(patient==null) {
			responseStructure.setData(null);
			responseStructure.setMessage("Patient Id not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return responseStructure;
		}
		if(doctor==null) {
			responseStructure.setData(null);
			responseStructure.setMessage("Doctor Id not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return responseStructure;
		}
		medicalReport.setPatient(patient);
		medicalReport.setDoctor(doctor);
		MedicalReport medicalReport2 = medicalReportDao.saveMedicalReport(medicalReport);

		responseStructure.setData(medicalReport2);
		if (medicalReport2 == null) {
			responseStructure.setMessage("Transaction Denied ?");
			responseStructure.setStatus(HttpStatus.NOT_IMPLEMENTED.value());
		} else {
			responseStructure.setMessage("Saved Succesddfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
		}
		return responseStructure;
	}

	public ResponseStructure<MedicalReport> getMedicalReport(int id) {
		MedicalReport medicalReport = medicalReportDao.getMedicalReport(id);
		responseStructure.setData(medicalReport);
		if (medicalReport == null) {
			responseStructure.setMessage("Id Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());

		} else {
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
		}
		return responseStructure;
	}

	public ResponseStructure<MedicalReport> updateMedicalReport(MedicalReport medicalReport, int id) {
		MedicalReport medicalReport2 = medicalReportDao.getMedicalReport(id);

		if (medicalReport2 == null) {
			responseStructure.setMessage("Id Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(medicalReport2);
		} else {
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			medicalReport.setReportId(id);
			responseStructure.setData(medicalReportDao.updateMedicalReport(medicalReport));
		}
		return responseStructure;
	}

	public ResponseStructure<MedicalReport> deleteMedicalReport(int id) {
		MedicalReport medicalReport = medicalReportDao.getMedicalReport(id);
		responseStructure.setData(medicalReport);
		if (medicalReport == null) {
			responseStructure.setMessage("Id not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			medicalReportDao.deleteMedicalReport(medicalReport);
			responseStructure.setMessage("Deleted Successfully !");
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
		}
		return responseStructure;
	}

}
