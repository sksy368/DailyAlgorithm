package Mar_2022.week3;

import java.util.*;
import java.io.*;

public class Main_BJ_18223_민준이와마산그리고건우 {
	
	static class Edge implements Comparable<Edge> {
		int vertex, weight;
		ArrayList<Integer> path;
		Edge (int vertex, int weight, ArrayList<Integer> path) {
			this.vertex = vertex;
			this.weight = weight;
			this.path = path;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V, E, P;
	static ArrayList<Edge>[] adjList;
	static ArrayList<ArrayList<Integer>>[] paths;
	static int[] distance;
	static String answer = "GOOD BYE";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		P = Integer.parseInt(st.nextToken()); // 건우가 위치한 정점
		
		adjList = new ArrayList[V+1]; // 인접 리스트
		paths = new ArrayList[V+1]; // 경로
		distance = new int[V+1]; // 해당 노드까지의 거리
		
		for(int v = 1; v <= V; v++) {
			adjList[v] = new ArrayList<>();
			paths[v] = new ArrayList<>();
		}
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()); // 정점
			int b = Integer.parseInt(st.nextToken()); // 정점
			int c = Integer.parseInt(st.nextToken()); // 정점 사이의 거리
			
			adjList[a].add(new Edge(b, c, null));
			adjList[b].add(new Edge(a, c, null));
		}
		
		dijkstra();
		
//		System.out.println("distance: ");
//		for(int i = 1; i <= V; i++) System.out.print(distance[i] + " ");
//		System.out.println("\nlist: ");
//		for(int i = 1; i <= V; i++) {
//			while(!paths[i].isEmpty())
//				System.out.println(paths[i].get(paths[i].get(0)));
//		}
		
		
	}
	
	public static void dijkstra() {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		ArrayList<Integer> path = new ArrayList<>();
		
		path.add(1);
		queue.offer(new Edge(1, 0, path));
		distance[1] = 0;
		
		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			
			for(Edge next : adjList[cur.vertex]) {
				if(distance[next.vertex] >= distance[cur.vertex] + next.weight) {
					distance[next.vertex] = distance[cur.vertex] + next.weight;
					
					ArrayList<Integer> nextPath = new ArrayList<>();
					nextPath.addAll(cur.path);
					nextPath.add(next.vertex);
					
					paths[next.vertex].add(nextPath);
					queue.offer(new Edge(next.vertex, distance[next.vertex], nextPath));
				}
				else if(distance[next.vertex] == distance[cur.vertex] + next.weight) {
					
				}
			}
		}
	}

}
