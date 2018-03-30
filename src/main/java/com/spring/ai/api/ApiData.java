package com.spring.ai.api;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Component;

@Component
public class ApiData {
	
	private String query;
	private String wiki= null;
	private ArrayList<String> resultAns=new ArrayList<String>();
	private ArrayList<String> resultDef=new ArrayList<String>();
	private ArrayList<String> resultDes=new ArrayList<String>();

	public void setQuery(String query) {
		this.query = query;
	}
	public String getQuery() {
		return query;
	}	
	public String getWiki() {
		return wiki;
	}
	public void setWiki(String wiki) {
		this.wiki = wiki;
	}
	
	// set data
	public void addDataAns(String str) {
		this.resultAns.add(str);
	}
	public void addDataDescp(String str) {
		this.resultDes.add(str);
	}
	public void addDataDef(String str) {
		this.resultDef.add(str);
	}

	// get data
	public String getAns() {
		Collections.shuffle(resultAns);
		if(resultAns.isEmpty()) return null;
		else return resultAns.get(0);
	}
	public String getDescp() {
		Collections.shuffle(resultDes);
		if(resultDes.isEmpty()) return null;
		else return resultDes.get(0);		
	}
	public String getDef() {
		Collections.shuffle(resultDef);
		if(resultDef.isEmpty()) return null;
		else return resultDef.get(0);		
	}	
	
	
	public void reset() {
		this.query = null;
		this.resultAns.clear();
		this.resultDef.clear();
		this.resultDes.clear();
	}
	
	@Override
	public String toString() {
		return "Query:: "+query+" \n ANS :: "+resultAns.toString()+"\n DEF :: "+resultDef.toString()+"\n DEC :: "+resultDes.toString();
	}
}
