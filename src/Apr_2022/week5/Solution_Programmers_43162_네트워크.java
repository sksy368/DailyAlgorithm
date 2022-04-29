package Apr_2022.week5;

import java.util.*;

public class Solution_Programmers_43162_네트워크 {
	public int solution(int n, int[][] computers) {

        ArrayList<Integer>[] network = new ArrayList[n];
        for(int i = 0; i < n; i++) network[i] = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(computers[i][j] == 1) network[i].add(j);
            }
        }
        
        int cnt = 0;
        boolean[] checked = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!checked[i]) {
                bfs(i, network, checked);
                cnt++;
            }
        }
        
        return cnt;
    }
    
    public void bfs(int start, ArrayList<Integer>[] network, boolean[] checked) {
        Queue<Integer> queue = new LinkedList<>();
        
        checked[start] = true;
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int i : network[cur]){
                if(checked[i]) continue;
                checked[i] = true;
                queue.offer(i);
            }
        }
    }
}
