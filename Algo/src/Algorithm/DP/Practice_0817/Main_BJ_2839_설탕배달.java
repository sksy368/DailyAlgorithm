package Algorithm.DP.Practice_0817;

import java.util.*;
import java.io.*;

public class Main_BJ_2839_설탕배달 {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] D = new int[N+1];
		D[0] = D[1] = D[2] = Integer.MAX_VALUE;
		
		if(N >= 3) D[3] = 1;
		if(N >= 4) D[4] = Integer.MAX_VALUE;
		if(N >= 5) D[5] = 1;
		
		for(int i = 6; i < N+1; i++) {
			if(D[i-5] == Integer.MAX_VALUE && D[i-3] == Integer.MAX_VALUE)
				D[i] = Integer.MAX_VALUE;
			else if(D[i-5] == Integer.MAX_VALUE)
				D[i] = D[i-3] + 1;
			else if(D[i-3] == Integer.MAX_VALUE)
				D[i] = D[i-5] + 1;
			else
				D[i] = Math.min(D[i-5]+1, D[i-3]+1);
		}
		
		System.out.println(D[N] == Integer.MAX_VALUE ? -1 : D[N]);
	}
}