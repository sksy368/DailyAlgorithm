package Mar_2022.week1;

import java.io.*;
import java.util.*;

public class Main_BJ_2234_성곽 {
	
	static int[][] D = {{0, 1}, {-1, 0}, {0, 1}, {1, 0}}; // 서, 북, 동, 남

	static int M, N, roomNum, maxArea, removeMaxArea;
	static int[][] castle;
	
	static ArrayList<int[]>[][] adjList;
	static HashMap<int[], Integer> roomArea;
	static boolean[][] checked;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 성곽의 크기(세로)
		N = Integer.parseInt(st.nextToken()); // 성곽의 크기(가로)
		
		castle = new int[M][N]; // 성곽에 대한 정보
		
		adjList = new ArrayList[M][N]; // 이동 가능 경로
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				int num = Integer.parseInt(st.nextToken()); // +1:서쪽 벽, +2:북쪽 벽, +4:동쪽 벽, +8:남쪽 벽
				adjList[m][n] = new ArrayList<int[]>();
				
				for(int b = 0; b < 4; b++)
					if(num != (num | 1<<b)) adjList[m][n].add(new int[] {m+D[b][0], n+D[b][1]}); // 벽이 없는 경우
			}
		}
		
		roomNum = maxArea = removeMaxArea = 0;
		roomArea = new HashMap<>(); // 방의 시작점, 방들의 넓이
		checked = new boolean[M][N];
		
		// 각 방의 넓이 구하기
		for(int m = 0; m < M; m++) {
			for(int n = 0; n < N; n++) {
				if(!checked[m][n]) {
					findArea(m, n);
					roomNum++; // 방 개수 갱신
				}
			}
		}
		
		for(int m = 0; m < M; m++) {
			for(int n = 0; n < N; n++) {
				
			}
		}
		
		
		System.out.println(roomNum + "\n" + maxArea + "\n" + removeMaxArea);
	}
	
	
	public static void findArea(int row, int column) {
		Queue<int[]> queue = new LinkedList<>();
		int area = 1; // 방 넓이
		
		queue.offer(new int[] {row, column});
		checked[row][column] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int[] next : adjList[cur[0]][cur[1]]) {
				if(!checked[next[0]][next[1]]) {
					queue.offer(new int[] {next[0], next[1]});
					checked[next[0]][next[1]] = true;
					
					castle[next[0]][next[1]] = roomNum; // 방 번호 표시
					area++; // 방 넓이 추가
				}
			}
		}
		
		roomArea.put() // 방 넓이 저장
		maxArea = Math.max(area, maxArea); // 방 넓이의 최대값 갱신
	}
}
