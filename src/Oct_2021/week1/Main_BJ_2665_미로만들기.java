package October.week1;

import java.io.*;
import java.util.*;

public class Main_BJ_2665_미로만들기 {
	
	static class Coordi {
		int row, column;
		public Coordi(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}
	
	static int n;
	static char[][] map;
	static int[][] breakCnt;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	public static void bfs() {
		Queue<Coordi> queue = new LinkedList<>();
		queue.offer(new Coordi(0, 0));
		breakCnt[0][0] = 0;
		
		while(!queue.isEmpty()) {
			Coordi cur = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int r = cur.row + dr[d];
				int c = cur.column + dc[d];
				
				if(r >= 0 && r < n && c >= 0 && c < n && breakCnt[r][c] > breakCnt[cur.row][cur.column]) {
					queue.offer(new Coordi(r, c));
					if(map[r][c] == '0')
						breakCnt[r][c] = breakCnt[cur.row][cur.column] + 1;
					else
						breakCnt[r][c] = breakCnt[cur.row][cur.column];
				}
			}
		}
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		breakCnt = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray(); // 0:검은 방, 1:흰 방
			Arrays.fill(breakCnt[i], Integer.MAX_VALUE);
		}
		
		bfs();
		
		System.out.println(breakCnt[n-1][n-1]);
	}
}