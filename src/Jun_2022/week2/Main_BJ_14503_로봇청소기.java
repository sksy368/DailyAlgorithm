package Jun_2022.week2;

import java.io.*;
import java.util.*;

public class Main_BJ_14503_로봇청소기 {
	
	static int N, M, cnt, curR, curC, curD;
	static int[][] map, D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로 크기
		M = Integer.parseInt(st.nextToken()); // 가로 크기
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		curR = Integer.parseInt(st.nextToken()); // 로봇 청소기의 좌표(세로)
		curC = Integer.parseInt(st.nextToken()); // 로봇 청소기의 좌표(가로)
		curD = Integer.parseInt(st.nextToken()); // 로봇 청소기의 방향(0:북, 1:동, 2:남, 3:서)
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++)
				map[n][m] = Integer.parseInt(st.nextToken()); // 빈칸:0, 벽:1
		}
		
		cnt = 0; // 청소하는 칸의 개수
		clean();
		System.out.println(cnt);
	}
	
	public static void clean() {
		boolean[][] checked = new boolean[N][M];
		int turnCnt = 0;
		
		while(true) {
			// 현재 위치를 청소
			if(!checked[curR][curC]) {
				checked[curR][curC] = true;
				cnt++;
				turnCnt = 0;
			}
			
			int nextD = (curD+3) % 4;
			int nextR = curR + D[nextD][0];
			int nextC = curC + D[nextD][1];
			
			if(nextR>=0 && nextR<N && nextC>=0 && nextC<M && map[nextR][nextC]==0 && !checked[nextR][nextC]) { // 아직 청소하지 않은 빈 공간인 경우
				curR = nextR;
				curC = nextC;
				turnCnt = 0;
			}
			else 
				turnCnt++;
			
			curD = nextD; // 왼쪽으로 회전
			
			if(turnCnt >= 4) { // 2a번 단계가 연속으로 네 번 실행되었을 경우
				int backR = curR + D[(curD+2)%4][0];
				int backC = curC + D[(curD+2)%4][1];
				
				if(map[backR][backC] == 1) // 바로 뒤쪽이 벽인 경우
					return;
				else { // 바로 뒤쪽이 벽이 아닌 경우, 한 칸 후진
					curR = backR;
					curC = backC;
					turnCnt = 0;
				}		
			}
		}
	}
}
