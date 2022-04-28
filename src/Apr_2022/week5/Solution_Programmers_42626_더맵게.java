package Apr_2022.week5;

import java.util.*;

class Solution_Programmers_42626_더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville) pq.offer(i);
        
        int cnt = 0;
        
        while(pq.size() > 1 && pq.peek() < K) {
            int low1 = pq.poll(); // 가장 맵지 않은 음식의 스코빌 지수
            int low2 = pq.poll(); // 두 번째로 맵지 않은 음식의 스코빌 지수
            
            pq.offer(low1 + low2*2);
            cnt++;
        }
        
        if(pq.size() == 1 && pq.poll() < K) return -1; // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
        
        return cnt;
    }
}
