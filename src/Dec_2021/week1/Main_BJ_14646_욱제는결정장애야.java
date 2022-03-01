package Dec_2021.week1;

import java.util.*;
import java.io.*;

public class Main_BJ_14646_욱제는결정장애야 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 메뉴의 개수
		int[] board = new int[N+1]; // 돌림판
		int cnt = 0;
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int n = 0; n < 2*N; n++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(board[num] == 0) {
				board[num] = 1;
				cnt++;
			}
			else
				cnt--;
			
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
	}
}
