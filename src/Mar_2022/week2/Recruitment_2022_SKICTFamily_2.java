package Mar_2022.week2;

import java.util.*;
import java.io.*;

public class Recruitment_2022_SKICTFamily_2 {
	
	static class Coordi {
		int row, column, direction, order;
		Coordi(int row, int column, int direction, int order){
			this.row = row;
			this.column = column;
			this.direction = direction;
			this.order = order;
		}
	}
	
	static int n;
	static boolean clockwise;
	static int[][] answer;
	
	static int[][] D1 = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우, 하, 좌, 상
	static int[][] D2 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 하, 우, 상, 좌
	static int[][] D;
	static int[][] first;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 자연수
		clockwise = Boolean.parseBoolean(br.readLine()); // true:시계방향, false:반시계방향
		answer = new int[n][n];
		D = new int[4][2];
		first = new int[][]{{0, 0}, {0, n-1}, {n-1, n-1}, {n-1, 0}};
		
		D = clockwise ? D1 : D2;
		
		bfs();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				System.out.print(answer[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void bfs() {
		Queue<Coordi> queue = new LinkedList<Coordi>();
		
		for(int i = 0; i < 4; i++) { 
			queue.offer(new Coordi(first[i][0], first[i][1], i, 1));
			answer[first[i][0]][first[i][1]] = 1;
		}
		
		while(!queue.isEmpty()) {
			Coordi cur = queue.poll();
			
			int nextD = cur.direction;
			int nextR = cur.row + D[nextD][0];
			int nextC = cur.column + D[nextD][1];
			
			int time = 0;
			while((nextR<0 || nextR>=n || nextC<0 || nextC>=n || answer[nextR][nextC]!=0)) {
				nextD = (nextD+1)%4;
				nextR = cur.row + D[nextD][0];
				nextC = cur.column + D[nextD][1];
				
				if(++time > 4) return;
			}
			
			queue.offer(new Coordi(nextR, nextC, nextD, cur.order+1));
			answer[nextR][nextC] = cur.order+1;
		}
	}
}