package Oct_2021.week2;

import java.util.*;
import java.io.*;

public class Main_BJ_2056_작업 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 작업 수
		int[] D = new int[N+1];
		
		int totalTime = 0;
		
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int time = Integer.parseInt(st.nextToken()); // 작업 시간
			int preNum = Integer.parseInt(st.nextToken()); // 선행 작업 수
			
			D[n] = time;
			
			for(int i = 0; i < preNum; i++) {
				int pre = Integer.parseInt(st.nextToken());
				D[n] = Math.max(D[pre]+time, D[n]); // 갱신
			}
			
			totalTime = Math.max(D[n], totalTime);
		}
		
		System.out.println(totalTime);
	}
}