package com.spring.ai.api;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Google extends Thread
{
	private String googleApi = "https://www.google.com/search?q=";
	private ApiData apiData;	
	
	public Google(ApiData apiData) {
		this.apiData = apiData;
	}
	
	public void run()
	{
		if (apiData.getQuery() != null) {
			this.parseHtml(apiData.getQuery());
		}
	}
	
	private void parseHtml(String query)
	{
		String str = null;
		Document doc = downloadHtml(googleApi+query);	
		
		str = doc.getElementsByClass("_XWk").text();
		if (!str.isEmpty()) {
			apiData.addDataAns(str);
			str=null;
		}
		str = doc.getElementsByClass("kno-rdesc").text();
		if (!str.isEmpty()) {
			apiData.addDataDescp(str);
			str=null;
		}		
		str = doc.getElementsByClass("_Tgc").text();
		if (!str.isEmpty()) {
			apiData.addDataDef(str);
			str=null;
		}		
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


