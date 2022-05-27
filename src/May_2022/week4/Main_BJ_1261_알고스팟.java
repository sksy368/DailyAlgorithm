package May_2022.week4;

import java.util.*;
import java.io.*;

public class Main_BJ_1261_알고스팟 {
	
	static class Point implements Comparable<Point> {
		int row, column, cnt;
		Point(int row, int column, int cnt){
			this.row = row;
			this.column = column;
			this.cnt = cnt;
		}
		public int compareTo(Point o) {
			return Integer.compare(this.cnt, o.cnt);
		}
	}
	
	static int N, M;
	static int[][] map, D = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 미로의 가로 크기
		N = Integer.parseInt(st.nextToken()); // 미로의 세로 크기
		map = new int[N+1][M+1];
		
		for(int n = 1; n <= N; n++) {
			String input = br.readLine();
			for(int m = 1; m <= M; m++) {
				map[n][m] = Integer.parseInt(input.charAt(m-1)+""); // 0:빈방, 1:방
			}
		}
		
		dijkstra();
	}
	
	public static void dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[][] checked = new boolean[N+1][M+1];
		
		pq.offer(new Point(1, 1, 0));
		checked[1][1] = true;
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if(cur.row == N && cur.column == M) {
				System.out.println(cur.cnt);
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nextR = cur.row + D[d][0];
				int nextC = cur.column + D[d][1];
				
				if(nextR<=0 || nextR>N || nextC<=0 || nextC>M || checked[nextR][nextC]) continue;
				
				checked[nextR][nextC] = true;
							
				pq.offer(new Point(nextR, nextC, map[nextR][nextC]==1 ? cur.cnt+1 : cur.cnt));
			}
		}
	}
}
