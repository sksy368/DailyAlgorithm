package Algorithm.Graph.Practice_0825;

import java.util.*;
import java.io.*;

public class Main_BJ_16236_아기상어 {
	
	static class Fish {
		int r, c;
		Fish(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static class Shark {
		int r, c, distance;
		Shark(int r, int c, int distance){
			super();
			this.r = r;
			this.c = c;
			this.distance = distance;
		}
	}
	
	static int N, nowR, nowC, nowSize, eat, time;
	static int[][] map;
	static ArrayList<Fish> fish;
	
	// 상 -> 좌 -> 우 -> 하 (우선순위 : 가장 위쪽 -> 가장 왼쪽)
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	// 가장 가까운 물고기 찾기
	private static Shark findFish() {
		Shark result = new Shark(-1, -1, 0);
		
		if(fish.size() != 0) { // 물고기가 있는 경우
			Queue<Shark> queue = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];
			int distance = 0;
			
			queue.offer(new Shark(nowR, nowC, 0));
			visited[nowR][nowC] = true;
			
			while(!queue.isEmpty()) {
				Shark cur = queue.poll();
				
				for(int d = 0; d < 4; d++) {
					int r = cur.r + dr[d];
					int c = cur.c + dc[d];
					
					if(r >= 0 && r < N && c >= 0 && c < N && !visited[r][c] && map[r][c] <= nowSize) {
						if(map[r][c] != 0 && map[r][c] < nowSize &&  ) {
							if(shark.r )
							result = new Shark (r, c, cur.distance+1); // 아기상어보다 물고기 크기가 작은 경우, 물고기 좌표 반환
						}
						
						queue.offer(new Shark (r, c, cur.distance+1));
						visited[r][c] = true;
						distance++;
					}
				}
			}
		}
		return result; // 먹을 수 있는 물고기가 없는 경우 (-1,-1) 반환
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 공간의 크기
		map = new int[N][N];
		fish = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 0:빈칸, 1~6:물고기 크기, 9:아기상어 위치
				
				if(map[i][j] >= 1 && map[i][j] <= 6)
					fish.add(new Fish(i, j));
				else if(map[i][j] == 9) {
					nowR = i; nowC = j;
					map[i][j] = 0;
				}
			}
		}
		
		nowSize= 2; // 아기상어 크기
		eat = 0; // 현재 먹은 물고기 수
		
		while(true) {
			Shark full = findFish();
			if(full == null) break;
			
			for(int i = 0; i < fish.size(); i++) {
				if(fish.get(i).r == full.r && fish.get(i).c == full.c) {
					fish.remove(i);
					break;
				}
			}
			System.out.println(time);
			time += full.distance;
			map[full.r][full.c] = 0;
			
			System.out.println("\n" + time + "초");
			for(int i = 0; i< N; i++) {
				for(int j = 0; j < N; j++)
					System.out.print(map[i][j] + " ");
				System.out.println();
			}
			
			nowR = full.r;
			nowC = full.c;
			eat++;
			
			if(nowSize == eat) {
				nowSize++;
				eat = 0;
			}
		}
		
		System.out.println(time);
	}
}