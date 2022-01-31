package Jan_2022.week2;

import java.util.*;
import java.io.*;

public class Main_BJ_1058_친구 {
	
	static class Relationship {
		int num, cnt;
		Relationship(int num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	static int N, max;
	static LinkedList<Integer>[] friends;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 사람의 수
		friends = new LinkedList[N];
		max = 0;
		
		for(int n = 0; n < N; n++) // 배열의 각 인덱스에 LinkedList 세팅
			friends[n] = new LinkedList<Integer>();
		
		for(int n1 = 0; n1 < N; n1++) {
			String s = br.readLine();
			for(int n2 = n1; n2 < N; n2++) {
				if(s.charAt(n2) == 'Y') { // n1과 n2가 친구인 경우 
					friends[n1].offer(n2);
					friends[n2].offer(n1);
				}
			}
		}
		
		for(int n = 0; n < N; n++)
			bfs(n);
		
		System.out.println(max);
	}
	
	static void bfs(int n) {
		Queue<Relationship> queue = new LinkedList<>();
		boolean[] checked = new boolean[N];
		int cnt = 0;
			
		queue.offer(new Relationship(n, 0));
		checked[n] = true;
			
		while(!queue.isEmpty()) {
			Relationship cur = queue.poll();
			
			if(cur.cnt >= 2) continue;
			
			for(int r : friends[cur.num]) {
				if(!checked[r]) {
					queue.offer(new Relationship(r, cur.cnt+1));
					checked[r] = true;
					cnt++;
				}
			}
		}
		
		max = Math.max(cnt, max);
	}
}