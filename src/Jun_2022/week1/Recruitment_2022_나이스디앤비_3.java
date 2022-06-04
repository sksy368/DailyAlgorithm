package Jun_2022.week1;

import java.util.*;

public class Recruitment_2022_나이스디앤비_3 {
	
	static class Friend {
		int no, cnt;
		Friend(int no, int cnt){
			this.no = no;
			this.cnt = cnt;
		}
	}
	
	public  String[] solution(String[][] friends, String user_id) {
		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();
		
		for(int i = 0; i < friends.length; i++) {
			if(!map.containsKey(friends[i][0])) {
				map.put(friends[i][0], map.size());
				list.add(friends[i][0]);
			}
			if(!map.containsKey(friends[i][1])) {
				map.put(friends[i][1], map.size());
				list.add(friends[i][1]);
			}
		}
		
		int size = map.size();
	
		ArrayList<Integer>[] adjList = new ArrayList[size];
		for(int i = 0; i < adjList.length; i++) adjList[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < friends.length; i++) {
			adjList[map.get(friends[i][0])].add(map.get(friends[i][1]));
			adjList[map.get(friends[i][1])].add(map.get(friends[i][0]));
		}
		
		Queue<Friend> queue = new LinkedList<>();
		boolean[][] checked = new boolean[size][size];
		int[] way = new int[size];
		
		queue.offer(new Friend(map.get(user_id), 0));
		checked[map.get(user_id)][map.get(user_id)] = true;
		
		while(!queue.isEmpty()) {
			Friend cur = queue.poll();
			
			if(cur.cnt>1) way[cur.no] += 1;
			
			for(int i : adjList[cur.no]) {
				if(checked[cur.no][i] || checked[i][cur.no]) continue;
				
				queue.offer(new Friend(i, cur.cnt+1));
				checked[cur.no][i] = checked[i][cur.no] = true;
			}
		}
		
		int max = 0;
		ArrayList<String> ansList = new ArrayList<>();
		
		for(int i = 0; i < size; i++) {
			if(way[i] == max) ansList.add(list.get(i));
			else if(way[i] > max) {
				ansList.clear();
				ansList.add(list.get(i));
				max = way[i];
			}
		}
		
		Collections.sort(ansList);
		String[] answer = ansList.toArray(new String[0]);
		
		return answer;
	}
}