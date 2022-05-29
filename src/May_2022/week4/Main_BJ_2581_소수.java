package May_2022.week4;

import java.io.*;

public class Main_BJ_2581_소수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0; // 소수의 합
		int min = Integer.MAX_VALUE; // 최솟값
		
		for(int i = M; i <= N; i++) {
			if(i == 1) continue;
			
			if(isPrimeNum(i)) {
				sum += i;
				min = Math.min(i, min);
			}
		}
		
		if(sum == 0) System.out.println(-1);
		else System.out.println(sum + "\n" + min);
	}
	
	public static boolean isPrimeNum(int num) {
		for(int i = 2; i < num; i++) {
			if(num % i == 0) return false;
		}
		
		return true;
	}
}
