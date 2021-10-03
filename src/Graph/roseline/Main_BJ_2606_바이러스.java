package Graph.roseline;

import java.util.*;
import java.io.*;

public class Main_BJ_2606_바이러스 {
	
	static int N, E, cnt;
	static ArrayList<Integer>[] computer;
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] checked = new boolean[N+1];
		
		queue.offer(1);
		checked[1] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i = 0; i < computer[cur].size(); i++) {
				int temp = computer[cur].get(i);
				if(!checked[temp]) {
					queue.offer(temp);
					checked[temp] = true;
					cnt++;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		E = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수
		
		computer = new ArrayList[N+1];
		
		for(int i = 1; i < N+1; i++)
			computer[i] = new ArrayList<>();
		
		for(int e = 0; e < E; e++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int com1 = Integer.parseInt(st.nextToken());
			int com2 = Integer.parseInt(st.nextToken());
			
			computer[com1].add(com2);
			computer[com2].add(com1);
		}
		
		bfs();
		
		System.out.println(cnt);
	}
}