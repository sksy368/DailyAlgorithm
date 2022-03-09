package Mar_2022.week2;

import java.util.*;
import java.io.*;

public class Main_BJ_1953_팀배분 {
	
	static int N;
	static ArrayList<Integer>[] adjList;
	static ArrayList<Integer> blue, white;
	static boolean[] checked;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 학생 수
		
		adjList = new ArrayList[N+1];
		for(int n = 1; n <= N; n++) adjList[n] = new ArrayList<>();
		
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int hate = Integer.parseInt(st.nextToken()); // 싫어하는 사람 수
			
			for(int h = 0; h < hate; h++) adjList[n].add(Integer.parseInt(st.nextToken()));
		}
		
		blue = new ArrayList<Integer>();
		white = new ArrayList<Integer>();
		checked = new boolean[N+1];
		
		for(int n = 1; n <= N; n++) {
			if(!checked[n]) {
				checked[n] = true;
				dfs(n, true);
			}
		}
		
		System.out.println(blue.size());
		Collections.sort(blue); // 오름차순 정렬
		for(int b : blue) System.out.print(b + " ");
		System.out.println("\n" + white.size());
		Collections.sort(white); // 오름차순 정렬
		for(int w : white) System.out.print(w + " ");
	}
	
	public static void dfs(int now, boolean isBlue) {
		if(isBlue) blue.add(now);
		else white.add(now);
		
		for(int next : adjList[now]) { // next: now가 싫어하는 사람
			if(!checked[next]) {
				checked[next] = true;
				dfs(next, isBlue?false:true); // now와 next는 반대팀
			}
		}
	}
}