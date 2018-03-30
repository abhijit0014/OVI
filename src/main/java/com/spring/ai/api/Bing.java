package com.spring.ai.api;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Bing extends Thread
{
	private String bingApi = "https://www.bing.com/search?q=";
	private ApiData apiData;	
	
	public Bing(ApiData apiData) {
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
		Document doc = downloadHtml(bingApi+query);	
		
		str = doc.getElementsByClass("b_focusTextMedium").text();
		if (!str.isEmpty()) {
			apiData.addDataAns(str);
			str=null;
		}

		str = doc.getElementsByClass("b_entityTitle").text();
		if (!str.isEmpty()) {
			apiData.addDataAns(str);
			str=null;
		}
		
		/*str = doc.getElementsByClass("b_lBottom b_snippet").text();
		if (!str.isEmpty()) {
			apiData.addDataDescp(str);
			str=null;
		}*/
		
		str = doc.getElementsByClass("rwrl_padref").text();
		if (!str.isEmpty()) {
			apiData.addDataDef(str);
			str=null;
		}
		
		str = doc.getElementsByClass("ipText").text();
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

