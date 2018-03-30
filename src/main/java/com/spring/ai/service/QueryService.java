package com.spring.ai.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.ai.entity.QueryEntity;
import com.spring.ai.repository.QueryRepository;
@Service
public class QueryService {
	
	private final QueryRepository queryRepository;
	public QueryService(QueryRepository queryRepository) {
		this.queryRepository = queryRepository;
	}
	
	public QueryEntity getById(Long id) {
		return queryRepository.findOne(id);
	}
	
	public List<QueryEntity> getByQuery(String query) {
		return queryRepository.findFirst10ByQueryContainingIgnoreCaseOrderByQueryidDesc(query);
	}	
	
	public void save(QueryEntity queryEntity) {
		queryRepository.save(queryEntity);
	}
	
	public void delete(Long id) {
		queryRepository.delete(id);
	}

	public List<QueryEntity> loadQuery(int limit) {
		return queryRepository.loadQuery(limit);
	}	
}
