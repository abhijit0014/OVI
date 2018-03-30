package com.spring.ai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="query_response_map")
public class QueryResponseMapEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long queryid;
	private Long responseid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQueryid() {
		return queryid;
	}
	public void setQueryid(Long queryid) {
		this.queryid = queryid;
	}
	public Long getResponseid() {
		return responseid;
	}
	public void setResponseid(Long responseid) {
		this.responseid = responseid;
	}	
}
