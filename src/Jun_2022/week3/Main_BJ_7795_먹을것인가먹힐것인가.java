package Jun_2022.week3;

import java.io.*;
import java.util.*;

public class Main_BJ_7795_먹을것인가먹힐것인가 {
	
	static int N, M, cnt;
	static int[] A, B;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // A의 수
			M = Integer.parseInt(st.nextToken()); // B의 수
			
			A = new int[N]; // A의 크기
			B = new int[M]; // B의 크기
			cnt = 0; // A가 B보다 큰 쌍의 개수
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) A[n] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(A);
			
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++)
				count(Integer.parseInt(st.nextToken()));
			
			System.out.println(cnt);
		}
	}
	
	public static void count(int sizeB) {
		int min = 0;
		int max = N-1;
		
		while(max >= min) {
			int mid = (min+max) / 2;
			
			if(A[mid] > sizeB) {
				cnt += max - mid + 1;
				max = mid - 1;
			} else
				min = mid + 1;
		}
	}
}
