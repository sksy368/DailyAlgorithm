package Sep_2021.week2;

import java.util.*;
import java.io.*;

public class Main_BJ_3190_뱀 {
	
	static class Snake {
		int row, column;
		Snake(int row, int column){
			this.row = row;
			this.column = column;
		}
	}
	
	static class Coordi { 
		int x;
		char c;
		Coordi(int x, char c){
			this.x = x;
			this.c = c;
		}
	}
	
	static Queue<Snake> queue;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static boolean isContain(int row, int column) {
		Iterator<Snake> it = queue.iterator();
		while(it.hasNext()) {
			Snake snake = it.next();
			if(snake.row == row && snake.column == column)
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 보드의 크기
		int K = Integer.parseInt(br.readLine()); // 사과의 개수
		
		int[][] map = new int[N+1][N+1];
		
		for(int i = 0; i < K; i++) { // 사과 위치 1로 표시
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()); // 행
			int column = Integer.parseInt(st.nextToken()); // 열
			
			map[row][column] = 1;
		}
		
		int L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수
		Queue<Coordi> coordi = new LinkedList<>(); // 뱀의 방향 변환 정보 저장
		
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken()); // 게임 경과 시간
			char C = st.nextToken().charAt(0); // 회전 방향 (L:왼쪽, D:오른쪽)
			coordi.offer(new Coordi(X, C));
		}
		
		int nowR = 1, nowC = 1, d = 0; // 현재 좌표, 방향
		queue = new LinkedList<>();
		queue.offer(new Snake(1, 1)); // 처음 위치
		int time = 0; // 경과 시간
		
		while(true) {
			time++;
			
			if(nowR+dr[d] < 1 || nowR+dr[d] > N || nowC+dc[d] < 1 || nowC+dc[d] > N
					|| (!queue.isEmpty() && isContain(nowR+dr[d], nowC+dc[d]))) // 벽에 부딪히거나 몸에 부딪힌 경우
				break;
			
			if(map[nowR+dr[d]][nowC+dc[d]] == 1) // 사과를 먹은 경우
				map[nowR+dr[d]][nowC+dc[d]] = 0;
			else if(map[nowR+dr[d]][nowC+dc[d]] == 0) // 사과를 먹지 않은 경우
				queue.poll();
			
			nowR += dr[d];
			nowC += dc[d];
			queue.offer(new Snake(nowR, nowC));
			
			if(!coordi.isEmpty() && coordi.peek().x == time) {
				if(coordi.peek().c == 'L') // 왼쪽으로 회전
					d = ((d - 1) + 4) % 4;
				else if(coordi.peek().c == 'D') // 오른쪽으로 회전
					d = (d + 1) % 4;
				coordi.poll();
			}
		}
		
		System.out.println(time);
	}
}