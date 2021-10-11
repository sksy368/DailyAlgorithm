package September.week3;

import java.util.*;
import java.io.*;

public class Main_BJ_1389_케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 유저의 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
		int[][] user = new int[N+1][N+1];
		
		for(int i = 0; i < N+1; i++) { // 초기화
			for(int j = 0; j < N+1; j++) {
				if(i == j) user[i][j] = 0;
				else user[i][j] = 100;
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int user1 = Integer.parseInt(st.nextToken());
			int user2 = Integer.parseInt(st.nextToken());
			
			user[user1][user2] = user[user2][user1] = 1;
		}
		
		for(int k = 1; k < N+1; k++) {
			for(int i = 1; i < N+1; i++) {
				for(int j = 1; j < N+1; j++) {
					user[i][j] = Math.min(user[i][j], user[i][k]+user[k][j]);
				}
			}
		}
		
		int[] cnt = new int[N+1]; // 케빈 베이컨 단계 카운트
		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++)
				cnt[i] += user[i][j];
			
			if(min > cnt[i]) {
				min = cnt[i];
				minIdx = i;
			}
		}
		
		System.out.println(minIdx);
	}
}
