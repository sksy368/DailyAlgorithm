package Algorithm.Implemention.Practice_0820;

import java.util.*;
import java.io.*;

public class Main_BJ_15683_감시 {
	
	static int N, M;
	static int[][] office;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] type = {{}, {3}, {2, 3}, {0, 3}, {0, 2, 3}, {0, 1, 2, 3}};
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine()); // 사무실의 세로 크기
		M = Integer.parseInt(br.readLine()); // 사무실의 가로 크기
		office = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				office[i][j] = Integer.parseInt(st.nextToken()); // 0:빈칸, 1~5:CCTV, 6:벽
		}
	}
}