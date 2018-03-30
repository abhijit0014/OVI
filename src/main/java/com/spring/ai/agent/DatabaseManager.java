package com.spring.ai.agent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.ai.entity.QueryResponseViewEntity;
import com.spring.ai.service.QueryResponseViewService;
import com.spring.ai.utility.UtilityService;

@Component
public class DatabaseManager {

	private final QueryResponseViewService queryResponseViewService;
	private final UtilityService utilityService;
	public DatabaseManager(QueryResponseViewService queryResponseViewService, UtilityService utilityService) {
		this.queryResponseViewService = queryResponseViewService;
		this.utilityService = utilityService;
	}


	// get direct match
	public String directMatch(String query) {
		List<QueryResponseViewEntity> response = null;
		response = queryResponseViewService.getByQueryDirectMatch(query);
		Collections.shuffle(response);
		if (!response.isEmpty()) {
			return response.get(0).getResponse();
		}
		else
			return null;		
	}
	
	
	// get partial match
	public String partialMatch(String query) {
		
		//if number of words in query is less then 2 then return null
		if(query.split("\\s+").length<2) return null;
		
		// fetch from database
		List<QueryResponseViewEntity> response = null;
		response = queryResponseViewService.getPartialResponseByQuery(query);
		Collections.shuffle(response);
		
		// select best query from database from by maximum word match
		if (response.size()>0) 
		{
			String result=null;
			int maxRatio=20;
			int counter = 0;
			String[] s1 = utilityService.removeCommonWords(query.split(" "));
			System.out.println(Arrays.toString(s1));
			
			for(QueryResponseViewEntity rViewEntity:response) 
			{
				String[] s2 = rViewEntity.getQuery().split(" ");
				counter = 0;
				for(String a : s1){
				    for(String b : s2)
				        if(b.equalsIgnoreCase(a)) 
				            counter++;
				            
				}
				int currentRatio = (counter*100)/s2.length;
				if(currentRatio>maxRatio && counter>1) {
					result = rViewEntity.getResponse();
					maxRatio = currentRatio;
				}
				System.out.println(counter+" = "+rViewEntity.getQuery()+" -"+currentRatio);
			}
			return result;
		}
		else
			return null;	
	}
}
