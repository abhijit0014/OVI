package com.spring.ai.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ai.agent.Agent;
import com.spring.ai.agent.model.Conversation;
import com.spring.ai.api.BBCNews;
import com.spring.ai.api.Cricbuzz;
import com.spring.ai.api.OpenWeather;

@RestController
@RequestMapping("/botApi")
public class BotApi {
	private final Agent agent;
	public BotApi(Agent agent) {
		this.agent = agent;
	}

	@RequestMapping("/")
	public Conversation botResponse(@RequestParam("q") String query) {
		return agent.getRsponse(query);
	}
	
	@RequestMapping("/score")
	public String score() {
		Cricbuzz cricbuzz = new Cricbuzz();
		return cricbuzz.getLiveScore();
	}
	
	@RequestMapping("/news")
	public List<String> news() {
		BBCNews bbcNews = new BBCNews();
		return bbcNews.getHeadline();
	}
	
	@RequestMapping("/weather")
	public Map<String, String> weather(@RequestParam("q") String query) {
		OpenWeather openWeather = new OpenWeather();
		return openWeather.currentStatus(query);
	}	
	
}
