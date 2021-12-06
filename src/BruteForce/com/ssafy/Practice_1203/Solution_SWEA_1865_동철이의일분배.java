package BruteForce.com.ssafy.Practice_1203;

import java.io.*;
import java.util.*;

public class Solution_SWEA_1865_동철이의일분배 {
	
	static int N;
	static int[][] prob;
	static boolean[] isSelected;
	static int[] result;
	static double max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			prob = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < N; j++)
					prob[i][j] = Integer.parseInt(st.nextToken());
			}
			
			isSelected = new boolean[N];
			max = 0;
			permutation(0, 1);
			
			System.out.printf("#%d %f\n", t, max*100);
		}
	}
	
	static void permutation(int cnt, double probability) {
		if(cnt == N) {
			max = Math.max(max, probability);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i] || prob[cnt][i] == 0 || probability <= max)
				// 1.이미 선택된 경우 2.확률이 0인 경우 3.max보다 작거나 같은 경우(앞으로 계속 작아지기 때문에 할 필요 없음)
				continue;
			
			isSelected[i] = true;
			
			permutation(cnt+1, probability * (prob[cnt][i]/100.0));
			
			isSelected[i] = false;
		}
	}
}
