package December.week1;

import java.util.*;
import java.io.*;

public class Main_BJ_1451_직사각형으로나누기 {
	
	static int N, M;
	static long max;
	static char[][] num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 직사각형의 세로 크기
		M = Integer.parseInt(st.nextToken()); // 직사각형의 가로 크기
		
		num = new char[N][M];
		
		for(int n = 0; n < N; n++)
			num[n] = br.readLine().toCharArray();
		
		max = 0;
		
		// 1번 case
		for(int b1 = 1; b1 < M-1; b1++) {
			for(int b2 = b1+1; b2 < M; b2++) {
				long one = sum(0, N, 0, b1);
				long two = sum(0, N, b1, b2);
				long three = sum(0, N, b2, M);
				
				max = Math.max(max, one*two*three);
			}
		}
		
		// 2번 case
		for(int b1 = 1; b1 < N-1; b1++) {
			for(int b2 = b1+1; b2 < N; b2++) {
				long one = sum(0, b1, 0, M);
				long two = sum(b1, b2, 0, M);
				long three = sum(b2, N, 0, M);
				
				max = Math.max(max, one*two*three);
			}
		}
		
		// 3번 case
		for(int b1 = 1; b1 < M; b1++) {
			for(int b2 = 1; b2 < N; b2++) {
				long one = sum(0, N, 0, b1);
				long two = sum(0, b2, b1, M);
				long three = sum(b2, N, b1, M);
				
				max = Math.max(max, one*two*three);
			}
		}
		
		// 4번 case
		for(int b1 = 1; b1 < N; b1++) {
			for(int b2 = 1; b2 < M; b2++) {
				long one = sum(0, b1, 0, b2);
				long two = sum(b1, N, 0, b2);
				long three = sum(0, N, b2, M);
				
				max = Math.max(max, one*two*three);
			}
		}
		
		// 5번 case
		for(int b1 = 1; b1 < N; b1++) {
			for(int b2 = 1; b2 < M; b2++) {
				long one = sum(0, b1, 0, M);
				long two = sum(b1, N, 0, b2);
				long three = sum(b1, N, b2, M);
				
				max = Math.max(max, one*two*three);
			}
		}
		
		// 6번 case
		for(int b1 = 1; b1 < M; b1++) {
			for(int b2 = 1; b2 < N; b2++) {
				long one = sum(0, b2, 0, b1);
				long two = sum(0, b2, b1, M);
				long three = sum(b2, N, 0, M);
				
				max = Math.max(max, one*two*three);
			}
		}
		
		System.out.println(max);
	}
	
	static long sum(int startR, int endR, int startC, int endC) { // startR <= 행 < endR, startC <= 열 < endC
		long sum = 0;
		
		for(int i = startR; i < endR; i++) {
			for(int j = startC; j < endC; j++)
				sum += num[i][j] - '0';
		}
		
		return sum;
	}
}