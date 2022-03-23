package Algorithm.DP.Practice_0916;

import java.util.*;
import java.io.*;

public class Solution_SWEA_3307_최장증가부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] LIP = new int[N];
			int max = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++)
				arr[n] = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < N; i++) {
				LIP[i] = 1;
				for(int j = 0; j < i; j++) {
					if(arr[i] > arr[j] && LIP[i] < LIP[j] + 1)
						LIP[i] = LIP[j] + 1;
				}
				
				max = Math.max(LIP[i], max);
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
}