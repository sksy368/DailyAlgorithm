package November.week4;

import java.io.*;
import java.util.*;

public class Main_BJ_2502_떡먹는호랑이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.parseInt(st.nextToken()); // 할머니가 넘어온 날
		int K = Integer.parseInt(st.nextToken()); // 그 날 호랑이에게 준 떡의 개수
		
		int[] A = new int[D+1]; // 첫 날에 준 떡의 개수의 계수
		int[] B = new int[D+1]; // 둘째 날에 준 떡의 개수의 계수
		
		A[1] = 1;
		A[2] = 0;
		B[1] = 0;
		B[2] = 1;
		
		for(int i = 3; i <= D; i++) {
			A[i] = A[i-1] + A[i-2];
			B[i] = B[i-1] + B[i-2];
		}
		
		int a = 1; // 첫 날에 준 떡의 개수
		int b = 0; // 둘째 날에 준 떡의 개수
		
		while(true) {
			if((K - A[D] * a) % B[D] == 0) {
				b = (K - A[D] * a) / B[D];
				break;
			}
			a++;
		}
		
		System.out.println(a);
		System.out.println(b);
	}
}