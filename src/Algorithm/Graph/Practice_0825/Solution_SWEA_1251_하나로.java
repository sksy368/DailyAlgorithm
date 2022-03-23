package Algorithm.Graph.Practice_0825;

import java.util.*;
import java.io.*;

public class Solution_SWEA_1251_하나로 { // 크루스칼 ㅅㅂㅅ
	
	static int N, sum;
	static int[][] iland;
	static double E;
	
	static int[][] adjMatrix;
	static int[] distance;
	
	public static void dijkstra() {
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 섬의 개수
			iland = new int[N][2];
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				iland[i][0] = Integer.parseInt(st1.nextToken()); // 섬의 X좌표
				iland[i][1] = Integer.parseInt(st2.nextToken()); // 섬의 Y좌표
			}
			
			E = Double.parseDouble(br.readLine()); // 환경 부담 세율 실수
			
			adjMatrix = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++)
					adjMatrix[i][j] = adjMatrix[j][i] = Math.abs(iland[i][0] - iland[j][1]) + Math.abs(iland[i][1] - iland[j][1]);
			}
			
			dijkstra();
			
			System.out.println("#" + t + " " + (E*sum));
		}

	}

}
