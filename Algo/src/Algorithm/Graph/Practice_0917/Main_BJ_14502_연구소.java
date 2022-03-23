package Algorithm.Graph.Practice_0917;

import java.util.*;
import java.io.*;

public class Main_BJ_14502_연구소 { // 질문 : bfs만으로 풀 수 있나?
	 
	static int N, M, max;
	static int[][] map;
	
	static ArrayList<int[]> empty, virus;
	static int[] select;
	static int[][] copyMap;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 안전 영역 세기
	private static void countSafeZone() { 
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap[i][j] == 0) ++sum;
			}
		}
		
		max = Math.max(sum, max); // 안전 영역의 최댓값 갱신
	}
	
	// 바이러스 퍼뜨리기
	private static void spreadVirus() { 
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i = 0; i < virus.size(); i++)
			queue.offer(new int[] {virus.get(i)[0], virus.get(i)[1]});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int row = cur[0] + dr[d];
				int column = cur[1] + dc[d];
				
				if(row >= 0 && row < N && column >= 0 && column < M && copyMap[row][column] == 0) {
					queue.offer(new int[] {row, column});
					copyMap[row][column] = 2; // 바이러스 감염 표시
				}
			}
		}
		
		countSafeZone();
	}
	
	// 벽을 세울 3곳 뽑기
	private static void combination(int cnt, int start) { 
		if(cnt == 3) {
			copyMap = new int[N][M];
			for(int i = 0; i < N; i++)
				copyMap[i] = map[i].clone();
			
			for(int i = 0; i < 3; i++) {
				int row = empty.get(select[i])[0];
				int column = empty.get(select[i])[1];
				copyMap[row][column] = 1; // 벽 세우기
			}
			
			spreadVirus();
			
			return;
		}
		
		for(int i = start; i < empty.size(); i++) {
			select[cnt] = i;
			combination(cnt+1, i+1);
		}
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 지도의 세로 크기
		M = Integer.parseInt(st.nextToken()); // 지도의 가로 크기
		map = new int[N][M];
		empty = new ArrayList<>();
		virus = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 0:빈칸, 1:벽, 2:바이러스
				
				if(map[i][j] == 0) empty.add(new int[] {i, j});
				else if(map[i][j] == 2) virus.add(new int[] {i, j});
			}
		}
		
		select = new int[3];
		max = 0;
		combination(0, 0);
		
		System.out.println(max);
	}
}