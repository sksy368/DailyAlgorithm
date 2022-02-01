package Graph.com.ssafy.Practice_0916;

import java.util.*;
import java.io.*;

public class Main_BJ_9205_맥주마시면서걸어가기 {
	
	static class Coordi {
		int row, column;
		public Coordi(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine()); // 편의점의 개수
			
			Coordi[] dist = new Coordi[n+2];
			boolean[][] map = new boolean[n+2][n+2];

			for(int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				dist[i] = new Coordi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			for(int i = 0; i < n+2; i++) {
				for(int j = 0; j < n+2; j++)
					map[i][j] = Math.abs(dist[i].row - dist[j].row) + Math.abs(dist[i].column - dist[j].column) > 1000 ? false : true;
			}
			
			for(int k = 0; k < n+2; k++) {
				for(int i = 0; i < n+2; i++) {
					for(int j = 0; j < n+2; j++) {
						map[i][j] = map[i][k] && map[k][j] ? true : map[i][j];
					}
				}
			}
			
			System.out.println(map[0][n+1] ? "happy" : "sad");
		}
	}
}