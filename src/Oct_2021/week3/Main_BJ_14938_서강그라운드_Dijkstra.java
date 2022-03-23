package Oct_2021.week3;

import java.util.*;
import java.io.*;

public class Main_BJ_14938_서강그라운드_Dijkstra {
	
	static class Edge {
		int end, weight;
		public Edge(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
	}
	
	static int n, m, r;
	static ArrayList<Edge>[] map;
	static int[] items;
	
	private static int dijkstra(int start) {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		boolean[] checked = new boolean[n+1];
		int[] distance = new int[n+1];
		
		
		
		
		int sum = 0;
		
		for(int i = 0; i <= n+1; i++) {
			if(m >= distance[i])
				sum += items[i];
		}
		
		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 지역의 개수
		m = Integer.parseInt(st.nextToken()); // 수색범위
		r = Integer.parseInt(st.nextToken()); // 길의 개수
		
		map = new ArrayList[n+1];
		items = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++)
			items[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++)
			map[i] = new ArrayList<Edge>();
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			map[a].add(new Edge(b, l));
			map[b].add(new Edge(a, l));
		}
		
		int max = 0;
		
		for(int i = 1; i <= n; i++)
			max = Math.max(dijkstra(i), max);
		
		System.out.println(max);
	}
}