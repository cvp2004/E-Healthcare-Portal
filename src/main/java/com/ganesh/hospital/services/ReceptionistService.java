package com.ganesh.hospital.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ganesh.hospital.dao.DoctorDao;
import com.ganesh.hospital.dao.ReceptionistDao;
import com.ganesh.hospital.dto.Doctor;
import com.ganesh.hospital.dto.Receptionist;
import com.ganesh.hospital.util.ResponseStructure;

@Service
public class ReceptionistService {

	@Autowired
	ReceptionistDao receptionistDao;
	@Autowired
	DoctorDao doctorDao;
	ResponseStructure<Receptionist> responseStructure = new ResponseStructure<>();

	public ResponseStructure<Receptionist> saveReceptionist(Receptionist receptionist) {
		ArrayList<Doctor> doctors = (ArrayList<Doctor>) doctorDao.getAllDoctors();
		if (doctors.size() > 0)
			receptionist.setDoctors(doctors);
		else
			receptionist.setDoctors(null);
		Receptionist receptionist2 = receptionistDao.saveReceptionist(receptionist);
		responseStructure.setData(receptionist2);
		if (receptionist2 == null) {
			responseStructure.setMessage("Transaction Denied");
			responseStructure.setStatus(HttpStatus.NO_CONTENT.value());
		} else {
			responseStructure.setMessage("Saved Successfully ");
			responseStructure.setStatus(HttpStatus.CREATED.value());
		}
		return responseStructure;
	}

	public ResponseStructure<Receptionist> getReceptionist(int id) {
		Receptionist receptionist = receptionistDao.getReceptionist(id);
		responseStructure.setData(receptionist);
		if (receptionist == null) {
			responseStructure.setMessage("Id Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());

		} else {
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
		}
		return responseStructure;
	}

	public ResponseStructure<Receptionist> updateReceptionist(Receptionist receptionist, int id) {
		Receptionist receptionist2 = receptionistDao.getReceptionist(id);

		if (receptionist2 == null) {
			responseStructure.setMessage("Id Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(receptionist2);
		} else {
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			receptionist.setReceptId(id);
			responseStructure.setData(receptionistDao.updateReceptionist(receptionist));
		}
		return responseStructure;
	}

	public ResponseStructure<Receptionist> deleteReceptionist(int id) {
		Receptionist receptionist = receptionistDao.getReceptionist(id);
		responseStructure.setData(receptionist);
		if (receptionist == null) {
			responseStructure.setMessage("Id not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			receptionistDao.deleteReceptionist(receptionist);
			responseStructure.setMessage("Deleted Successfully !");
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
		}
		return responseStructure;
	}

}
