package com.spring.ai.agent;

import org.springframework.stereotype.Component;

import com.spring.ai.agent.model.Conversation;
import com.spring.ai.agent.model.Query;

@Component
public class Agent {
	// http://localhost:9191/trace
	private ResponseGenerator responseGenerator;
	
	public Agent(Query query, ResponseGenerator responseGenerator) {
		this.responseGenerator = responseGenerator;
	}

	public Conversation getRsponse(String str) {
		return responseGenerator.generate(str);
	}
}
