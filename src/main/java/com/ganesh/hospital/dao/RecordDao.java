package com.ganesh.hospital.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ganesh.hospital.dto.Record;
import com.ganesh.hospital.repo.RecordRepo;

@Repository
public class RecordDao {
	@Autowired
	RecordRepo recordRepo;

	public Record saveRecord(Record record) {

		return recordRepo.save(record);
	}

	public Record getRecord(int id) {
		Optional<Record> optional = recordRepo.findById(id);
		if (optional.isPresent())
			return optional.get();

		else
			return null;
	}

	public Record updateRecord(Record record) {
		return recordRepo.save(record);
	}

	public Record deleteRecord(Record record) {
		recordRepo.delete(record);
		return record;
	}

}
