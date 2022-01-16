package Graph.roseline;

import java.util.*;
import java.io.*;

public class Dijkstra {
	
	static class Edge{
		int vertex, weight;
		Edge(int vertex, int weight){
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	static int V, E, K;
	static LinkedList<Edge>[] adjList;
	static int[] distance;
	static boolean[] checked;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); // 정점 개수
		E = Integer.parseInt(st.nextToken()); // 간선 개수
		K = Integer.parseInt(st.nextToken()); // 시작 정점 번호
		
		adjList = new LinkedList[V+1];
		for(int i = 1; i <= V; i++) // 간접 리스트 setting
			adjList[i] = new LinkedList<>();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[start].add(new Edge(end, weight));
			adjList[end].add(new Edge(start, weight));
		}
		
		dijkstra();
	}
	
	static void dijkstra() {
		PriorityQueue<Edge> queue = new PriorityQueue<>();

		distance = new int[V+1]; Arrays.fill(distance, Integer.MAX_VALUE);
		checked = new boolean[V+1];
		
		queue.offer(new Edge(K, 0));
		distance[K] = 0;
		checked[K] = true;
		
		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			
			if(checked[cur.vertex]) continue;
			
			checked[cur.vertex] = true;
			
			for(Edge next : adjList[cur.vertex]) {
				if(distance[next.vertex] > distance[cur.vertex] + next.weight){
					distance[next.vertex] = distance[cur.vertex] + next.weight;
					queue.offer(new Edge(next.vertex, distance[next.vertex]));
				}
			}
		}
	}
}
