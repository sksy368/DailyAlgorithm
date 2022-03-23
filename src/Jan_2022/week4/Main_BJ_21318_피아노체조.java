package Jan_2022.week4;

import java.util.*;
import java.io.*;

public class Main_BJ_21318_피아노체조 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 악보의 개수
		int[] difficulty = new int[N+1]; // 악보의 난이도
		int[] mistake = new int[N+1]; // 실수 개수
		
		st = new StringTokenizer(br.readLine());
		for(int n = 1; n <= N; n++) {
			difficulty[n] = Integer.parseInt(st.nextToken());
			
			mistake[n-1] += difficulty[n] < difficulty[n-1] ? 1 : 0; // 지금 악보가 다음 악보보다 어려운 경우
			mistake[n] = mistake[n-1]; // 누적
		}
		
		int Q = Integer.parseInt(br.readLine()); // 질문의 개수
		
		for(int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(x == y)
				System.out.println(0);
			else
				System.out.println(mistake[y-1] - mistake[x-1]);
		}
	}
}