package November.week2;

import java.util.*;
import java.io.*;

public class Main_BJ_14248_점프점프 {
	
	static int n, s, cnt;
	static int[] bridge;
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		
		queue.offer(s);
		visited[s] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			int leftIdx = cur - bridge[cur];
			int rightIdx = cur + bridge[cur];
			
			if(leftIdx > 0 && !visited[leftIdx]) {
				queue.offer(leftIdx);
				visited[leftIdx] = true;
				cnt++;
			}
			
			if(rightIdx <= n && !visited[rightIdx]) {
				queue.offer(rightIdx);
				visited[rightIdx] = true;
				cnt++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		bridge = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++)
			bridge[i] = Integer.parseInt(st.nextToken());
		
		s = Integer.parseInt(br.readLine());
		
		cnt = 1;
		bfs();
		
		System.out.println(cnt);
	}
}