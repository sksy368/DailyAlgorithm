package Algorithm.Implemention.Practice_0813;

import java.util.*;
import java.io.*;

public class Main_BJ_17135_캐슬디펜스 {
	
	static int N, M, D, killNum, max;
	static int[][] map;
	static int[] archers;
	static ArrayList<int[]> enermies;
	
	private static void play() {
		int archerRow = N; // 궁수가 위치하는 행
		killNum = 0; // 죽인 적의 수
		
		ArrayList<int[]> copyEnermies = new ArrayList<>(); // 적의 좌표 (복사본)
		for(int i = 0; i < enermies.size(); i++) {
			int[] temp = enermies.get(i);
			copyEnermies.add(new int[] {temp[0], temp[1]});
		}
		
		while(archerRow > 0) {
			if(copyEnermies.size() == 0) break;
			
			HashSet<Integer> removeIdx = new HashSet<>();
			for(int i = 0; i < 3; i++) {
				int minIdx = -1;
				int minColumn = -1;
				int minDist = Integer.MAX_VALUE;
				
				for(int j = 0; j < copyEnermies.size(); j++) { 
					if(copyEnermies.get(j)[0] >= archerRow) { // 적이 궁수를 지나칠 경우
						copyEnermies.remove(j--);
						continue;
					}
					
					int distance = Math.abs(archerRow-copyEnermies.get(j)[0]) + Math.abs(archers[i] - copyEnermies.get(j)[1]);
					if(distance <= D ) { // 제한 거리 이하일 경우, 제거할 적 마킹
						if(minDist > distance || (minDist == distance && minColumn > copyEnermies.get(j)[1])) {
							minDist = distance;
							minIdx = j;
							minColumn = copyEnermies.get(j)[1];
						}
					}
				}
				
				if(minIdx != -1)
					removeIdx.add(minIdx);
			}
			
			if(removeIdx.size() != 0) {
				Object[] temp = removeIdx.toArray();
				Arrays.sort(temp);
				
				for(int i = temp.length-1; i >= 0; i--) // 적 제거
					copyEnermies.remove((int)temp[i]);
				
				killNum += removeIdx.size();
			}
			
			archerRow--; // 궁수 전진
		}
		
		max = Math.max(killNum, max);
	}
	
	
	private static void combination(int cnt, int start) {
		if(cnt == 3) {
			play();
			
			return;
		}
		
		for(int i = start; i < M; i++) {
			archers[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 격자판의 행의 수
		M = Integer.parseInt(st.nextToken()); // 격자판의 열의 수
		D = Integer.parseInt(st.nextToken()); // 궁수의 공격 거리 제한
		
		map = new int [N][M];
		archers = new int[3]; // 궁수의 좌표
		enermies = new ArrayList<>(); // 적의 좌표
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int temp = 0;
			
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken()); // 0:빈칸 1:적
				
				if(map[n][m] == 1) {
					enermies.add(temp++, new int[] {n, m}); // 궁수와 가까운 행(큰 숫자의 행)이 
				}
			}
		}
		
		max = 0;
		combination(0, 0); // 궁수의 위치 -> 조합
		
		System.out.println(max);
	}
}