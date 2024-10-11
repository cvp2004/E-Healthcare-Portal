package com.ganesh.hospital.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.hospital.dto.Record;

public interface RecordRepo extends JpaRepository<Record, Integer>{

}
