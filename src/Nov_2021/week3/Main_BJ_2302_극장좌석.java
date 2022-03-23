package Nov_2021.week3;

import java.io.*;

public class Main_BJ_2302_극장좌석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 좌석 개수
		int M = Integer.parseInt(br.readLine()); // 고정석 개수
		int[] seat = new int[N+1];
		
		for(int m = 0; m < M; m++)
			seat[Integer.parseInt(br.readLine())] = 1;
		
		
	}
}