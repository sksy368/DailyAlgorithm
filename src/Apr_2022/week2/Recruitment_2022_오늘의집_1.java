package Apr_2022.week2;

import java.util.*;

public class Recruitment_2022_오늘의집_1 {

	public static void main(String[] args) {
		String[] answer = solution("EEESEEEEEENNNN");
		
		for(int i = 0; i < answer.length; i++) System.out.println(answer[i]);
	}
	
	public static String[] solution(String path) {
		ArrayList<String> messages = new ArrayList<>();
		
		int time = 0; // 시간
		String nowPath = path.charAt(0)+"";
		char beforeD = path.charAt(0); // 이전 방향
		
		for(int i = 1; i < path.length(); i++) {
			time++;
			
			char nowD = path.charAt(i); // 현재 방향
			
			if(nowD == beforeD) { // 직진인 경우
				nowPath += nowD;
				continue;
			}
			
			int printTime = nowPath.length()>5 ? time-5 : time-nowPath.length();
			int dist = nowPath.length()>5 ? 5 : nowPath.length();
			int beforeDnum = direct(beforeD);
			int nowDnum = direct(nowD);
			String direction = "";
			
			if((nowDnum-beforeDnum+4)%4 == 1) direction = "left";
			else direction = "right";
			
			String message = "Time " + printTime + ": Go strainght " + dist*100 + "m and turn " + direction;
			
			messages.add(message);
			
			beforeD = nowD;
			nowPath = beforeD+"";
		}
		
		String[] answer = new String[messages.size()];
		for(int i = 0; i < messages.size(); i++)
			answer[i] = messages.get(i);
		
		return answer;
	}
	
	public static int direct(char c) {
		if(c == 'E') return 0;
		else if(c == 'N') return 1;
		else if(c == 'W') return 2;
		else return 3;
	}
}
