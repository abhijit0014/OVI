package com.spring.ai.agent;

import org.springframework.stereotype.Component;

import com.spring.ai.api.ApiData;
import com.spring.ai.api.Bing;
import com.spring.ai.api.Google;
import com.spring.ai.api.Wikipedia;
import com.spring.ai.utility.UtilityService;

@Component
public class WebdataManager {
	
	private String query;
	private ApiData result;
	private final UtilityService utilityService;
	
	public WebdataManager(UtilityService utilityService) {
		this.utilityService = utilityService;
	}
	
	// get response
	public String response(String query) {
		
		if (this.query!=query || result==null) 
			result = collectWebData(query);
		
		String type = utilityService.getAnsType(query);
		if (type=="ANS")
			return result.getAns();
		if (type=="DEFINITION")
			return result.getDef();
		if (type=="DESCRIPTION")
			return result.getDescp();
		
		return null;
	}
	
	public String getDescription() {
		return result.getDescp();
	}
	
	public String getDefination() {
		return result.getDef();
	}
	
	private ApiData collectWebData(String query)
	{
		ApiData apiData = new ApiData();
		apiData.setQuery(query);
		//create thread
		Google google = new Google(apiData);
		Bing bing = new Bing(apiData);
		Wikipedia wikipedia = new Wikipedia(apiData);
		// start thread
		bing.start();
		google.start();
		wikipedia.start();
    	// join threads
    	try {
			bing.join();
			google.join();
			wikipedia.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	// save data
    	System.out.println(apiData.toString());
    	return apiData;
    	
	}
}
