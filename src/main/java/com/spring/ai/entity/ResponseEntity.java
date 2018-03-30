package com.spring.ai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="response")
public class ResponseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long responseid;
	private String response;
	
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
