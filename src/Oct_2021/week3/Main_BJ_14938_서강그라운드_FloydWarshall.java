package October.week3;

import java.util.*;
import java.io.*;

public class Main_BJ_14938_서강그라운드_FloydWarshall {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 지역의 개수
		int m = Integer.parseInt(st.nextToken()); // 수색범위
		int r = Integer.parseInt(st.nextToken()); // 길의 개수
		
		int[][] map = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i != j) map[i][j] = 16;
			}
		}
		
		int[] items = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++)
			items[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			map[a][b] = map[b][a] = l;
		}
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) 
					map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
			}
		}
		
		int max = 0;
		
		System.out.println("디버깅");
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
		System.out.println("디버깅");
				
		for(int i = 1; i <= n; i++) {
			int sum = 0;
			
			for(int j = 1; j <= n; j++) {
				if(map[i][j] <= m)
					sum += items[j];
			}
			
			max = Math.max(sum, max);
		}
		
		System.out.println(max);
	}
}
