package Algorithm.Graph;

import java.util.*;
import java.io.*;

public class DijkstraTest {
	
	static class Edge {
		int vertex, weight;
		Edge (int vertex, int weight){
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 정점 개수
		int E = Integer.parseInt(st.nextToken()); // 간선 개수
		int K = Integer.parseInt(br.readLine()); // 시작 정점 번호
		
		ArrayList<Edge>[] weight = new ArrayList[V+1];
		int[] distance = new int[V+1]; Arrays.fill(distance, Integer.MAX_VALUE);
		boolean[] checked = new boolean[V+1];
		
		for(int i = 1; i <= V; i++)
			weight[i] = new ArrayList<>();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			weight[u].add(new Edge(v, w));
		}
		
		distance[K] = 0;
//		checked[K] = true;
		
		for(int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			
			for(int j = 1; j <= V; j++) {
				if(!checked[j] && min > distance[j]) {
					min = distance[j];
					idx = j;
				}
			}
			
			if(idx == -1) break;
			
			checked[idx] = true;
			
			for(Edge e : weight[idx]) {
				if(!checked[e.vertex] && distance[e.vertex] > distance[idx]+e.weight)
					distance[e.vertex] = distance[idx]+e.weight;
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(distance[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}
}
