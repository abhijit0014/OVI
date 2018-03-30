package com.spring.ai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="query")
public class QueryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long queryid;
	private String query;
	
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
	
	@Override
	public String toString() {
		return "QueryEntity [queryid=" + queryid + ", query=" + query + "]";
	}
	
}
