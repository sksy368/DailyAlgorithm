package Apr_2022.week2;

import java.util.*;

public class Recruitment_2022_오늘의집_2 {
	
	public static void main(String[] args) {
		String call = "ABCabcA";
		System.out.println(solution(call));
	}
	
	public static String solution(String call) {
		int max = 0;
		ArrayList<String> maxPattern = new ArrayList<>(); // 말버릇 패턴 리스트
		
		for(int i = 0; i < call.length(); i++) {
			loop:for(int j = i+1; j <= call.length(); j++) {
				String tempCall = new String(call.toLowerCase());
				String pattern = tempCall.substring(i, j); // 말버릇 패턴
				int cnt = 0; // 말버릇 패턴의 등장 개수
				
				while(tempCall.contains(pattern)) {
					int idx = tempCall.indexOf(pattern);
					tempCall = tempCall.substring(idx+pattern.length());
					cnt++;
				}
				
				if(cnt >= max) {
					
					for(int k = 0; k < maxPattern.size(); k++) {
						if(maxPattern.get(k).contains(pattern))
							break loop; // 이미 등록된 말버릇 패턴의 일부인 경우
						else if(pattern.contains(maxPattern.get(k))) // 이미 등록된 말버릇 패턴이 일부인 경우
							maxPattern.remove(k--);
					}
					
					if(cnt > max) maxPattern = new ArrayList<>();
					maxPattern.add(pattern);
					max = cnt;
				}
			}
		}
		
		for(int i = 0; i < maxPattern.size(); i++) {
			String word = maxPattern.get(i);
			
			while(call.toLowerCase().contains(word)) { // 대소문자 상관없이 말버릇 패턴을 포함하는 경우
				int idx = call.toLowerCase().indexOf(word);
				call = call.substring(0, idx) + call.substring(idx+word.length());
			}
		}
		
		return call;
	}
}
