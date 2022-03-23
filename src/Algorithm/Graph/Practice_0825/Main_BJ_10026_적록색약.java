package Algorithm.Graph.Practice_0825;

import java.util.*;
import java.io.*;

public class Main_BJ_10026_적록색약 {
	
	static int N, ans1, ans2;
	static char[][] grid;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void normal(int i, int j) { // 적록색약이 아닌 사람인 경우
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int r = cur[0] + dr[d];
				int c = cur[1] + dc[d];
				
				if(r >= 0 && r < N && c >= 0 && c < N && !visited[r][c] && grid[r][c] == grid[cur[0]][cur[1]]) {
					queue.offer(new int[] {r, c});
					visited[r][c] = true;
				}
			}
		}
	}
	
	public static void colorBlindness(int i, int j) { // 적록색약인 사람인 경우
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int r = cur[0] + dr[d];
				int c = cur[1] + dc[d];
				
				if(r >= 0 && r < N && c >= 0 && c < N && !visited[r][c] &&
						(grid[r][c] == grid[cur[0]][cur[1]] || Math.abs(grid[r][c] - grid[cur[0]][cur[1]]) == 11)) {
					queue.offer(new int[] {r, c});
					visited[r][c] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 그리드 크기
		grid = new char[N][N];

		for(int i = 0; i < N; i++)
			grid[i] = br.readLine().toCharArray();
		
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					normal(i, j);
					ans1++;
				}
			}
		}
		
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					colorBlindness(i, j);
					ans2++;
				}
			}
		}
		
		System.out.println(ans1 + " " + ans2);
	}
}
