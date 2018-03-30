package com.spring.ai.agent.model;

import org.springframework.stereotype.Component;

@Component
public class Conversation {
	public String topic;
	public String query;
	public String response;
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "Conversation [topic=" + topic + ", query=" + query + ", response=" + response + "]";
	}
}
