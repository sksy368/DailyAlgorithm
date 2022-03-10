package Mar_2022.week2;

import java.util.*;
import java.io.*;

public class Main_BJ_18223_민준이와마산그리고건우 {
	
	static class Edge {
		int vertex, weight;
		Edge (int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	static int V, E, P;
	static ArrayList<Edge>[] adjList;
	static int[] distance;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		P = Integer.parseInt(st.nextToken()); // 건우가 위치한 정점
		
		adjList = new ArrayList[V+1]; // 인접 리스트
		distance = new int[V+1];
		
		for(int v = 1; v <= V; v++) adjList[v] = new ArrayList<>();
		
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()); // 정점
			int b = Integer.parseInt(st.nextToken()); // 정점
			int c = Integer.parseInt(st.nextToken()); // 정점 사이의 거리
			
			adjList[a].add(new Edge(b, c));
			adjList[b].add(new Edge(a, c));
		}
		
		dijkstra();
	}
	
	public static void dijkstra() {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		boolean[] checked = new boolean[V+1];
		
		queue.offer(new Edge(1, 0));
		checked[1] = true;
		
		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			
			
		}
	}

}
