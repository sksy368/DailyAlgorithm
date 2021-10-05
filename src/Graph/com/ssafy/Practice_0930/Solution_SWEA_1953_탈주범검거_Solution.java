package Graph.com.ssafy.Practice_0930;

import java.util.*;
import java.io.*;

public class Solution_SWEA_1953_탈주범검거_Solution {
	private static String[] type = {
			null,
			"0312", // 1:상하좌우
			"03", // 2:상하
			"12", // 3:좌우
			"02", // 4:상우
			"32", // 5:하우
			"31", // 6:하좌
			"01", // 7:상좌
	};
	
	private static int[] dr = {-1, 0, 0, 1}; // 상 좌 우 하
	private static int[] dc = {0, -1, 1, 0}; // 상 좌 우 하
	private static int N, M, R, C, L;
	private static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j< N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println("#" + t + " " + bfs());
		}
	}
	
	private static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		int result = 0, time = 1;
		
		queue.offer(new int[] {R, C});
		visited[R][C] = true;
		result++;
		
		int r, c, nr, nc, size, current[], dir;
		String info = null;
		while(time++ < L) {
			size = queue.size();
			while(size-- > 0) {
				current = queue.poll();
				r = current[0];
				c = current[1];
				info = type[map[r][c]];
				
				for(int d = 0, length = info.length(); d < length; d++) {
					dir = info.charAt(d) - '0'; // 구조물의 방향
					nr = r + dr[dir];
					nc = c + dr[dir];
					
					if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0
							&& type[map[nr][nc]].contains(Integer.toString(3-d))
							&& !visited[nr][nc]) {
						queue.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
						result++;
					}
				}
			}
		}
		
		return result;
	}
}
