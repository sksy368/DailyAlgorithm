package Mar_2022.week2;

import java.util.*;
import java.io.*;

public class Recruitment_2022_SKICTFamily_3 {
	
	static int width, height, answer, minCnt;
	static int[][] diagonals = new int[][] {{1, 1}, {2, 2}};;
	
	static int[][] D = {{0, 1}, {1, 0}, {-1, 1}, {1, -1}}; // 우, 상, 오른쪽아래, 왼쪽위

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		width = Integer.parseInt(st.nextToken()); // 격자의 가로 길이
		height = Integer.parseInt(st.nextToken()); // 격자의 세로 길이
		minCnt = Integer.MAX_VALUE;
		answer = 0; // 최단 경로의 개수 (10,000,019로 나눈 나머지) 
		
		dfs(0, 0, 0, false);
		
		System.out.println(answer);
	}
	
	public static void dfs(int row, int column, int cnt, boolean used) {
		
		if(row==height && column==width) {
			if(used && minCnt > cnt) {
				minCnt = cnt;
				answer = 0;
			}
			else if(used && minCnt == cnt) answer++;
			
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			if (d == 2 || d == 3) {
				if(used) break;
				else if(possible(row, column, d)) used = true;
				else break;
			}
			
			int nextR = row + D[d][0];
			int nextC = column + D[d][1];
			
			if(nextR<0 || nextR>height || nextC<0 || nextC>width) continue;
			
			dfs(nextR, nextC, cnt+1, used);
		}
	}
	
	public static boolean possible(int row, int column, int d) {
		for(int i = 0; i < diagonals.length; i++) {
			if(d == 2 && column == diagonals[i][0]-1 && row == diagonals[i][1]) return true;
			else if(d == 3 && column == diagonals[i][0] && row == diagonals[i][1]-1) return true;
		}
		
		return false;
	}
}