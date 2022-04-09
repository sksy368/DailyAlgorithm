package Apr_2022.week2;

import java.util.*;

public class Recruitment_2022_오늘의집_3 {
	public static void main(String[] args) {
		String tString = "{a} {b} {c} {d} {i}";
		String[][] variables = {{"b", "{c}"}, {"a", "{b}"}, {"e", "{f}"}, {"h", "i"}, {"d", "{e}"}, {"f", "{d}"}, {"c", "d"}};
		
		System.out.println(solution(tString, variables));
	}
	
	public static String solution(String tString, String[][] variables) {
		HashMap<String, String> map = new HashMap<>();
		for(int i= 0; i < variables.length; i++) map.put(variables[i][0], variables[i][1]);
		
		String answer = tString.charAt(0)=='{' ? "" : tString.charAt(0)+"";
		String word = "";
		
		for(int i = 1; i < tString.length(); i++) {
			
			if(tString.charAt(i) == '{') continue;
			
			if(tString.charAt(i-1) == '{' || (word != "" && tString.charAt(i) != '}')) {
				word += tString.charAt(i);
				continue;
			}
			
			if(tString.charAt(i) == '}') {
				String newWord = map.get(word);
				
				if(newWord == null) newWord = word;
				
				while(newWord != null) {
					if(!newWord.contains("{") || newWord.substring(1, newWord.length()-1).equals(word)) break;
						
					String temp = map.get(newWord.substring(1, newWord.length()-1));
					if(temp != null) newWord = temp;
					else break;
				}
				
				answer += newWord;
				word = "";
				continue;
			}
			
			answer += tString.charAt(i);
		}
		
		return answer;
	}
}
