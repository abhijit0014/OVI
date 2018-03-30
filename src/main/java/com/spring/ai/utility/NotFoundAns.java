package com.spring.ai.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class NotFoundAns {

	public String generateMessage(String str) {
		String[] words=str.split("\\s");
		

		// what about
		if(words[0].equals("what") && words[1].equals("about")) {
		      String pattern = "what about (.*)";
		      Pattern r = Pattern.compile(pattern);
		      Matcher m = r.matcher(str);
		      if (m.find( )) {
		    	  return m.group(1)+"? I haven't heard enough about it to have an opinion.";
		      }			
		}	
		
		//what 
		if (words[0].equals("what"))
			return "I'll ask around and get back to you. ";	
		
		//would you like to 
		if (str.contains("would you like to"))
			return "No thanks, I don't think I'd like to do that";			
		
		//who will
		if (words[0].equals("who")&&words[1].equals("will"))
			return "How would I know "+str+"?";		
		
		//can
		if (words[0].equals("can"))
			return "I often wonder if it can";
		
		// why did
		if (words[0].equals("why")&&words[1].equals("did"))
			return "I don't know why it happened, but we should try to figure it out.";		

		//are you
		if(str.contains("are you")) {
		      String pattern = "are you (.*)";
		      Pattern r = Pattern.compile(pattern);
		      Matcher m = r.matcher(str);
		      if (m.find( )) {
		    	  return "I don't know whether or not I am "+m.group(1)+". I am a chat bot.";
		      }			
		}
		
		if(str.contains("do you know"))
			return "I dont know";
		
				
		//word length
		if (str.length()<5)
			return "Could you please ask it in different way";
						
		return " ";
	}
}
