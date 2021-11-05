package November.week1;

import java.util.*;
import java.io.*;

public class Main_BJ_1743_음식물피하기 {
	
	static class Coordi {
		int row, column;
		public Coordi(int row, int column) {
			super();
			this.row = row;
			this.column = column;
		}
	}
	
	static int N, M, K, max;
	static int[][] map;
	static boolean[][] checked;
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	public static void bfs(int row, int column) {
		Queue<Coordi> queue = new LinkedList<>();
		int sum = 1;
		
		queue.offer(new Coordi(row, column));
		checked[row][column] = true;
		
		while(!queue.isEmpty()) {
			 Coordi cur = queue.poll();
			 
			 for(int d = 0; d < 4; d++) {
				 int r = cur.row + dr[d];
				 int c = cur.column + dc[d];
				 
				 if(r > 0 && r <= N && c > 0 && c <= M && !checked[r][c] && map[r][c] == 1) {
					 queue.offer(new Coordi(r, c));
					 checked[r][c] = true;
					 
					 sum++;
				 }
			 }
		}
		
		max = Math.max(sum, max);
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 통로의 세로 길이
		M = Integer.parseInt(st.nextToken()); // 통로의 가로 길이
		K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기의 개수
		
		map = new int[N+1][M+1];
		checked = new boolean[N+1][M+1];
		
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[r][c] = 1;
		}
		
		max = 0;
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				if(map[r][c] == 1 && !checked[r][c])
					bfs(r, c);
			}
		}
		
		System.out.println(max);
	}
}