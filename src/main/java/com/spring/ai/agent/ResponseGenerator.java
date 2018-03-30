package com.spring.ai.agent;

import org.springframework.stereotype.Component;

import com.spring.ai.agent.model.Conversation;
import com.spring.ai.utility.NotFoundAns;
import com.spring.ai.utility.ReplaceWithValue;
import com.spring.ai.utility.UtilityService;

@Component
public class ResponseGenerator {
	
	private final Conversation conversation;
	private final NotFoundAns notFoundAns;
	private final CommandManager commandManager;
	private final DatabaseManager databaseManager;
	private final WebdataManager webdataManager;
	private final ReplaceWithValue replaceWithValue;
	private final UtilityService utilityService;

	public ResponseGenerator(Conversation conversation, NotFoundAns notFoundAns, CommandManager commandManager,
			DatabaseManager databaseManager, WebdataManager webdataManager, ReplaceWithValue replaceWithValue,
			UtilityService utilityService) {
		super();
		this.conversation = conversation;
		this.notFoundAns = notFoundAns;
		this.commandManager = commandManager;
		this.databaseManager = databaseManager;
		this.webdataManager = webdataManager;
		this.replaceWithValue = replaceWithValue;
		this.utilityService = utilityService;
	}


	public Conversation generate(String query)
	{
		String result = null;
		result = commandManager.response(query);
		if(result==null) result = databaseManager.directMatch(query);
		if(result==null) result = databaseManager.partialMatch(query);
		if(result==null) result = webdataManager.response(query);
		if(result==null) result = webdataManager.getDescription();
		if(result==null) result = webdataManager.getDefination();
		if(result==null) result = notFoundAns.generateMessage(query);
		
		result = replaceWithValue.replace(result);
		result = utilityService.format(result);
		conversation.setResponse(result);
		
		return conversation;
	}

}
