package Sep_2021.week3;

import java.util.*;
import java.io.*;

public class Main_BJ_1753_최단경로 {
	
	static int V, E, K;
	static ArrayList<Vertex>[] head;
	static int[] distance;
	static boolean[] checked;
	
	static class Vertex {
		int end, weight;
		
		Vertex(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		K = Integer.parseInt(br.readLine()); // 시작 정점의 번호
		
		head = new ArrayList[V+1];
		for(int i = 0; i < V+1; i++)
			head[i] = new ArrayList<>();
		distance = new int[V+1];
		checked = new boolean[V+1];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
		
			head[start].add(new Vertex(end, weight));
		}
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[K] = 0;
		
		for(int i = 0; i < V; i++) {
			int idx = -1;
			int min = Integer.MAX_VALUE;
			for(int j = 1; j < V+1; j++) {
				if(!checked[j] && min>distance[j]) {
					min = distance[j];
					idx = j;
				}
			}
			if(idx == -1) break;
			
			checked[idx] = true;
			for(Vertex v : head[idx]) {
				if(!checked[v.end] && distance[v.end] > v.weight+distance[idx])
					distance[v.end] = v.weight + distance[idx];
			}
		}
		
		for(int i = 1; i < V+1; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(distance[i]);
		}
	}
}