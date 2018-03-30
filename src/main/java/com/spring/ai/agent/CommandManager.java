package com.spring.ai.agent;
import org.springframework.stereotype.Component;
import com.spring.ai.commands.RememberHandler;
import com.spring.ai.commands.YoutubeHandler;


@Component
public class CommandManager {

	private final RememberHandler rememberHandler;
	private final YoutubeHandler youtubeHandler;
	
	public CommandManager(RememberHandler rememberHandler, YoutubeHandler youtubeHandler) {
		this.rememberHandler = rememberHandler;
		this.youtubeHandler = youtubeHandler;
	}

	public String response(String query) 
	{	
		if(query.equalsIgnoreCase("stop")) 
			return " ";
		
		String result = null;
		result  = rememberHandler.response(query);
		if(result==null) result = youtubeHandler.response(query);
		
		return result;
	}
}
