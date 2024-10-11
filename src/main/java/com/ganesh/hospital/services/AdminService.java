package com.ganesh.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ganesh.hospital.dao.AdminDao;
import com.ganesh.hospital.dto.Admin;
import com.ganesh.hospital.util.ResponseStructure;

@Service
public class AdminService {
	@Autowired
	AdminDao adminDao;
	ResponseStructure<Admin> responseStructure = new ResponseStructure<>();

	public ResponseStructure<Admin> saveAdmin(Admin admin) {

		Admin admin2 = adminDao.saveAdmin(admin);

		responseStructure.setData(admin2);
		if (admin2 == null) {
			responseStructure.setMessage("Transaction Denied ?");
			responseStructure.setStatus(HttpStatus.NOT_IMPLEMENTED.value());
		} else {
			responseStructure.setMessage("Saved Succesddfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
		}
		return responseStructure;
	}

	public ResponseStructure<Admin> getAdmin(int id) {
		Admin admin = adminDao.getAdmin(id);
		responseStructure.setData(admin);
		if (admin == null) {
			responseStructure.setMessage("Id Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());

		} else {
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
		}
		return responseStructure;
	}

	public ResponseStructure<Admin> updateAdmin(Admin admin, int id) {
		Admin admin2 = adminDao.getAdmin(id);
		
		if(admin2 == null) {
			responseStructure.setMessage("Id Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(admin2);
		}
		else {
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			admin.setId(admin2.getId());
			responseStructure.setData(adminDao.updateAdmin(admin));
		}
		return responseStructure;
	}

	public ResponseStructure<Admin> deleteAdmin(int id) {
		Admin admin=adminDao.getAdmin(id);
		responseStructure.setData(admin);
		if(admin==null) {
			responseStructure.setMessage("Id not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		else {
			adminDao.deleteAdmin(admin);
			responseStructure.setMessage("Deleted Successfully !");
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
		}
		return responseStructure;
	}

}
