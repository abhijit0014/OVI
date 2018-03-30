package com.spring.ai.utility;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import org.springframework.stereotype.Component;

import com.spring.ai.api.OpenWeather;

@Component
public class ReplaceWithValue {

	public String replace(String str) 
	{
		System.out.println("Replace word :: Class------------------------------");
		if(str!=null && str.indexOf("<")>=0 && str.indexOf(">")>=1) 
		{
			String replaceWord = str.substring(str.indexOf("<")+1, str.indexOf(">"));
			System.out.println("Replace word :: "+replaceWord);
			switch (replaceWord) {
				case "currentdate": str = replace(str, currentDate());break;
				case "currenttime": str = replace(str, currentTime());break;
				case "currentTemperature": str = replace(str, currentTemperature());break;
				case "currentWeather": str = replace(str, currentWeather());break;
				default: break;
			}
		}
		return str;
	}
	
	private String replace(String str, String replaceStr) {
		return str.substring(0, str.indexOf("<"))
				+ replaceStr + 
			   str.substring(str.indexOf(">")+1, str.length());			
	}
	
	// current date
	private String currentDate() {
		LocalDate date = LocalDate.now(); 
		return date.getDayOfWeek()+", "+date.getDayOfMonth()+" "+date.getMonth()+" "+date.getYear();
	}
	// current time
	private String currentTime() {
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		return localTime.format(dateTimeFormatter);
	}
	// current temperature
	private String currentTemperature() {
		OpenWeather openWeather = new OpenWeather();
		return openWeather.currentStatus("kolkata").get("temp");
	}
	
	// current weather status
	private String currentWeather() {
		OpenWeather openWeather = new OpenWeather();
		Map<String, String> data=openWeather.currentStatus("kolkata");
		return data.get("temp")+"°c with "+data.get("description")+" and "+data.get("humidity")+"% humidity";
	}
}
