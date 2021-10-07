package October_1;

import java.util.*;
import java.io.*;

public class Main_BJ_15591_MooTube {
	
	static class Edge {
		int vertex, weight;
		Edge(int vertex, int weight){
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	static int N, Q;
	static ArrayList<Edge>[] adjList;
	
	static boolean[] checked;
	static int[] distance;
	
	private static void dijkstra(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(start);
		checked[start] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i = 0; i < adjList[cur].size(); i++) {
				int vertex = adjList[cur].get(i).vertex;
				int weight = adjList[cur].get(i).weight;
				
				if(!checked[vertex]) {
					queue.offer(vertex);
					checked[vertex] = true;
					distance[vertex] = Math.min(weight, distance[cur]);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 동영상 개수
		Q = Integer.parseInt(st.nextToken()); // 질문 개수
		
		adjList = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<>();
		
		for(int n = 0; n < N-1; n++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			adjList[p].add(new Edge(q, r));
			adjList[q].add(new Edge(p, r));
		}
		
		
		
		for(int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			checked = new boolean[N+1];
			distance = new int[N+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			
			dijkstra(v);
			
			int cnt = 0;
			for(int i = 1; i <= N; i++) {
				if(i == v) continue;
				if(distance[i] >= k) cnt++;
			}
			
			System.out.println(cnt);
		}

	}

}
