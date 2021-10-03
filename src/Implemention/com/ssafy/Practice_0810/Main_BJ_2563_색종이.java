package Implemention.com.ssafy.Practice_0810;

import java.util.*;
import java.io.*;

public class Main_BJ_2563_색종이 {
	
	public static void draw(int[][] area, int x, int y) {
		for(int i = x; i < x + 10; i++) {
			for(int j = y; j < y + 10; j++) {
				area[i][j] = 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[][] area = new int[100][100];
		int num = Integer.parseInt(st.nextToken());
		
		int maxX = 0, maxY = 0, minX = 0, minY = 0;
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			maxX = Math.max(x, maxX);
            minX = Math.min(x, minX);
			maxY = Math.max(y, maxY);
            minY = Math.min(y, minY);
			
			draw(area, x, y);
		}
		
		int count = 0;
		for(int i = minX; i < maxX + 10; i++) {
			for(int j = minY; j < maxY + 10; j++) {
				if(area[i][j] == 1)
					count += 1;
			}
		}
		
		System.out.println(count);
	}
}