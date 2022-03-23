package Feb_2022;

import java.util.*;
import java.io.*;

public class Main_BJ_2615_오목 {
	
	static int[][] ground;
	static int count, r, c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ground = new int[19][19];
		count = 0;
		r = 0; c = 0;
		
		for(int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 19; j++)
				ground[i][j] = Integer.parseInt(st.nextToken()); // 1:검정바둑알, 2:흰바둑알, 0:알X
		}
		
		// 열 단위로 탐색
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(ground[j][i] == 0) continue;
				
				if(check(j, i)) {
					count++;
					r = j;
					c = i;
				}
			}
		}
		
		if(count == 1)
			System.out.println(ground[r][c] + "\n" + (r+1) + " " + (c+1));
		else if(count == 0)
			System.out.println(0);
	}
	
	public static boolean check(int row, int column) {
		if(row+4 <= 19) { // ↓인 경우
			for(int i = 1; i < 5; i++) {
				if(ground[row+i][column] != ground[row][column]) // 색이 다른 경우
					break;
				
				if(i == 4) { // 5개 색이 같은 경우
					if((row-1<0 || ground[row-1][column]!=ground[row][column]) && (row+5==19 || ground[row+5][column]!=ground[row][column]))
						return true;
				}
			}
		} 
		if(column+4 <= 19) { // →인 경우
			for(int i = 1; i < 5; i++) {
				if(ground[row][column+i] != ground[row][column])
					break;
				if(i == 4) {
					if((column-1<0 || ground[row][column-1]!=ground[row][column]) && (column+5==19 || ground[row][column+5]!=ground[row][column]))
						return true;
				}
			}
		} 
		if(row+4<=19 && column+4<=19) { // ↘︎인 경우
			for(int i = 1; i < 5; i++) {
				if(ground[row+i][column+i] != ground[row][column])
					break;
				
				if(i == 4) { 
					if((row+5==19 || column+5==19) && ((row-1<0 || column-1<0 || ground[row-1][column-1]!=ground[row][column]) && ground[row+5][column+5]!=ground[row][column]))
						return true;
				}
			}
		} 
		if(row-4>=0 && column+4<=19) { // ↗︎인 경우
			for(int i = 1; i < 5; i++) {
				if(ground[row-i][column+i] != ground[row][column]) 
					break;
				
				if(i == 4) { 
					if((row-5<0 || column+5==19) && ((row+1==19 || column-1<0 || ground[row+1][column-1]!=ground[row][column]) && ground[row-5][column+5]!=ground[row][column]))
						return true;
				}
			}
		} 
		return false;
	}
}