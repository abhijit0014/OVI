package com.spring.ai.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name="query_response_view")
@Immutable
public class QueryResponseViewEntity {
	@Id
	private Long id;	
	private Long queryid;
	private String query;
	private Long responseid;
	private String response;
	
	public Long getQueryid() {
		return queryid;
	}
	public void setQueryid(Long queryid) {
		this.queryid = queryid;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Long getResponseid() {
		return responseid;
	}
	public void setResponseid(Long responseid) {
		this.responseid = responseid;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}	
}
