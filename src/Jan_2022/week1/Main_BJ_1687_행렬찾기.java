package Jan_2022.week1;

import java.util.*;
import java.io.*;

public class Main_BJ_1687_행렬찾기 {
	
	static int N, M, max;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 행렬의 세로 길이
		M = Integer.parseInt(st.nextToken()); // 행렬의 가로 길이
		
		arr = new int[N][M];
		max = 1;
		
		for(int n = 1;  n <= N; n++) {
			String s = br.readLine();
			
			for(int m = 1; m <= M; m++) arr[n][m] = Integer.parseInt(s.charAt(m)+"");
		}
		
		int[][] D = new int[N+1][M+1];
		
		
	}
}
