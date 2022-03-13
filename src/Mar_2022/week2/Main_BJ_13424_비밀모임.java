package Mar_2022.week2;

import java.util.*;
import java.io.*;

public class Main_BJ_13424_비밀모임 {
	
	static class Path implements Comparable<Path> {
		int room, len;
		Path(int room, int len){
			this.room = room; // 방의 번호
			this.len = len; // 비밀통로의 길이
		}
		
		public int compareTo(Path o) {
			return Integer.compare(this.len, o.len);
		}
	}
	
	static int N, M, K;
	static ArrayList<Path>[] adjList;
	static int[] friends;
	static int[][] totalLen;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 수
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 방의 개수
			M = Integer.parseInt(st.nextToken()); // 비밀통로 개수
			
			adjList = new ArrayList[N+1];
			for(int n = 1; n <= N; n++) adjList[n] = new ArrayList<>();
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				adjList[a].add(new Path(b, c));
				adjList[b].add(new Path(a, c));
			}
			
			K = Integer.parseInt(br.readLine()); // 친구의 수
			friends = new int[K];
			totalLen = new int[K][N+1];
			for(int k = 0; k < K; k++) Arrays.fill(totalLen[k], Integer.MAX_VALUE);
			
			st = new StringTokenizer(br.readLine());
			for(int k = 0; k < K; k++) {
				friends[k] = Integer.parseInt(st.nextToken());
				dijkstra(k, friends[k]);
			}
			
			int no = 0;
			int min = Integer.MAX_VALUE;
			for(int n = 1; n <= N; n++) {
				int total = 0;
				for(int k = 0; k < K; k++)
					total += totalLen[k][n];
				
				if(min > total) {
					min = Math.min(total, min);
					no = n;
				}
			}
			
			System.out.println(no);
		}
	}
	
	public static void dijkstra(int no, int start) {
		PriorityQueue<Path> queue = new PriorityQueue<>();

		queue.offer(new Path(start, 0));
		totalLen[no][start] = 0;
		
		while(!queue.isEmpty()) {
			Path cur = queue.poll();
			
			for(Path next : adjList[cur.room]) {
				if(totalLen[no][next.room] > totalLen[no][cur.room] + next.len) {
					totalLen[no][next.room] = totalLen[no][cur.room] + next.len;
					queue.offer(new Path(next.room, next.len));
				}
			}
		}
	}
}
