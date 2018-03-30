package com.spring.ai.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class BBCNews 
{
	private String url = "http://www.bbc.com/news/world/asia/india";
	
	public List<String> getHeadline()
	{
		return parseHtml();
	}
		
	private List<String> parseHtml()
	{
		List<String> newsList = new ArrayList<>();
		Document doc = downloadHtml(url);		
		Elements links = doc.getElementsByClass("title-link__title-text");
		int counter = 0;
		for (Element element : links) {
			counter++;
			newsList.add(element.ownText());
			if (counter==5) break;
		}
		return newsList;
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



