package May_2022.week2;

import java.io.*;
import java.util.*;

class Main_Goorm_60331_빙글빙글1 {
	
	static String[][] answer;
	static int[] cur;
	static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int dIdx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		answer = new String[input][input];
		for(int i = 0; i < input; i++) {
			Arrays.fill(answer[i], "  ");
		}
		dIdx = 0;
		cur = new int[]{0, 0}; // 현재위치
		
		for(int i = input; i >= 3; i-=2){
			if(i == input) draw(i, 3); // i개, 3번, d방향부터
			else draw(i, 2);
		}
		
		for(int i = 0; i < input; i++){
			for(int j = 0; j < input; j++)
				System.out.print(answer[i][j]);
			System.out.println();
		}
	}
	
	public static void draw(int size, int cnt){
		
		for(int i = 0; i < cnt; i++){
			answer[cur[0]][cur[1]] = "# ";
			
			for(int j = 0; j < size-1; j++){
				
				cur[0] += D[dIdx][0];
				cur[1] += D[dIdx][1];
				
				answer[cur[0]][cur[1]] = "# ";
			}
			
			dIdx = (dIdx+1) % 4;
		}
	}
}