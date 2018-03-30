package com.spring.ai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/admin/query")
	public String query() {
		return "query";
	}

	@RequestMapping("/admin/response")
	public String response() {
		return "index";
	}
	
	@RequestMapping("/admin/topic")
	public String topic() {
		return "topic";
	}
	
	@RequestMapping("/admin/template")
	public String template() {
		return "template";
	}
	
	@RequestMapping("/admin/action")
	public String action() {
		return "action";
	}
	
	@RequestMapping("/admin/queryResponseMap")
	public String queryResponseMap() {
		return "queryResponseMap";
	}
	
	@RequestMapping("/admin/topicQueryResponseMap")
	public String topicQueryResponseMap() {
		return "topicQueryResponseMap";
	}	
}
