package Oct_2021.week4;

import java.util.*;
import java.io.*;

public class Main_BJ_10942_팰린드롬 {
	
	static int N;
	static int[] nums;
	static boolean[][] D;
	
	static void Palindrome() {
		for(int i = 1; i <= N; i++) // 길이가 1인 경우 (대각선)
			D[i][i] = true;
		
		for(int i = 1; i < N; i++) {
			if(nums[i] == nums[i+1]) // 길이가 2인 경우
				D[i][i+1] = true;
		}
		
		// 길이가 3 이상인 경우
		for(int i = 2; i < N; i++) {
			for(int j = 1; j <= N-i; j++) {
				if(nums[j] == nums[j+i] && D[j+1][j+i-1]) // start값 == end값 && D[start-1][end-1](start-1부터 end-1까지 팰린드롬인 경우)
					D[j][j+i] = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 자연수 개수
		nums = new int[N+1];
		D = new boolean[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		Palindrome();
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine()); // 질문 개수
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(D[start][end])
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		
		System.out.println(sb);
	}
}