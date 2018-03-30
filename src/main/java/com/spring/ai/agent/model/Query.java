package com.spring.ai.agent.model;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class Query {
		
	private String query;
	private String sentence[];
	private String intent[][];
	private String topic;
	
	public String[][] getIntent() {
		return intent;
	}
	public void setIntent(String[][] intent) {
		this.intent = intent;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.reset();
		this.query = query;
	}
	public String[] getSentence() {
		return sentence;
	}
	public void setSentence(String[] sentence) {
		this.sentence = sentence;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public void reset(){
		this.query =null;
		this.sentence = null;
		this.intent = null;
	}
	
	@Override
	public String toString() {
		return "Query [query=" + query + ", sentence=" + Arrays.toString(sentence) + ", intent="
				+ Arrays.toString(intent) + ", topic=" + topic + "]";
	}
}
