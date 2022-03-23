package Algorithm.Implemention.Practice1206;

import java.io.*;
import java.util.*;

public class Solution_SWEA_2382_미생물격리 {
	
	static class Info {
		int r, c, n, d;
		Info (int r, int c, int n, int d){
			super();
			this.r = r;
			this.c = c;
			this.n = n;
			this.d = d;
		}
	}
	
	static int N, M, K, cnt;
	static Info[] infos;
	static int[][] map;
	
	static int[][] d = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 구역의 한 변에 있는 셀의 개수
			M = Integer.parseInt(st.nextToken()); // 격리 시간
			K = Integer.parseInt(st.nextToken()); // 미생물 군집의 개수
			
			infos = new Info[K+1];
			map = new int[N][N];
			cnt = 0; // 미생물 총 개수
			
			for(int k = 1; k <= K; k++) {
				st = new StringTokenizer(br.readLine());
				
				int r = Integer.parseInt(st.nextToken()); // 세로 위치
				int c = Integer.parseInt(st.nextToken()); // 가로 위치
				int n = Integer.parseInt(st.nextToken()); // 미생물 수
				int d = Integer.parseInt(st.nextToken()); // 이동 방향 (상:1 하:2 좌:3 우:4)
				
				infos[k] = new Info(r, c, n, d);
				map[r][c] = k;
				cnt += n;
			}
			
			while(M-- > 0) {
				int[][] tmp = new int[N][N]; // 이동한 위치 임시 저장
				int[][] numMax = new int[N][N]; // 셀에 존재하는 군집들 중 미생물 수가 많은 군집의 미생물 수 저장
				
				for(int k = 1; k <= K; k++) { // 미생물 군집 이동
					if(infos[k].n == 0) continue;
					
					int row = infos[k].r + d[infos[k].d][0]; // 이동한 위치(행)
					int column = infos[k].c + d[infos[k].d][1]; // 이동한 위치(열)
					
					infos[k].r = row;
					infos[k].c = column;
					
					if(row == 0 || row == N-1 || column == 0 || column == N-1) { // 군집이 약품이 칠해진 셀에 도착한 경우
						cnt -= (infos[k].n+1)/2; // cnt 갱신
						infos[k].n = infos[k].n/2; // 절반이 사망
						infos[k].d += (infos[k].d==1 || infos[k].d==3) ? 1 : -1; // 이동방향 변경
					}
					
					if(tmp[row][column] == 0) { // 한 셀에 한 개의 군집만 있는 경우
						tmp[row][column] = k;
						numMax[row][column] = infos[k].n;
					}
					else { // 두 개 이상의 군집이 한 셀에 모이는 경우
						int many = 0; // 이미 셀에 존재하는 군집과 현재 군집 중 미생물 수가 많은 군집
						int few = 0;
						
						if(infos[k].n > numMax[row][column]) {
							many = k;
							few = tmp[row][column];
						}
						else {
							many = tmp[row][column];
							few = k;
						}
						
						numMax[row][column] = infos[many].n;
						infos[many].n += infos[few].n;
						infos[few].n = 0;
						tmp[row][column] = many;
					}
				}
				
				map = tmp;
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}