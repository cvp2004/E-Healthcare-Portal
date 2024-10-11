package com.ganesh.hospital.dao;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ganesh.hospital.dto.Receptionist;
import com.ganesh.hospital.repo.ReceptionistRepo;

@Repository
public class ReceptionistDao {
	@Autowired
	ReceptionistRepo receptionistRepo;

	public Receptionist saveReceptionist(Receptionist receptionist) {
		return receptionistRepo.save(receptionist);
		
	}

	public Receptionist getReceptionist(int id) {
		Optional<Receptionist> optional=receptionistRepo.findById(id);
		if(optional.isEmpty())
			return null;
		else
			return optional.get();
	}

	public Receptionist updateReceptionist(Receptionist receptionist) {
		return receptionistRepo.save(receptionist);
	}

	public Receptionist deleteReceptionist(Receptionist receptionist) {
		receptionistRepo.delete(receptionist);
		return receptionist;
		
	}
	

}
