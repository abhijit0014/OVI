package com.spring.ai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.ai.entity.RememberEntity;
import com.spring.ai.repository.RememberRepository;
@Service
public class RememberService {

	private final RememberRepository rememberRepository;
	public RememberService(RememberRepository rememberRepository) {
		this.rememberRepository = rememberRepository;
	}
	
	public void save(RememberEntity rememberEntity) {
		rememberRepository.save(rememberEntity);
	}
	
	public List<RememberEntity> findByData(String str) {
		return rememberRepository.findByData(str);
	}
	
	public void deleteAll() {
		rememberRepository.deleteAll();
	}
	
	public void deleteById(Long id) {
		rememberRepository.delete(id);
	}	
}
