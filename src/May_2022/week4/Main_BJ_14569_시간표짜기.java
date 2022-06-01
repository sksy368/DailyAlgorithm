package May_2022.week4;

import java.io.*;
import java.util.*;

public class Main_BJ_14569_시간표짜기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 과목 수
		long[] time = new long[N];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken()); // 과목시간의 수
			
			for(int k = 0; k < K; k++) time[n] += Math.pow(2, Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine()); // 학생 수
		
		for(int m = 0; m < M; m++) {
			int cnt = 0; // 신청할 수 있는 과목의 후보 개수
			
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken()); // 비어있는 교시 개수
			long empty = 0;
			
			for(int p = 0; p < P; p++) empty += Math.pow(2, Integer.parseInt(st.nextToken()));
			
			for(int n = 0; n < N; n++)
				if((time[n]&empty) == time[n]) cnt++; // 비어있는 시간에 수업이 진행되는 시간이 포함되어 있는 경우
			
			System.out.println(cnt);
		}
	}
}