package Dec_2021.week4;

import java.util.*;
import java.io.*;

public class Main_BJ_16438_원숭이스포츠 {
	
	static int N;
	static int[][] arr;
	
	public static void dfs(int l, int r, int day, int team) {
		if(day == 7) return;
		
		int mid = (l+r) / 2;
		int opp = team==0 ? 1 : 0;
		
		for(int i = l; i <= r; i++) {
			arr[day][i] = i <= mid ? team : opp;
		}
		
		dfs(l, mid, day+1, opp);
		dfs(mid+1, r, day+1, team);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 원숭이 수
		arr = new int[7][99];
		
		dfs(0, N-1, 0, 0);
		
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < N; j++)
				System.out.print(arr[i][j]!=0 ? 'A' : 'B');
			System.out.println();
		}
	}
}
