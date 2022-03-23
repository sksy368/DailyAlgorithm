package Dec_2021.week3;

import java.util.*;
import java.io.*;

public class Main_BJ_5549_행성탐사 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken()); // 지도의 세로 크기
		int N = Integer.parseInt(st.nextToken()); // 지도의 가로 크기
		int K = Integer.parseInt(br.readLine()); // 조사 대상 영역의 개수
		
		char[][] map = new char[M+1][N+1];
		int[][] countJ = new int[M+1][N+1];
		int[][] countO = new int[M+1][N+1];
		int[][] countI = new int[M+1][N+1];
		
		for(int m = 1; m <= M; m++) {
			String s = br.readLine(); // J:정글, O:바다, I:얼음
			for(int n = 1; n <= s.length(); n++) {
				map[m][n] = s.charAt(n-1);
				
				countJ[m][n] = countJ[m-1][n] + countJ[m][n-1] - countJ[m-1][n-1];
				countO[m][n] = countO[m-1][n] + countO[m][n-1] - countO[m-1][n-1];
				countI[m][n] = countI[m-1][n] + countI[m][n-1] - countI[m-1][n-1];
				
				if(map[m][n] == 'J') countJ[m][n]++;
				else if(map[m][n] == 'O') countO[m][n]++;
				else countI[m][n]++;
			}
		}
		
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int jNum = countJ[c][d] - countJ[c][b-1] - countJ[a-1][d] + countJ[a-1][b-1];
			int oNum = countO[c][d] - countO[c][b-1] - countO[a-1][d] + countO[a-1][b-1];
			int iNum = countI[c][d] - countI[c][b-1] - countI[a-1][d] + countI[a-1][b-1];
			
			sb.append(jNum + " " + oNum + " " + iNum + "\n");
		}
		
		System.out.print(sb);
	}
}