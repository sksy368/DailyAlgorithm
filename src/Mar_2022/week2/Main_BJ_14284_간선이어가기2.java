package Mar_2022.week2;

import java.util.*;
import java.io.*;

public class Main_BJ_14284_간선이어가기2 {
	
	static class Edge implements Comparable<Edge> {
		int vertex, weight;
		Edge(int vertex, int weight){
			this.vertex = vertex;
			this.weight = weight;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int N, M, S, T;
	static ArrayList<Edge>[] adjList;
	static int[] distance;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		adjList = new ArrayList[N+1];
		distance = new int[N+1];
		
		for(int n = 1; n <= N; n++) adjList[n] = new ArrayList<>();
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList[a].add(new Edge(b, c));
			adjList[b].add(new Edge(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken()); // 시작점
		T = Integer.parseInt(st.nextToken()); // 도착점
		
		dijkstra();
		
		System.out.println(distance[T]);
	}
	
	public static void dijkstra() {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		
		queue.offer(new Edge(S, 0));
		distance[S] = 0;
		
		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			
			for(Edge next : adjList[cur.vertex]) {
				if(distance[next.vertex] > distance[cur.vertex] + next.weight) {
					distance[next.vertex] = distance[cur.vertex] + next.weight;
					queue.offer(new Edge(next.vertex, next.weight));
				}
			}
		}
	}
}
