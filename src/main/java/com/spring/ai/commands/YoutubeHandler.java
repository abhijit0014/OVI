package com.spring.ai.commands;

import org.springframework.stereotype.Component;

import com.spring.ai.api.Youtube;

@Component
public class YoutubeHandler {

	private final Youtube youtube;
	
	public YoutubeHandler(Youtube youtube) {
		this.youtube = youtube;
	}
	
	public String response(String query) 
	{
		if(query.split(" ")[0].equalsIgnoreCase("play"))
			return youtube.getVideoId(query);
		
		if (query.contains("video")||query.contains("tutorial")||query.contains("trailer"))
			return youtube.getVideoId(query);
		
		if (query.equalsIgnoreCase("next"))
			return youtube.next();
		
		if (query.equalsIgnoreCase("previous"))
			return youtube.next();	
		
		return null;
	}
	
}
