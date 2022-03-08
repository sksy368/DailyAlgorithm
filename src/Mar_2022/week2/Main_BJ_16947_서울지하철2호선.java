package Mar_2022.week2;

import java.io.*;
import java.util.*;

public class Main_BJ_16947_서울지하철2호선 {
	
	static int N;
	static ArrayList<Integer>[] subway;
	static int[] dist;
	static boolean[] isCycle;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		subway = new ArrayList[N+1];
		dist = new int[N+1];
		isCycle = new boolean[N+1];
		
		for(int n = 1; n <= N; n++) subway[n] = new ArrayList<>(); // 선언
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			
			subway[s1].add(s2);
			subway[s2].add(s1);
		}
		
	}
	
	public static void findCycle() {
		
	}

}
