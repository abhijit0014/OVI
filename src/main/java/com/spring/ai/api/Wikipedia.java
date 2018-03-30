package com.spring.ai.api;

import java.io.IOException;

import org.jsoup.Jsoup;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class Wikipedia extends Thread
{
	private String wikiApi = "https://en.wikipedia.org/w/api.php?action=opensearch&limit=1&format=json&search=";
	private ApiData apiData;	
	
	public Wikipedia(ApiData apiData) {
		this.apiData = apiData;
	}
	
	public void run()
	{
		if (apiData.getQuery() != null) {
			this.parseJson(apiData.getQuery());
		}
	}
	
	private void parseJson(String query)
	{
		String str=null;
		JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(downloadJson(wikiApi+query)).getAsJsonArray();
        jsonArray = (JsonArray) jsonArray.get(2);
  
        if(jsonArray.size()!=0) {
        	str = jsonArray.get(0).getAsString();
        	apiData.addDataDescp(str);
        	apiData.setWiki(str);
        }
	}
	
	private String downloadJson(String muurl)
	{
        String doc = null;
		try {
			doc = Jsoup.connect(muurl).ignoreContentType(true).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}	
}



