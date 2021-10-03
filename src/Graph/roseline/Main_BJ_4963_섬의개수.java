package Graph.roseline;

import java.util.*;
import java.io.*;

public class Main_BJ_4963_섬의개수 {
	
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	
	static int w, h, cnt;
	static int[][] map;
	static boolean[][] visited;
	
	
	static void bfs(int row, int column) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {row, column});
		
		visited[row][column] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int d = 0; d < 8; d++) {
				int r = cur[0] + dr[d];
				int c = cur[1] + dc[d];
				
				if(r >= 0 && r < h && c >= 0 && c < w && !visited[r][c] && map[row][column] == map[r][c]) {
					queue.offer(new int[] {r, c});
					visited[r][c] = true;
				}
			}
		}
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken()); // 지도의 너비
			h = Integer.parseInt(st.nextToken()); // 지도의 높이
			
			if(w == 0 && h == 0) break; // 종료
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++)
					map[i][j] = Integer.parseInt(st.nextToken()); // 1:땅, 0:바다
			}
			
			cnt = 0;
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(!visited[i][j]) {
						if(map[i][j] == 1) cnt++; // 땅인 경우
						bfs(i, j);
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
}