package Apr_2022.week5;

import java.util.*;

public class Solution_Programmers_42587_프린터 {
	
	static class Task {
        int loc, priority;
        
        Task(int loc, int priority){
            this.loc = loc; // 위치
            this.priority = priority; // 우선순위
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Task> tasks = new LinkedList<>();
        PriorityQueue<Integer> num = new PriorityQueue<>(new Comparator<Integer>(){ // 우선순위들
            public int compare(Integer o1, Integer o2){
                return o2 - o1; // 내림차순
            }
        });
        
        for(int i = 0; i < priorities.length; i++){
        	tasks.offer(new Task(i, priorities[i]));
            num.offer(priorities[i]);
        }
        
        int cnt = 0;
        int curPriority = num.poll(); // 현재 가장 높은 우선순위
        
        while(!tasks.isEmpty()){
            Task curTask = tasks.poll();
            
            if(curTask.priority == curPriority) { // 현재 문서의 우선순위가 가장 높은 경우
                cnt++;
                
                if(curTask.loc==location || num.isEmpty()) break;
                
                curPriority = num.poll();
            }
            else tasks.offer(curTask); // 현재 문서의 우선순위가 가장 높지 않은 경우
        }
        
        return cnt;
    }
}