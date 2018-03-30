package com.spring.ai.api;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class Cricbuzz 
{
	private String url = "https://m.cricbuzz.com/";
	
	public String getLiveScore()
	{
		return parseHtml();
	}
		
	private String parseHtml()
	{
		String result;
		int counter = 0;
		Document doc = downloadHtml(url);	
		//return doc.getElementsByClass("buzzard-item title-link__title-text").text();	
		Elements elements = doc.getElementsByClass("list-content");
		for (Element element : elements) {
			counter++;
			result = element.html();
			if(result.contains("India")) {
				return result;
			}
			if(counter==4) break;
		}
		for (Element element : elements) {
				return element.html();
		}		
		return null;
	}
	
	private Document downloadHtml(String muurl)
	{
        Document doc = null;
		try {
			doc = Jsoup.connect(muurl).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
}



