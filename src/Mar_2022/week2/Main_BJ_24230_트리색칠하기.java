package Mar_2022.week2;

import java.util.*;
import java.io.*;

public class Main_BJ_24230_트리색칠하기 {
	
	static int N, cnt;
	static int[] color;
	static ArrayList<Integer>[] adjList;
	static boolean[] checked;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 정점 개수
		cnt = 0; // 색칠 횟수
		
		color = new int[N+1]; // 색 정보 (0:하얀색)
		st = new StringTokenizer(br.readLine());
		for(int n = 1; n <= N; n++) color[n] = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		checked = new boolean[N+1];
		for(int n = 1; n <= N; n++) adjList[n] = new ArrayList<>();
		
		for(int n = 0; n < N-1; n++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			adjList[start].add(end);
			adjList[end].add(start); 
		}
		
		HashSet<Integer> colors = new HashSet<>();
		colors.add(0);
		checked[1] = true;
		dfs(1, colors);
		
		System.out.println(cnt);
	}
	
	public static void dfs(int now, HashSet<Integer> colors) {
		for(int next : adjList[now]) {
			if(!checked[next]) {
				if(color[next] != 0) {
					if(color[now] == 0)
						colors = new HashSet<Integer>();
					
					colors.add(color[next]);
				}
	
				checked[next] = true;
				dfs(next, colors);
				
				if(color[now] == 0 && color[next] != 0) cnt += colors.size();
			}
		}
	}	
}