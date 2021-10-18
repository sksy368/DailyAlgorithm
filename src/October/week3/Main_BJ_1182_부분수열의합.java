package October.week3;

import java.util.*;
import java.io.*;

public class Main_BJ_1182_부분수열의합 {
	
	static int N, S, ans;
	static int[] nums;
	static boolean[] checked;
	
	private static void subSet(int cnt) {
		if(cnt == N) {
			int sum = 0;
			
			for(int i = 0; i < nums.length; i++) {
				if(checked[i])
					sum += nums[i];
			}
			
			if(sum == S) ans++;
			
			return;
		}
			
		checked[cnt] = true;
		subSet(cnt+1);
		checked[cnt] = false;
		subSet(cnt+1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //정수의 개수
		S = Integer.parseInt(st.nextToken()); //정수
		ans = 0;
		
		nums = new int[N];
		checked = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		subSet(0);
		
		System.out.println(S==0?ans-1:ans);
	}
}