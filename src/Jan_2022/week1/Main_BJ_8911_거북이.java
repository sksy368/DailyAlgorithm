package January;

import java.io.*;

public class Main_BJ_8911_거북이 {
	
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북, 동, 남, 서

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			String orders = br.readLine();
			
			int nowR = 0, nowC = 0; // 현재 거북이의 위치
			int nowD = 0; // 현재 거북이의 방향 (북:0, 동:1, 남:2, 서:3)
			int minR = 0, minC = 0, maxR = 0, maxC = 0;
			
			for(int i = 0; i < orders.length(); i++) {
				char order = orders.charAt(i); // 현재 명령
				if(order == 'F') {
					// 한 눈금 앞으로
					nowR += d[nowD][0];
					nowC += d[nowD][1];
				} else if(order == 'B') {
					// 한 눈금 뒤로
					nowR -= d[nowD][0];
					nowC -= d[nowD][1];
				} else if(order == 'L')
					nowD = (nowD+7) % 4; // 왼쪽으로 회전
				else if(order == 'R')
					nowD = (nowD+1) % 4; // 오른쪽으로 회전
				
				minR = Math.min(minR, nowR);
				maxR = Math.max(maxR, nowR);
				minC = Math.min(minC, nowC);
				maxC = Math.max(maxC, nowC);
			}
			
			System.out.println((maxR-minR) * (maxC-minC));
		}
	}
}