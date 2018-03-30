package com.spring.ai.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ai.entity.QueryResponseMapEntity;
import com.spring.ai.entity.QueryResponseViewEntity;
import com.spring.ai.service.QueryResponseMapService;
import com.spring.ai.service.QueryResponseViewService;

@RestController
@RequestMapping("/api/QueryResponseMap")
public class QueryResponseMapApi{

	private final QueryResponseMapService queryResponseMapService;
	private final QueryResponseViewService queryResponseViewService;

	public QueryResponseMapApi(QueryResponseMapService queryResponseMapService,
			QueryResponseViewService queryResponseViewService) {
		this.queryResponseMapService = queryResponseMapService;
		this.queryResponseViewService = queryResponseViewService;
	}

	@RequestMapping("/getById")
	public void getById(@RequestParam("id") Long id) {

	}
	
	@RequestMapping("/getByQueryid")
	public List<QueryResponseViewEntity> getByQueryid(@RequestParam("id") Long id) {
		return queryResponseViewService.getByQueryid(id);
	}
	
	@RequestMapping("/add")
	public void add(QueryResponseMapEntity queryResponseMapEntity) {
		queryResponseMapService.save(queryResponseMapEntity);
	}
	
	@RequestMapping("/update")
	public void update(QueryResponseMapEntity queryResponseMapEntity) {
		queryResponseMapService.save(queryResponseMapEntity);
	}	

	@RequestMapping("/removeResponse")
	public void delete(@RequestParam("qid") Long qid, @RequestParam("rid") Long rid) {
		queryResponseMapService.removeResponse(qid,rid);
	}	
	
	@RequestMapping("/delete")
	public void delete(@RequestParam("id") Long id) {
		queryResponseMapService.delete(id);
	}
}
