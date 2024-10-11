package com.ganesh.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ganesh.hospital.dao.DoctorDao;
import com.ganesh.hospital.dao.PatientDao;
import com.ganesh.hospital.dao.RecordDao;
import com.ganesh.hospital.dto.Doctor;
import com.ganesh.hospital.dto.Patient;
import com.ganesh.hospital.dto.Record;
import com.ganesh.hospital.util.ResponseStructure;

@Service
public class RecordService {
	@Autowired
	RecordDao recordDao;
	@Autowired
	PatientDao patientDao;
	@Autowired
	DoctorDao doctorDao;
	ResponseStructure<Record> responseStructure = new ResponseStructure<>();

	public ResponseStructure<Record> saveRecord(Record record,int patientId,int doctorId) {
		Doctor doctor=doctorDao.getDoctor(doctorId);
		Patient patient=patientDao.getPatient(patientId);
		
		if(doctor==null) {
			responseStructure.setData(null);
			responseStructure.setMessage("Doctor_Id not found");
			responseStructure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			return responseStructure;
		}
		if(patient==null) {
			responseStructure.setData(null);
			responseStructure.setMessage("Patient_Id not found");
			responseStructure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			return responseStructure;
		}
		
		record.setDoctor(doctor);
		record.setPatient(patient);
		
		Record record2 = recordDao.saveRecord(record);
		responseStructure.setData(record2);
	
		if (record2 != null) {
			responseStructure.setMessage("Successfully added the record ");
			responseStructure.setStatus(HttpStatus.CREATED.value());
		} else {
			responseStructure.setMessage("Transaction denied");
			responseStructure.setStatus(HttpStatus.NOT_IMPLEMENTED.value());

		}
		return responseStructure;
	}

	public ResponseStructure<Record> getRecord(int id) {
		Record record = recordDao.getRecord(id);
		responseStructure.setData(record);
		if (record == null) {
			responseStructure.setMessage("Id Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());

		} else {
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
		}
		return responseStructure;

	}

	public ResponseStructure<Record> updateRecord(Record record, int id) {
		Record record2 = recordDao.getRecord(id);

		if (record2 == null) {
			responseStructure.setMessage("Id Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(record2);
		} else {
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			record.setRecordId(record2.getRecordId());
			record.setDoctor(record2.getDoctor());
			record.setPatient(record2.getPatient());
			responseStructure.setData(recordDao.updateRecord(record));
		}
		return responseStructure;
	}

	public ResponseStructure<Record> deleteRecord(int id) {
		Record record = recordDao.getRecord(id);
		responseStructure.setData(record);
		if (record == null) {
			responseStructure.setMessage("Id not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			recordDao.deleteRecord(record);
			responseStructure.setMessage("Deleted Successfully !");
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
		}
		return responseStructure;
	}

}
