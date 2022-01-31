package January;

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
		
		for(int n = 0;  n < N; n++) {
			String s = br.readLine();
			
			for(int m = 0; m < M; m++) arr[n][m] = Integer.parseInt(s.charAt(m)+"");
		}
		
		divide(0, 0, N, M);
		
		System.out.println(max);
	}
	
	public static void divide(int startR, int startC, int sizeR, int sizeC) {
		int newSizeR = sizeR/2;
		int newSizeC = sizeC/2;
		
		boolean one = allZero(startR, startC, newSizeR, newSizeC);
		boolean two = allZero(startR, startC+newSizeC, (newSizeR+1)/2, (newSizeC+1)/2);
		boolean three = allZero(startR+newSizeR, startC, (newSizeR+1)/2, (newSizeC+1)/2);
		boolean four = allZero(startR+newSizeR, startC+newSizeC, (newSizeR+1)/2, (newSizeC+1)/2);
		
		
	}
	
	public static boolean allZero(int startR, int startC, int sizeR, int sizeC) {
		
		for(int i = startR; i < startR+sizeR; i++) {
			for(int j = startC; j < startC+sizeC; j++) {
				if(arr[i][j] != 0) return false;
			}
		}
		
		return true;
	}
}
