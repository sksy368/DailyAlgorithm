package December.week4;

import java.io.*;
import java.util.*;

public class Main_BJ_21610_마법사상어와비바라기 {
	
	static class Cloud {
		int row, column;
		Cloud(int row, int column){
			this.row = row;
			this.column = column;
		}
	}
	
	static int N, M;
	static int[][] map;
	static Queue<Cloud> clouds;
	
	static int[][] d = {{0, 0}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
	static int[] crossIdx = {2, 4, 6, 8}; // d의 대각선으로 이동하는 인덱스
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 격자 크기
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1]; // 각 격자에 위치한 바구니에 담긴 물의 양
		clouds = new LinkedList<>();
		
		for(int n1 = 1; n1 <= N; n1++) {
			st = new StringTokenizer(br.readLine());
			
			for(int n2 = 1; n2 <= N; n2++)
				map[n1][n2] = Integer.parseInt(st.nextToken());
		}
		
		// 비바라기 시전하여 비구름 생성
		clouds.add(new Cloud(N, 1));
		clouds.add(new Cloud(N, 2));
		clouds.add(new Cloud(N-1, 1));
		clouds.add(new Cloud(N-1, 2));
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
					
			int direction = Integer.parseInt(st.nextToken()); // 이동 방향
			int space = Integer.parseInt(st.nextToken()); // 이동 거리
			
			move(direction, space);
		}
		
		int sum = 0;
		for(int n1 = 1; n1 <= N; n1++) {
			for(int n2 = 1; n2 <= N; n2++)
				sum += map[n1][n2];
		}
		System.out.println(sum);
	}
	
	public static void move(int direction, int space) {
		boolean[][] isCloud = new boolean[N+1][N+1];
		Queue<Cloud> copyClouds = new LinkedList<>();
				
		while(clouds.size() != 0) {
			Cloud c = clouds.poll();
			int moveR = location(c.row, d[direction][0], space) ; // 이동한 후 위치(행)
			int moveC = location(c.column, d[direction][1], space); // 이동한 후 위치(열)
			
			isCloud[moveR][moveC] = true; // 구름의 이동한 위치 표시
			map[moveR][moveC]++; // 구름에서 비가 내려 구름이 있는 바구니에 저장된 물의 양 증가
			
			copyClouds.add(new Cloud(moveR, moveC));
		}
		
		while(copyClouds.size() != 0) {
			Cloud c = copyClouds.poll();
			
			// 물복사버그 마법 시전 (대각선 방향으로 거리가 1인 칸의 바구니의 수 만큼 증가
			for(int i = 0; i < 4; i++) { 
				int idx = crossIdx[i];
				
				if(c.row+d[idx][0]>0 && c.row+d[idx][0]<=N && c.column+d[idx][1]>0 && c.column+d[idx][1]<=N
						&& map[c.row+d[idx][0]][c.column+d[idx][1]]!=0)
					map[c.row][c.column]++;
			}
		}
		
		for(int n1 = 1; n1 <= N; n1++) {
			for(int n2 = 1; n2 <= N; n2++) {
				if(!isCloud[n1][n2] && map[n1][n2] >= 2) { // 물이 2 이상인 경우 (구름이 있었던 칸 제외)
					clouds.add(new Cloud(n1, n2)); // 구름 생성
					map[n1][n2] -= 2; // 물의 양 2 감소
				}
			}
		}
	}
	
	public static int location(int now, int direction, int space) {
		for(int s = 0; s < space; s++) {
			now += direction;
			if(now > N) now = 1;
			else if(now == 0) now = N;
		}
		return now;
	}
}
