package Jun_2022.week2;

import java.io.*;
import java.util.*;

public class Main_BJ_11663_선분위의점 {
	
	static int N, M;
	static int[] dots;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 점의 개수
		M = Integer.parseInt(st.nextToken()); // 선분의 개수
		dots = new int[N]; // 점들의 좌표
		
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) dots[n] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(dots);
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			System.out.println(countDots(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
	}
	
	public static int countDots(int start, int end) {
		int min = 0;
		int max = N-1;
		int minDotIdx = -1;
		int maxDotIdx = -1;
		
		while(max >= min) { // 선분의 시작점과 점들 비교
			int mid = (min+max) / 2;
			
			if(start > dots[mid]) min = mid + 1;
			else max = mid - 1;
		}
		
		minDotIdx = min;
		
		min = 0;
		max = N-1;
		
		while(max >= min) { // 선분의 끝점과 점들 비교
			int mid = (min+max) / 2;
			
			if(end < dots[mid]) max = mid - 1;
			else min = mid + 1;
		}
		
		maxDotIdx = max;
		
		return maxDotIdx - minDotIdx + 1;
	}
}