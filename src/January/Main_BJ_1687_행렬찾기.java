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
		
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if((N-n)*(M-m) <= max)
					break;
				if(arr[n][m] == 0)
					findLength(n, m);
			}
		}
		
		System.out.println(max);
	}
	
	public static void findLength(int startR, int startC) {
		int rowLength = 0;
		int columnLength = 0;
		
		for(int r = startR; r < N; r++) {
			if(arr[r][startC] == 0) rowLength++;
			else break;
		}
		
		for(int c = startC; c < M; c++) {
			if(arr[startR][c] == 0) columnLength++;
			else break;
		}
		
		if(rowLength*columnLength <= max*max) return;
		
		checkRow(startR, startC+1, startC+1, rowLength);
		
		int rowLength = 0;
		for(int r = startR; r < startR+columnLength; r++) {
			if(arr[r][nowC] == 0) rowLength++;
			else break;
		}
		
		
		checkColumn(startR+1, startC, startR+1, columnLength);
	}
	
	public static void checkRow(int startR, int startC, int nowC, int minRowLength) {
		if(nowC >= M) {
			max = Math.max(M-1 * minRowLength, max);
			return;
		}
		
		int rowLength = 0;
		
		for(int r = startR; r < startR+minRowLength; r++) {
			if(arr[r][nowC] == 0) rowLength++;
			else break;
		}
		
		System.out.println("현재 : " + startR + "," + nowC + " --> max : " + max); //////////
		
		if(rowLength == 0) {
			max = Math.max((nowC-startC)*minRowLength, max);
			return;
		}
		else
			checkRow(startR, startC, startC+1, Math.min(rowLength, minRowLength));
	}
	
	public static void checkColumn(int startR, int startC, int nowR, int minColumnLength) {
		if(nowR >= N) {
			max = Math.max(N-1 * minColumnLength, max);
			return;
		}
		
		int columnLength = 0;
		
		for(int c = startC; c < startR+minColumnLength; c++) {
			if(arr[nowR][c] == 0) columnLength++;
			else break;
		}
		
		if(columnLength == 0) {
			max = Math.max((nowR-startR)*minColumnLength, max);
			return;
		}
		else
			checkColumn(startR, startC, startR+1, Math.min(columnLength, minColumnLength));
	}
}
