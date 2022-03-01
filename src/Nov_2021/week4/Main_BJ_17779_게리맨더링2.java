package Nov_2021.week4;

import java.util.*;
import java.io.*;

public class Main_BJ_17779_게리맨더링2 {
	
	static int N, minDiff;
	static int[] sum;
	static int population[][];
	static boolean[][] isFive;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 재현시의 크기
		population = new int[N+1][N+1]; // 구역의 인구
		
		for(int n1 = 1; n1 <= N; n1++) {
			st = new StringTokenizer(br.readLine());
			for(int n2 = 1; n2 <= N; n2++)
				population[n1][n2] = Integer.parseInt(st.nextToken());
		}
		
		minDiff = Integer.MAX_VALUE; // 인구가 가장 많은 선거구와 가장 적은 선거구의 인구 차이의 최솟값
		
		for(int x = 1; x <= N-2; x++) {
			for(int y = 2; y <= N-1; y++) {
				for(int d1 = 1; d1 < y; d1++) {
					for(int d2 = 1; d2 <= N-y; d2++) {
						if(x+d1+d2<=N && y-d1>=1 && y+d2<=N)
							divide(x, y, d1, d2);
					}
				}
			}
		}

		System.out.println(minDiff);
	}
	
	static void divide(int x, int y, int d1, int d2) {
		sum = new int[6];
		isFive = new boolean[N+1][N+1];
		
		int start = 0, end = 0; // start ~ end : 5번 선거구의 열
		
		// 5번 선거구 인구 구하기
		for(int i = 0; i <= d1+d2; i++) { // i : x와의 차 (5번 선거구의 행)
			for(int j = start; j <= end; j++) {
				sum[5] += population[x+i][y+j];
				isFive[x+i][y+j] = true;
			}
			
			// 5번 선거구의 열 값 조정
			if(i < d1) start--;
			else start++;
			if(i < d2) end++;
			else end--;
		}
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++) {
				if(isFive[r][c]) continue; // 5번 선거구인 경우
				
				if(r<x+d1 && c<=y) sum[1] += population[r][c]; // 1번 선거구인 경우
				else if(r<=x+d2 && y<c) sum[2] += population[r][c]; // 2번 선거구인 경우
				else if(x+d1<=r && c<y-d1+d2) sum[3] += population[r][c]; // 3번 선거구인 경우
				else if(x+d2<r && y-d1+d2<=c) sum[4] += population[r][c]; // 4번 선거구인 경우
			}
		}
		
		int min = Integer.MAX_VALUE;
		int max = 0;
		
		for(int i = 1; i <= 5; i++) {
			if(min > sum[i]) min = sum[i];
			if(max < sum[i]) max = sum[i];
		}
	
		minDiff = Math.min(minDiff, max-min);
	}
}