package Apr_2022.week2;

import java.util.*;

public class Solution_42888_오픈채팅방 { 

	 public String[] solution(String[] record) {
	        StringTokenizer st;
	        HashMap<String, String> users = new HashMap<>(); // key:유저 아이디, value:닉네임
	        ArrayList<String> answerList = new ArrayList<>();
	        
	        for(int i = 0; i < record.length; i++) {
	        	st = new StringTokenizer(record[i]);
	        	
	        	String verb = st.nextToken(); // Enter/Leave/Change
	        	String id = st.nextToken(); // 유저 아이디
	        	
	        	if(verb.equals("Change")) {
	        		users.put(id, st.nextToken());
	        		continue;
	        	}
	        	else if(verb.equals("Enter")) {
	        		users.put(id, st.nextToken());
	        		answerList.add(id + " 님이 들어왔습니다.");
	        	}
	        	else 
	        		answerList.add(id + " 님이 나갔습니다.");
	        }
	        
	        String[] answer = new String[answerList.size()];
	        
	        for(int i = 0; i < answer.length; i++) {
	        	st = new StringTokenizer(answerList.get(i));
	        	
	        	answer[i] = users.get(st.nextToken()) + st.nextToken() + " " + st.nextToken();
	        }
	        
	        
	        return answer;
	 }
}