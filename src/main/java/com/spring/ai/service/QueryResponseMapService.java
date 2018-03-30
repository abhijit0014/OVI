package com.spring.ai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.ai.entity.QueryResponseMapEntity;
import com.spring.ai.repository.QueryResponseMapRepository;
@Service
public class QueryResponseMapService {

	private final QueryResponseMapRepository queryResponseMapRepository;
	public QueryResponseMapService(QueryResponseMapRepository queryResponseMapRepository) {
		this.queryResponseMapRepository = queryResponseMapRepository;
	}

	public List<QueryResponseMapEntity> getByQueryid(Long id) {
		return queryResponseMapRepository.findByQueryid(id);
	}
	public void getById() {
		
	}
	
	public void save(QueryResponseMapEntity queryResponseMapEntity) {
		queryResponseMapRepository.save(queryResponseMapEntity);
	}
	
	public void delete(Long id) {
		queryResponseMapRepository.delete(id);
	}

	public void removeResponse(Long qid, Long rid) {
		queryResponseMapRepository.removeResponse( qid,  rid);
	}
}
