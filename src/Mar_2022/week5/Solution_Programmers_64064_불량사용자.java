package Mar_2022.week5;

public class Solution_Programmers_64064_불량사용자 {
	
	static int answer;
	
	public int solution(String[] user_id, String[] banned_id) { // 응모자 아이디 목록, 불량 사용자 아이디 목록

        boolean[] checked = new boolean[user_id.length];
        
        dfs(user_id, banned_id, 0, checked);
        
        return answer;
    }
	
	public static void dfs(String[] user_id, String[] banned_id, int cnt, boolean[] checked) {
		if(cnt == banned_id.length) {
			answer++;
		}
		
		for(int i = 0; i < banned_id.length; i++) {
			for(int j = 0; j < user_id.length; j++) {
				if(checked[j]) continue;
				
				if(ch) { // 일치하는 경우
					checked[j] = true;
					dfs(user_id, banned_id, cnt+1, checked);
					checked[j] = false;
				}
			}
		}
	}
}