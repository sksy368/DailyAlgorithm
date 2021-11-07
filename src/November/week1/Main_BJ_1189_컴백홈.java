package November.week1;

import java.util.*;
import java.io.*;

public class Main_BJ_1189_컴백홈 {
	
	static int R, C, K, cnt;
	static char[][] map;
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	public static void dfs(int row, int column, boolean[][] visited, int dist) {
		if(dist == K && row == 0 && column == C-1) {
			cnt++;
			
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int r = row + dr[d];
			int c = column + dc[d];
			
			if(r >= 0 && r < R && c >= 0 && c < C && !visited[r][c] && map[r][c] =='.') {
				visited[r][c] = true;
				dfs(r, c, visited, dist+1);
				visited[r][c] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 맵의 세로 길이
		C = Integer.parseInt(st.nextToken()); // 맵의 가로 길이
		K = Integer.parseInt(st.nextToken()); // 거리
		
		map = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		
		for(int r = 0; r < R; r++)
			map[r] = br.readLine().toCharArray();
		
		
		cnt = 0;
		visited[R-1][0] = true;
		dfs(R-1, 0, visited, 1);
		
		System.out.println(cnt);
	}
}