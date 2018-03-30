package com.spring.ai.commands;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.ai.entity.RememberEntity;
import com.spring.ai.service.RememberService;
import com.spring.ai.utility.UtilityService;

@Component
public class RememberHandler {
	private final RememberService rememberService;
	private final UtilityService utilityService;
	private Long current_remember_id;
	public RememberHandler(RememberService rememberService, UtilityService utilityService) {
		this.rememberService = rememberService;
		this.utilityService = utilityService;
	}
	
	public String response(String query) 
	{
		String words[] = query.split(" ");
		
		if(words[0].equalsIgnoreCase("remember")) 
			return remember(query);
		
		if(utilityService.isWHWord(words[0])&&(query.equalsIgnoreCase("am")||query.equalsIgnoreCase("i")))
			return getRememberData(query);
		
		if(query.equalsIgnoreCase("forgot all") || query.equalsIgnoreCase("forgot all of that")) 
			return deleteAllRememberData();	
		
		if(query.equalsIgnoreCase("forgot this")) {
			if(current_remember_id!=null) 
				return deleteById(current_remember_id);
		}
		
		return null;
	}
	
	// remember data
	private String remember(String query) {
		RememberEntity rememberEntity = new RememberEntity();
		rememberEntity.setData(query);
		rememberEntity.setDate(new Date());
		rememberService.save(rememberEntity);
		return "Ok I'll remember that";		
	}
	
	// get remember data
	private String getRememberData(String query) {
		List<RememberEntity> result = rememberService.findByData(query);
		if (!result.isEmpty()) {
			current_remember_id = result.get(0).getId();
			return "Here's what you have told me#"+result.get(0).getData();
		}
		else
			return null;
	}

	// delete all data
	private String deleteAllRememberData() {
		rememberService.deleteAll();
		return "Ok I wont mention again if you don't";
	}
	
	// delete by id
	private String deleteById(Long id) {
		rememberService.deleteById(id);
		return "Ok I wont mention again if you don't";
	}	
}
