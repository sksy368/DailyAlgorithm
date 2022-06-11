package Jun_2022.week2;

import java.io.*;
import java.util.*;

public class Main_BJ_17266_어두운굴다리 {
	
	static int N, M;
	static int[] bridge;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 굴다리의 길이
		M = Integer.parseInt(br.readLine()); // 가로등의 개수
		bridge = new int[M]; // 굴다리의 위치
		int answer = N;
		
		st = new StringTokenizer(br.readLine());
		for(int m = 0; m < M; m++) bridge[m] = Integer.parseInt(st.nextToken());
		
		int min = 1;
		int max = N;
		
		while(max >= min) {
			int mid = (min+max) / 2;

			if(isPossible(mid)) {
				answer = Math.min(mid, answer);
				max = mid - 1;
			}
			else
				min = mid + 1;
		}
		
		System.out.println(answer);
	}
	
	public static boolean isPossible(int height) {
		int from = 0; // 해당 가로등이 비출 수 있는 x좌표의 최솟값
		int to = 0; // 해당 가로등이 비출 수 있는 x좌표의 최댓값
		
		for(int m = 0; m < M; m++) {
			from = bridge[m] - height;
			
			if(from > to) return false; // 해당 가로등이 비출 수 있는 x좌표의 최솟값이 이전 가로등이 비출 수 있는 x좌표의 최댓값보다 작은 경우
			else to = bridge[m] + height;
		}
		
		if(to < N) return false; // 마지막 가로등이 비출 수 있는 x좌표의 최댓값이 굴다리의 길이보다 작은 경우
		else return true;
	}
}