package November.week2;

import java.io.*;
import java.util.*;

public class Main_BJ_1941_소문난칠공주 {
	
	static char[][] map;
	static int[] pick;
	
	static int answer;
	
	static int[] dr = {-1, 1, 0, 0};
	static  int[] dc = {0, 0, -1, 1};
	
	static boolean check(int[] pick) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] checked = new boolean[7];
		int count = 1;
		
		queue.offer(pick[0]);
		checked[0] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			int nowR = cur / 5;
			int nowC = cur % 5;

			for(int d = 0; d < 4; d++) {
				int r = nowR + dr[d];
				int c = nowC + dc[d];
				
				for(int i = 0; i < 7; i++) {	
					if(!checked[i] && r>=0 && r<5 && c>=0 && c<5 && pick[i] == r*5+c) {
						queue.offer(pick[i]);
						checked[i] = true;
						count++;
					}
				}
			}
		}
		
		if(count == 7) return true;
		else return false;
	}
	
	
	static void combination(int cnt, int start, int cntY) {
		
		if(cntY >= 4) return; // 임도연파 학생이 4명 이상인 경우
		
		if(cnt == 7) {
			if(check(pick)) answer++; // 7명이 붙어있는 경우
			return;
		}
		
		for(int i = start; i < 25; i++) {
			pick[cnt] = i;
			
			combination(cnt+1, i+1, map[i/5][i%5] == 'Y' ? cntY+1 : cntY);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		
		for(int i = 0; i < 5; i++)
			map[i] = br.readLine().toCharArray();
		
		
		pick = new int[7];
		answer = 0;
		
		combination(0, 0, 0);
		
		System.out.println(answer);
	}
}