package com.spring.ai.utility;

import org.springframework.stereotype.Service;

@Service
public class UtilityService {
	
	String WHwords[][]={
					{"what time", "ANS"},
					{"what is", "DEFINITION"},
					{"what about", "DEFINITION"},
					{"what kind", "ANS"},
					{"what do you","DEFINITION"},
					{"how many", "ANS"},
					{"how much", "ANS"},
					{"how long", "ANS"},
					{"how often", "ANS"},
					{"how far","ANS"},
					{"how do you","DEFINITION"},
					{"how old","ANS"},
					{"how come","DEFINITION"},
					{"where do",null},
					{"do you",null},
					{"can you",null},
					{"what is", "DESCRIPTION"},
					{"who", "DEFINITION"},
					{"where","ANS"},
					{"why", "DEFINITION"},
					{"when", "ANS"},
					{"how", "DEFINITION"},
					{"what","ANS"},
					{"which", "ANS"},
					{"whose","ANS"}
					};
	
	String removeWords[] = {"am","is","are","was","ware","you","the","that","this","in","on"};
	
	public boolean isWHWord(String str) {
		for (String[] word : WHwords) {
			if (str.equalsIgnoreCase(word[0])) {
				return true;
			}
		}
		return false;
	}
	
	public String[] removeCommonWords(String targetSentance[]) 
	{
		for (int i=0;i<targetSentance.length;i++) {
			for (String word : removeWords) {
				if(targetSentance[i].equalsIgnoreCase(word))
					targetSentance[i] = " ";
			}
		}
		return targetSentance;
	}
	
	
	public String getAnsType(String str) {
		String anstype = null;
		for (String[] word : WHwords) {
			if (str.contains(word[0])) {
				anstype = word[1];
				break;
			}
		}
		return anstype;
	}

	public String format(String str)
	{
		String words[]= {". Wikipedia",
		"· Text under CC-BY-SA license"};
		for (int i = 0; i < words.length; i++) {
			str =str.replace(words[i], "");
		}
		return str;
	}	
}
