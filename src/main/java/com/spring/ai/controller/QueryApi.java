package com.spring.ai.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ai.entity.QueryEntity;
import com.spring.ai.service.QueryService;

@RestController
@RequestMapping("/api/query")
public class QueryApi {

	private final QueryService queryService;
	public QueryApi(QueryService queryService) {
		this.queryService = queryService;
	}

	
	@RequestMapping("/getById")
	public void getById() {
		
	}
	
	@RequestMapping("/getByQuery")
	public List<QueryEntity> getByQuery(@RequestParam("q") String q) {
		return queryService.getByQuery(q);
	}
	
	@RequestMapping("/loadQuery")
	public List<QueryEntity> loadQuery(@RequestParam("limit") int limit) {
		return queryService.loadQuery(limit);
	}
	
	@RequestMapping("/add")
	public void add(QueryEntity queryEntity) {
		System.out.println(queryEntity.toString());
		queryService.save(queryEntity);
	}
	
	@RequestMapping("/update")
	public void update(QueryEntity queryEntity) {
		queryService.save(queryEntity);
	}	
	
	@RequestMapping("/delete")
	public void delete(@RequestParam("id") Long id) {
		queryService.delete(id);
	}	
}
