package Algorithm.Graph.Practice_0916;

import java.util.*;
import java.io.*;

public class Solution_SWEA_1263_사람네트워크2_FloydWarshall {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 사람 수
			int[][] network = new int[N+1][N+1];
			int minCC = Integer.MAX_VALUE;
			
			for(int i = 1; i <= N; i++){
				for(int j = 1; j <= N; j++){
					network[i][j] = Integer.parseInt(st.nextToken());
					
					if(i != j && network[i][j] == 0)
						network[i][j] = 1001;
				}
			}
			
			
			for(int k = 1; k <= N; k++) {
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= N; j++)
						network[i][j] = Math.min(network[i][k] + network[k][j], network[i][j]);
				}
			}
			
			
			for(int i = 1; i <= N; i++){
				int sum = 0;
				
				for(int j = 1; j <= N; j++) {
					if(i != j) sum += network[i][j];
				}
				
				minCC = Math.min(sum, minCC);
			}
			
			System.out.println("#" + t + " " + minCC);
		}
	}
}