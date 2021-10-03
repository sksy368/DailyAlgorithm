package Graph.com.ssafy.Practice_0924;

import java.util.*;
import java.io.*;

public class Main_BJ_7576_토마토 {
	
	static class Tomato {
		int row, column, time;
		Tomato(int row, int column, int time){
			this.row = row;
			this.column = column;
			this.time = time;
		}
	}
	
	static int M, N, unripe, time;
	static int[][] box;
	static boolean[][] checked;
	static Queue<Tomato> queue;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Tomato cur = queue.poll();
			time = Math.max(cur.time, time);
			
			for(int d = 0; d < 4; d++) {
				int r = cur.row + dr[d];
				int c = cur.column + dc[d];
				
				if(r >= 0 && r < N && c >= 0 && c < M && !checked[r][c] && box[r][c] == 0) {
					queue.offer(new Tomato(r, c, cur.time+1));
					checked[r][c] = true;
					box[r][c] = 1;
					unripe--;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 상자의 가로 크기
		N = Integer.parseInt(st.nextToken()); // 상자의 세로 크기
		box = new int[N][M];
		checked = new boolean[N][M];
		queue = new LinkedList<>();
		unripe = 0; // 익지 않은 토마토 개수
		time = 0;
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				box[n][m] = Integer.parseInt(st.nextToken()); // 1:익은 토마토, 0:익지 않은 토마토, -1:토마토가 없음
				
				if(box[n][m] == 1) queue.offer(new Tomato(n, m, 0));
				else if(box[n][m] == 0) unripe++;
			}
		}
		
		bfs();
		
		if(unripe == 0) System.out.println(time);
		else System.out.println(-1);
	}
}