package com.ganesh.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.hospital.dto.Receptionist;
import com.ganesh.hospital.services.ReceptionistService;
import com.ganesh.hospital.util.ResponseStructure;

@RestController
public class ReceptionistController {

	@Autowired
	ReceptionistService receptionistService;

	@PostMapping("savereceptionist")
	public ResponseStructure<Receptionist> saveReceptionist(@RequestBody Receptionist receptionist) {
		return receptionistService.saveReceptionist(receptionist);
	}

	@GetMapping("getreceptionist")
	public ResponseStructure<Receptionist> getReceptionist(@RequestParam int id) {
		return receptionistService.getReceptionist(id);
	}

	@PutMapping("updatereceptionist")
	public ResponseStructure<Receptionist> updateReceptionist(@RequestBody Receptionist receptionist, @RequestParam int id) {
		return receptionistService.updateReceptionist(receptionist, id);
	}

	@DeleteMapping("deletereceptionist")
	public ResponseStructure<Receptionist> deleteReceptionist(@RequestParam int id) {
		return receptionistService.deleteReceptionist(id);
	}
}
