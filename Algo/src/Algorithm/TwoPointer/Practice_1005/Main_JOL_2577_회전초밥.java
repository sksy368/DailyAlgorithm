package Algorithm.TwoPointer.Practice_1005;

import java.util.*;
import java.io.*;

public class Main_JOL_2577_회전초밥 {
	
	static int N, d, k, c;
	static int[] sushi;
	static HashSet<Integer> eat;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 접시의 수
		d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		sushi = new int[d];
		for(int i = 0; i < d; i++)
			sushi[i] = Integer.parseInt(br.readLine());
		
		eat = new HashSet<>();
		
		for(int i = 0; i < N; i++) { // i : 연속해서 먹을 첫번째 초밥
			for(int j = i; j < i+k; j++)
				eat.add(sushi[j]);
			
			if(eat.size() == k)
		}
	}

}
