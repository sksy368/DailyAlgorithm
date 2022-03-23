package Algorithm.Graph.Practice_0823;

import java.io.*;
import java.util.*;

public class Solution_SWEA_1238_Contact {
	
	static class Person {
		int no, time;
		public Person (int no, int time) {
			super();
			this.no = no;
			this.time = time;
		}
	}
	
	static int N;
	static ArrayList<Integer>[] adjList;
	static int[] time;
	
	
	private static void bfs(int start) {
		Queue<Person> queue = new LinkedList<>();
		
		queue.offer(new Person(start, 1));
		time[start] = 1;
		
		while(!queue.isEmpty()) {
			Person cur = queue.poll();
			int curNo = cur.no;
			int curTime = cur.time;
			
			for(int i = 0; i < adjList[curNo].size(); i++) {
				int node = adjList[curNo].get(i);
				
				if(time[node] == 0) {
					queue.offer(new Person(node, curTime+1));
					time[node] = curTime+1;
				}
			}
		}
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 입력받는 데이터 길이
			int start = Integer.parseInt(st.nextToken()); // 시작점
			
			adjList = new ArrayList[101]; // 최대 100명
			for(int i = 1; i <= 100; i++)
				adjList[i] = new ArrayList<>();
			
			time = new int[101];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i< N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjList[from].add(to);
			}
			
			bfs(start);
			
			int lastIdx = 0, max = Integer.MIN_VALUE;
			for(int i = 1; i <= 100; i++) {
				if(time[i] >= max) {
					max = time[i];
					lastIdx = i;
				}
			}
			System.out.println("#" + t + " " + lastIdx);
		}
	}
}