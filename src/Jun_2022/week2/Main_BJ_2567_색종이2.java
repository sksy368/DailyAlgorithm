package Jun_2022.week2;

import java.io.*;
import java.util.*;

public class Main_BJ_2567_색종이2 {
	
	static int[][] D = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 색종이의 수
		boolean[][] paper = new boolean[100][100];
		int cnt = 0;
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int row = Integer.parseInt(st.nextToken());
			int column = Integer.parseInt(st.nextToken());
			
			for(int r = 0; r < 10; r++) {
				for(int c = 0; c < 10; c++)
					paper[row+r][column+c] = true;
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(!paper[i][j]) continue;
				
				for(int d = 0; d < 4; d++) {
					int nextR = i + D[d][0];
					int nextC = j + D[d][1];
					if(nextR<0 || nextR>=100 || nextC<0 || nextC>=100 || !paper[nextR][nextC]) cnt++; // 인접한 면이 빈 공간인 경우
				}
			}
		}
		
		System.out.println(cnt);
	}
}