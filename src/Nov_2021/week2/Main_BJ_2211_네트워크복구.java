package Nov_2021.week2;

import java.util.*;
import java.io.*;

public class Main_BJ_2211_네트워크복구 {
	
	static class Edge implements Comparable<Edge>{
		int computer, time;
		public Edge(int computer, int time) {
			super();
			this.computer = computer;
			this.time = time;
		}
		public int compareTo(Edge e) {
			return this.time - e.time;
		}
	}
	
	static int N, M, min;
	static int INF = 987654321;
	static ArrayList<Edge>[] adjList;
	static int[] distance;
	static int[] result;
	
	public static void dijkstra() {
		distance = new int[N+1];
		result = new int[N+1];
		
		Arrays.fill(distance, INF);
		distance[1] = 0;
		result[1] = -1;
		
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(1, 0));
		
		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			
			if(cur.time > distance[cur.computer]) continue;
				
			for(Edge e : adjList[cur.computer]) {
				if(distance[e.computer] > cur.time + e.time) {
					distance[e.computer] = cur.time + e.time;
					result[e.computer] = cur.computer;
					queue.offer(new Edge(e.computer, distance[e.computer]));
				}
			}
		}
		
		System.out.println(N-1);
		
		for(int i = 2; i <= N; i++){
			System.out.println(i + " " + result[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 컴퓨터 수
		M = Integer.parseInt(st.nextToken()); // 회선 수
		
		adjList = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken()); // 컴퓨터 A와 컴퓨터 B의 통신 시간
			
			adjList[A].add(new Edge(B, C));
			adjList[B].add(new Edge(A, C));
		}
		
		dijkstra();

	}
}