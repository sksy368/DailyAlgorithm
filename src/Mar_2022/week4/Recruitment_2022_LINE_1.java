package Mar_2022.week4;

import java.util.*;

public class Recruitment_2022_LINE_1 {
	
	static String[] log = {"team_name", "application_name", "error_level", "message"};
	
	public static int solution(String[] logs) {
		StringTokenizer st;
		int answer = 0;
		
		for(int i = 0; i < logs.length; i++) {
			int logLen = logs[i].length();
			
			String str = logs[i];
			st = new StringTokenizer(str);
			boolean flag = false;
			int sum = 0;
			
			for(int j = 0; j < 4; j++) sum += log[j].length(); // 로그 이름 길이 더하기
			sum += 15; // 중간에 있는 띄어쓰기나 ':' 개수
			
			for(int j = 0; j < 4; j++) {
				if(!st.hasMoreTokens() || !log[j].equals(st.nextToken())) { // 로그 이름이 아닌 경우
					flag = true;
					break;
				}
				
				if(!st.hasMoreTokens()) {
					flag = true;
					break;
				}
				st.nextToken(); // :버리기
				
				if(!st.hasMoreTokens()) {
					flag = true;
					break;
				}
				String context = st.nextToken(); // 로그 내용
				sum += context.length(); // 로그 내용 길이 더하기
				
				for(int k = 0; k < context.length(); k++) {
					char c = context.charAt(k);
					if((c >= 'A' && c <= 'Z') || (c >='a' && c <='z')) continue; // 로그 내용이 알파벳인 경우
					else { // 로그 내용이 알파벳이 아닌 경우
						flag = true;
						break;
					}
				}
				
				if(flag) break;
			}
			
			if(logLen > 100 || flag || sum != logLen) { // 로그 길이가 100을 초과하거나 총길이와 계산한 길이가 아닌 경우(=중간에 띄어쓰기가 있는 경우)
				answer++; // 길이가 100을 넘을 때
			}
		}
		
		return answer;
	}
}
