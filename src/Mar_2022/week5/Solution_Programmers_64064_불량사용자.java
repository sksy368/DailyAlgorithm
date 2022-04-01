package Mar_2022.week5;

import java.util.*;

public class Solution_Programmers_64064_불량사용자 {
	
	static int answer;
	
	public static void main(String[] args) {
		String[] user = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] ban = {"fr*d*", "abc1**"};
		solution(user, ban);
		
		System.out.println(answer);
	}
	
	public static int solution(String[] user_id, String[] banned_id) { // 응모자 아이디 목록, 불량 사용자 아이디 목록
		answer = 0;
        
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> num = new HashMap<>();
      
        for(int i = 0; i < banned_id.length; i++){
            for(int j = 0; j < user_id.length; j++){
                if(isRight(banned_id[i], user_id[j])) {
                	
                	HashSet<String> set;
                	
                	if(map.containsKey(banned_id[i])) set = map.get(banned_id[i]);
                	else set = new HashSet<>();
                	
                	set.add(user_id[j]);
                	map.put(banned_id[i], set);
                	System.out.println(user_id[j] + "와 " + banned_id[i] + "는 같다.");
                }
                
                System.out.println(user_id[j] + "와 " + banned_id[i] + "는 다르다.");
            }
        }
        
        for(int i = 0; i < banned_id.length; i++) {
        	answer *= map.get(banned_id[i]).size();
        }
        
        return answer;
    }
	
//	public static void dfs(String[] user_id, String[] banned_id, int cnt, boolean[] checked) {
//		if(cnt == banned_id.length) {
//			answer++;
//		}
//		
//		for(int i = 0; i < banned_id.length; i++) {
//			for(int j = 0; j < user_id.length; j++) {
//				if(checked[j]) continue;
//				
//				if(isRight(banned_id[i], user_id[j])) { // 일치하는 경우
//					checked[j] = true;
//					dfs(user_id, banned_id, cnt+1, checked);
//					checked[j] = false;
//				}
//			}
//		}
//	}
	
	public static boolean isRight(String ban, String user) {
		ArrayList<Character> list = new ArrayList<>();
		String s = "";
		int lastIdx = 0;
		
		for(int i = 0; i < ban.length(); i++) {
			if(ban.charAt(i) == '*') {
				if(s.length() != 0) {
					int idx = user.indexOf(s, lastIdx);
					lastIdx = idx + s.length();
                    System.out.println("idx: " + idx + "   lastIdx: " + lastIdx);
					list.add((char)idx);
				}
				else 
					lastIdx = i+1;
				
				list.add('*');
				s = "";
				continue;
			}
			
			s += ban.charAt(i);
            System.out.println("s: " + s);
            System.out.println("listSize: " + list.size());
		}
        if(s.length() != 0) {
            int idx = user.indexOf(s, lastIdx);
            lastIdx = idx + s.length();
            list.add((char)idx);
        }
        
        System.out.println("lastIdx: " + lastIdx);
        System.out.println("listSize: " + list.size());
		
		if(lastIdx != user.length()) return false;
		
		char c;
		int idx = 0;
		for(int i = 0; i < user.length(); i++) {
			c = list.get(idx);
			
			if(c == '*') i++;
			else {
				if(c-'0' > i) return false;
				else i = c-'0';
			}
		}
		
		return true;
	}
}