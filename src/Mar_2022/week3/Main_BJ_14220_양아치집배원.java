package Mar_2022.week3;

import java.util.*;
import java.io.*;

public class Main_BJ_14220_양아치집배원 {

	static class Road {
		int dest, len;

		Road(int dest, int len) {
			this.dest = dest;
			this.len = len;
		}
	}

	static int N, min;
	static ArrayList<Road>[] adjList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 방문한 도시 수
		adjList = new ArrayList[N];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++)
			adjList[i] = new ArrayList<>();

		for (int n1 = 0; n1 < N; n1++) {
			st = new StringTokenizer(br.readLine());

			for (int n2 = 0; n2 < N; n2++) {
				int len = Integer.parseInt(st.nextToken());

				if (len != 0)
					adjList[n1].add(new Road(n2, len));
			}
		}

		for (int n = 0; n < N; n++) {
			HashSet<Integer> set = new HashSet<Integer>();
			set.add(n);
			dfs(n, 0, set);
		}

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	static public void dfs(int start, int sum, HashSet<Integer> set) {
		if (set.size() == N) {
			min = Math.min(min, sum);
			return;
		}
		
		if(min <= sum) return;

		for (Road next : adjList[start]) {
			HashSet<Integer> newSet = new HashSet<>();
			newSet.addAll(set);
			newSet.add(next.dest);

			dfs(next.dest, sum + next.len, newSet);
		}
	}
}