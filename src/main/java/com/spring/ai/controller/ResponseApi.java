package com.spring.ai.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ai.entity.ResponseEntity;
import com.spring.ai.service.ResponseService;

@RestController
@RequestMapping("/api/response")
public class ResponseApi {

	private final ResponseService responseService;
	public ResponseApi(ResponseService responseService) {
		this.responseService = responseService;
	}

	@RequestMapping("/getById")
	public void getById() {
		
	}
	
	@RequestMapping("/getByResponse")
	public List<ResponseEntity> getByResponse(@RequestParam("q") String q) {
		return responseService.getByResponse(q);
	}
	
	@RequestMapping("/add")
	public void add(ResponseEntity responseEntity) {
		responseService.save(responseEntity);
	}
	
	@RequestMapping("/update")
	public void update(ResponseEntity responseEntity) {
		responseService.save(responseEntity);
	}	
	
	@RequestMapping("/delete")
	public void delete(@RequestParam("id") Long id) {
		responseService.delete(id);
	}
}
