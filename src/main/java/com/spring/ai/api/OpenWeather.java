package com.spring.ai.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class OpenWeather
{
	public Map<String, String> currentStatus(String location) {
		String api = "http://api.openweathermap.org/data/2.5/weather?appid=5f51aa88bf6789afd1c6fba1d02ba77b&q="+location+",in";
		return parseJson(api);
	}
	
	private Map<String, String> parseJson(String api)
	{
		Map<String,String> data=new HashMap<String,String>();  
		
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(downloadJson(api)).getAsJsonObject();
		
		JsonObject jo = jsonObject.getAsJsonObject("main");
		Double temp = Double.parseDouble(jo.get("temp").getAsString())-273.15;
		int str  = temp.intValue();
		data.put("temp",""+str);
		
		String humidity = jo.get("humidity").getAsString();
		data.put("humidity",humidity);
		
		jo = (JsonObject) jsonObject.getAsJsonArray("weather").get(0);
		String description = jo.get("description").getAsString();
		data.put("description",description);
		
		return data;
		
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



