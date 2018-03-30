package com.spring.ai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ai.entity.ResponseEntity;

public interface ResponseRepository extends JpaRepository<ResponseEntity, Long>{
	List<ResponseEntity> findFirst10ByResponseContainingIgnoreCaseOrderByResponseidDesc(String query);
}
