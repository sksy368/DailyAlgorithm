package May_2022.week4;

import java.io.*;
import java.util.*;

public class Main_BJ_1546_평균 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 시험 본 과목의 개수
		int M = 0; // 점수 중 최댓값
		int[] grade = new int[N]; // 현재 점수
		double sum = 0; // 새로운 점수의 합
		
		st = new StringTokenizer(br.readLine());
		
		for(int n = 0; n < N; n++) {
			grade[n] = Integer.parseInt(st.nextToken());
			M = Math.max(grade[n], M);
		}
		
		for(int n = 0; n < N; n++)
			sum += (double)grade[n] / M * 100;
		
		System.out.println(sum / N);
	}
}