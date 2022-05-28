package May_2022.week4;

public class Solution_Programmers_64062_징검다리건너기 {

	class Solution {
	    public int solution(int[] stones, int k) {
	        int zeroCnt = 0; // 0인 디딤돌 개수
	        int answer = 0; // 징검다리를 건넌 니니즈 친구들 수
	        
	        while(true) {
	        	for(int i = 0; i < stones.length; i++) {
	                if(stones[i] == 0) zeroCnt++;
	                else {
	                    stones[i]--;
	                    zeroCnt = 0;
	                }
	                
	                if(zeroCnt >= k) return answer;
	            }
	            
	            zeroCnt = 0;
	            answer++;
	        }
	    }
	}
}