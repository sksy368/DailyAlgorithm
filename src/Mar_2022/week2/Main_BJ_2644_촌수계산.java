package Mar_2022.week2;

import java.util.*;
import java.io.*;

public class Main_BJ_2644_촌수계산 {
	
	static int N, person1, person2, ans;
	static ArrayList<Integer>[] family;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 사람 수
		ans = 0; // 촌수
		
		st = new StringTokenizer(br.readLine());
		person1 = Integer.parseInt(st.nextToken()); // 사람1
		person2 = Integer.parseInt(st.nextToken()); // 사람2
		
		family = new ArrayList[N+1];
		
		for(int n = 1; n <= N; n++) family[n] = new ArrayList<>(); // 선언 및 초기화
		
		int M = Integer.parseInt(br.readLine());
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			
			family[p1].add(p2);
			family[p2].add(p1);
		}
		
		boolean[] checked = new boolean[N+1];
		checked[person1] = true;
		
		dfs(person1, checked, 0);
		
		System.out.println(ans==0 ? -1 : ans);
	}
	
	public static void dfs(int curPerson, boolean[] checked, int cnt) {
		if(curPerson == person2) {
			ans = cnt;
			return;
		}
		
		for(int nextPerson : family[curPerson]) {
			if(!checked[nextPerson]) {
				checked[nextPerson] = true;
				dfs(nextPerson, checked, cnt+1);
			}
		}
	}
}
