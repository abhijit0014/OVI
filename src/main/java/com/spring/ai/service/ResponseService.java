package com.spring.ai.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.ai.entity.ResponseEntity;
import com.spring.ai.repository.ResponseRepository;
@Service
public class ResponseService {
	
	private final ResponseRepository responseRepository;
	public ResponseService(ResponseRepository responseRepository) {
		this.responseRepository = responseRepository;
	}

	public void getById(Long id) {
		responseRepository.findOne(id);
	}
	
	public List<ResponseEntity> getByResponse(String str) {
		return responseRepository.findFirst10ByResponseContainingIgnoreCaseOrderByResponseidDesc(str);
	}	
	
	public void save(ResponseEntity responseEntity) {
		responseRepository.save(responseEntity);
	}
	
	public void delete(Long id) {
		responseRepository.delete(id);
	}
}
