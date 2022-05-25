package May_2022.week3;

import java.io.*;
import java.util.*;

public class Main_BJ_14497_주난의난 {
	
	public static class Point implements Comparable<Point> {
		int row, column, time;
		public Point(int row, int column, int time) {
			this.row = row;
			this.column = column;
			this.time = time;
		}
		public int compareTo(Point o) {
			return this.time - o.time;
		}
	}
	
	static int N, M, curR, curC, thiefR, thiefC;
	static char[][] map;
	static int[][] D = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 교실의 세로 크기
		M = Integer.parseInt(st.nextToken()); // 교실의 가로 크기
		map = new char[N+1][M+1];
		
		st = new StringTokenizer(br.readLine());
		curR = Integer.parseInt(st.nextToken()); // 주난이의 위치(행)
		curC = Integer.parseInt(st.nextToken()); // 주난이의 위치(열)
		thiefR = Integer.parseInt(st.nextToken()); // 범인의 위치(행)
		thiefC = Integer.parseInt(st.nextToken()); // 범인의 위치(열)
		
		for(int n = 1; n <= N; n++) {
			String input = br.readLine();
			for(int m = 1; m <= M; m++)
				map[n][m] = input.charAt(m-1); // *:주난, #:초코바, 1:친구, 0:빈공간
		}
		
		dijkstra();
	}
	
	public static void dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[][] checked = new boolean[N+1][M+1];
		
		pq.offer(new Point(curR, curC, 0));
		checked[curR][curC] = true;
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if(cur.row==thiefR && cur.column==thiefC) {
				System.out.println(cur.time);
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nextR = cur.row + D[d][0];
				int nextC = cur.column + D[d][1];
				
				if(nextR<=0 || nextR>N || nextC<=0 || nextC>M || checked[nextR][nextC]) continue;
				
				checked[nextR][nextC] = true;
				
				pq.offer(new Point(nextR, nextC, map[nextR][nextC]=='0' ? cur.time : cur.time+1));
			}
		}
	}

}
