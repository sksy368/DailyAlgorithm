package Mar_2022.week3;

import java.util.*;
import java.io.*;

public class Main_BJ_2583_영역구하기 {
	
	static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int M, N, K, area;
	static boolean[][] paper;
	static ArrayList<Integer> areas;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 모눈종이의 세로 길이
		N = Integer.parseInt(st.nextToken()); // 모눈종이의 가로 길이
		K = Integer.parseInt(st.nextToken()); // 직사각형의 개수
		areas = new ArrayList<>(); // 분리되어 나누어지는 영역의 넓이
		
		paper = new boolean[M][N];
		
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()); // 왼쪽 꼭짓점의 x좌표
			int y1 = Integer.parseInt(st.nextToken()); // 왼쪽 꼭짓점의 y좌표
			int x2 = Integer.parseInt(st.nextToken()); // 오른쪽 꼭짓점의 x좌표
			int y2 = Integer.parseInt(st.nextToken()); // 오른쪽 꼭짓점의 y좌표
			
			for(int y = y1; y < y2; y++) {
				for(int x = x1; x < x2; x++) paper[y][x] = true; // 칠한 부분은 true
			}
		}
		
		for(int m = 0; m < M; m++) {
			for(int n = 0; n < N; n++) {
				if(!paper[m][n]) {
					area = 1; // 특정 영역의 넓이 초기화
					dfs(m, n);
					areas.add(area); // 특정 영역의 넓이 추가
				}
			}
		}
		
		Object[] answer = areas.toArray();
		Arrays.sort(answer);
		System.out.println(answer.length);
		for(int i = 0; i < answer.length; i++) System.out.print(answer[i] + " ");
	}
	
	
	public static void dfs(int y, int x) {
		paper[y][x] = true;
		
		for(int d = 0; d < 4; d++) {
			int nextY = y + D[d][0];
			int nextX = x + D[d][1];
			
			if(nextY<0 || nextY>=M || nextX<0 || nextX>=N || paper[nextY][nextX]) continue;
			
			dfs(nextY, nextX);
			area++; // 영역의 넓이 갱신
		}
	}
}
