package Oct_2021.week2;

import java.util.*;
import java.io.*;

public class Main_BJ_16948_데스나이트 {
	
	static class Point {
		int row, column, count;
		public Point(int row, int column, int count) {
			super();
			this.row = row;
			this.column = column;
			this.count = count;
		}
	}
	
	static int N, r1, c1, r2, c2;
	
	static int[] dr = {-2, -2, 0, 0, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -1, 1};
	
	
	private static int bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		queue.offer(new Point(r1, c1, 0));
		visited[r1][c1] = true;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			if(cur.row == r2 && cur.column == c2) return cur.count;
			
			for(int d = 0; d < 6; d++) {
				int r = cur.row + dr[d];
				int c = cur.column + dc[d];
				
				if(r >= 0 && r < N && c >= 0 && c < N && !visited[r][c]) {
					queue.offer(new Point(r, c, cur.count+1));
					visited[r][c] = true;
				}
			}
		}
		
		return -1;
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 체스판 크기
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken()); // 출발지 행
		c1 = Integer.parseInt(st.nextToken()); // 출발지 열
		r2 = Integer.parseInt(st.nextToken()); // 도착지 행
		c2 = Integer.parseInt(st.nextToken()); // 도착지 열
		
		System.out.println(bfs());
	}
}