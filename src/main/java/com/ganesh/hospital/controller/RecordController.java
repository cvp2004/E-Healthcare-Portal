package com.ganesh.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.hospital.dto.Record;

import com.ganesh.hospital.services.RecordService;
import com.ganesh.hospital.util.ResponseStructure;

@RestController
public class RecordController {

	@Autowired
	RecordService recordService;

	@PostMapping("saverecord")
	public ResponseStructure<Record> saveRecord(@RequestBody Record record,@RequestParam int patientId,@RequestParam int doctorId) {
		return recordService.saveRecord(record,patientId,doctorId);
	}

	@GetMapping("getrecord")
	public ResponseStructure<Record> getRecord(@RequestParam int id) {
		return recordService.getRecord(id);
	}

	@PutMapping("updaterecord")
	public ResponseStructure<Record> updateRecord(@RequestBody Record record, @RequestParam int id) {
		return recordService.updateRecord(record, id);
	}

	@DeleteMapping("deleterecord")
	public ResponseStructure<Record> deleteRecord(@RequestParam int id) {
		return recordService.deleteRecord(id);
	}

}
