package Algorithm.Implemention.Practice_0813;

import java.util.*;
import java.io.*;

public class Main_BJ_15686_치킨배달 {
	
	static class Coordi {
		int row, column;
		Coordi(int row, int column){
			this.row = row;
			this.column = column;
		}
	}
	
	static int min;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int findDistance(int row, int column, int N, Coordi[] select) {
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < select.length; i++) {
			int r = Math.abs(row - select[i].row);
			int c = Math.abs(column - select[i].column);
			
			min = Math.min(r+c, min);
		}
		
		return min;
	}
	
	
	static void combination(int start, int cnt, int unClosing, int N, int[][] map, ArrayList<Coordi> chickens, Coordi[] select) {
		if(cnt == unClosing) {
			int sum = 0;
			
			for(int i = 1; i < N+1; i++) {
				for(int j = 1; j < N+1; j++) {
					if(map[i][j] == 1)
						sum += findDistance(i, j, N, select);
				}
			}
			
			min = Math.min(sum, min);
			
			return;
		}
		
		for(int i = start; i < chickens.size(); i++) {
			select[cnt] = chickens.get(i);	
			combination(i+1, cnt+1, unClosing, N, map, chickens, select);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 도시 크기
		int M = Integer.parseInt(st.nextToken()); // 폐업시키지 않을 치킨집의 최대 개수
		
		int[][] map = new int[N+1][N+1];
		ArrayList<Coordi> chickens = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 0:빈칸, 1:집, 2:치킨집
				
				if(map[i][j] == 2) {
					chickens.add(new Coordi(i, j)); // 치킨집 좌표 저장
					map[i][j] = 0;
				}
			}
		}
	
		min = Integer.MAX_VALUE;
		
		for(int i = 1; i <= M; i++) {
			Coordi[] select = new Coordi[i];
			combination(0, 0, i, N, map, chickens, select);
		}
		
		System.out.println(min);
	}
}