package Nov_2021.week4;

import java.util.*;
import java.io.*;

public class Main_BJ_2512_예산 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 지방의 수
		int[] budget = new int[N]; // 지방 별 요청 예산
		int budgetSum = 0; // 요청 예산 총 합
		int M; // 총 예산
		int budgetMin; // 상한값을 조정할 때의 최소값
		int budgetMax = 0; // 상한값을 조정할 때의 최대값
		int upperLimit = 0; // 상한값
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			budget[n] = Integer.parseInt(st.nextToken()); // 지방 별 요청 예산
			budgetSum += budget[n];
			budgetMax = Math.max(budgetMax, budget[n]);
		}
		
		M = Integer.parseInt(br.readLine());
		budgetMin = M / N;
		
		if(budgetSum <= M) // 모든 요청이 배정될 수 있는 경우
			answer= budgetMax;
		else { // 모든 요청이 배정될 수 없는 경우 
			answer = budgetMin;
			
			while(budgetMin + 1 < budgetMax) {
				upperLimit = (budgetMin + budgetMax) / 2; // 상한값 조정
				
				int sum = 0;
				for(int n = 0; n < N; n++)
					sum += budget[n] > upperLimit ? sum += upperLimit : budget[n];
				
				if(sum == M) { // 해당 상한값으로 계산했을 때 총 예산인 경우
					answer = upperLimit;
					break;
				}
				else if(sum < M) { // 해당 상한값으로 계산했을 때 총 예산을 넘지 않는 경우
					budgetMin = upperLimit;
					answer = upperLimit;
				}
				else // 해당 상한값으로 계산했을 때 총 예산을 넘는 경우
					budgetMax = upperLimit;
			}
		}
		
		System.out.println(answer);
	}
}
