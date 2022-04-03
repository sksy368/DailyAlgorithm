package Mar_2022.week5;

import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        
        for(int i = 0; i < tickets.length; i++) {
        	String start = tickets[i][0];
        	String end = tickets[i][1];
        	PriorityQueue<String> queue;
        	
        	if(map.containsKey(start)) queue = map.get(start);
        	else queue = new PriorityQueue<>();	
        	
        	queue.add(end);
        	map.put(start, queue);
        }
        
        ArrayList<String> list = new ArrayList<>();
        list.add("ICN");
        while(true) {
            String next;
        	try {
                 next = map.get(list.get(list.size()-1)).poll();
            } catch (NullPointerException e) {
                break;
            }
            
            list.add(next);
        }
        
        if(list.get(list.size()-1) == null) list.remove(list.size()-1);
        
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        
        return answer;
    }
}