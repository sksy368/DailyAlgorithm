package Graph.com.ssafy.Practice_0930;

import java.util.*;
import java.io.*;

public class Solution_SWEA_1953_탈주범검거 {
	
	static class Tunnel{
		int r, c, time;
		public Tunnel(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	static int N, M, R, C, L, answer;
	static int[][] map;
	static boolean[][] visited;
	
	static int[][] type = {{}, {0, 1, 2, 3}, {0, 1}, {2, 3}, {0, 3}, {1, 3}, {1, 2}, {0, 2}}; // 터널 구조물 타입마다 갈 수 있는 방향
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static boolean isConnect(int t, int r, int c) {
		if(t == 0 && (map[r][c] == 1 || map[r][c] == 2 || map[r][c] == 5 || map[r][c] == 6)) return true;
		else if(t == 1 && (map[r][c] == 1 || map[r][c] == 2 || map[r][c] == 4 || map[r][c] == 7)) return true;
		else if(t == 2 && (map[r][c] == 1 || map[r][c] == 3 || map[r][c] == 4 || map[r][c] == 5)) return true;
		else if(t == 3 && (map[r][c] == 1 || map[r][c] == 3 || map[r][c] == 6 || map[r][c] == 7)) return true;
		return false;
	}
	
	public static void bfs() {
		Queue<Tunnel> queue = new LinkedList<>();
		visited = new boolean[N][M];
		
		queue.offer(new Tunnel(R, C, 1));
		visited[R][C] = true;
		answer = 1;
		
		while(!queue.isEmpty()) {
			Tunnel cur = queue.poll();
			
			if(cur.time == L) continue; // 시간 종료
			
			int[] curType = type[map[cur.r][cur.c]]; // 타입 별 갈 수 있는 방향
			
			for(int d = 0; d < curType.length; d++) {
				int r = cur.r + dr[curType[d]];
				int c = cur.c + dc[curType[d]];
				
				if(r >= 0 && r < N && c >= 0 && c < M && map[r][c] != 0 && !visited[r][c] && isConnect(curType[d], r, c)) {
					queue.add(new Tunnel(r, c, cur.time+1));
					visited[r][c] = true;
					answer++;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지하 터널 세로 크기
			M = Integer.parseInt(st.nextToken()); // 지하 터널 가로 크기
			R = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑이 위치한 세로 위치
			C = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑이 위치한 가로 위치
			L = Integer.parseInt(st.nextToken()); // 탈출 후 소요한 시간
			
			map = new int[N][M]; 
			
			for(int n = 0; n < N; n++) {
				st =  new StringTokenizer(br.readLine());
				for(int m = 0; m < M; m++)
					map[n][m] = Integer.parseInt(st.nextToken()); // 0:터널X, 1~7:터널 구조물 타입
			}

			bfs();
			
			System.out.println("#" + t + " " + answer);
		}
	}
}
