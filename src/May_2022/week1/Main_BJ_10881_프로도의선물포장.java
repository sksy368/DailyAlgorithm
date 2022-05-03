package May_2022.week1;

import java.util.*;
import java.io.*;

public class Main_BJ_10881_프로도의선물포장 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int[][] papers = new int[3][2];
			int min = Integer.MAX_VALUE;
			
			for(int n = 0; n < 3; n++) {
				st = new StringTokenizer(br.readLine());
				papers[n][0] = Integer.parseInt(st.nextToken());
				papers[n][1] = Integer.parseInt(st.nextToken());
			}
			
			int maxH = 0;
			int sumW = 0;
			for(int n = 0; n < 3; n++) { // ㅁㅁㅁ -> 가로:최소값들의 합, 세로:최대값(maxH)
				maxH = Math.max(maxH, Math.max(papers[n][0], papers[n][1]));
				sumW += Math.min(papers[n][0], papers[n][1]);
			}
			min = Math.min(min, maxH*sumW);
			
			int height = 0;
			int weight = 0;
			
			
			for(int n1 = 0; n1 < 3; n1++) {
				height = papers[n1][0];
				weight = papers[n1][1];
				maxH = 0;
				sumW = 0;
				
				for(int n2 = 0; n2 < 2; n2++) {
					if(n1 == n2) continue;
					maxH = Math.max(maxH, Math.max(papers[n2][0], papers[n2][1]));
					sumW += Math.min(papers[n2][0], papers[n2][1]);
				}
				
				height = Math.max(height, sumW);
				weight += maxH;
				
				min = Math.min(min, height*weight);
			}
			
			System.out.println(min);
		}
	}
}
