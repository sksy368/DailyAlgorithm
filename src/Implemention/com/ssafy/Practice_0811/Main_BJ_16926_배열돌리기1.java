package Implemention.com.ssafy.Practice_0811;

import java.util.*;
import java.io.*;

public class Main_BJ_16926_배열돌리기1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
				
		}
		
		int count = Math.min(N, M) / 2; // 회전하는 라인 개수
		for(int r = 0; r < R; r++) {
			for(int i = 0; i < count; i++) {
				int temp = arr[i][i];
				
				for(int j = i+1; j < M-i; j++)	arr[i][j-1] = arr[i][j];
				for(int j = i+1; j < N-i; j++)	arr[j-1][M-1-i] = arr[j][M-1-i];
				for(int j = M-2-i; j >= i; j--)	arr[N-1-i][j+1] = arr[N-1-i][j];
				for(int j = N-2-i; j >= i; j--)	arr[j+1][i] = arr[j][i];
				arr[i+1][i] = temp;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
}