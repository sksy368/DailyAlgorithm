package Mar_2022.week3;

import java.util.*;
import java.io.*;

public class Solution_SW_임시SW역량테스트_1 {

	static class Thing {
		int row, column;

		public Thing(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}

	static int N, answer;
	static int[][] map;
	static ArrayList<Thing> things;
	static int[] output;
	static boolean[] checked;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 맵의 길이
			map = new int[N][N];
			things = new ArrayList<>();
			answer = Integer.MAX_VALUE;

			for (int n1 = 0; n1 < N; n1++) {
				st = new StringTokenizer(br.readLine());

				for (int n2 = 0; n2 < N; n2++) {
					map[n1][n2] = Integer.parseInt(st.nextToken());

					if (map[n1][n2] != 0) {
						things.add(new Thing(n1, n2));
					}
				}
			}

			output = new int[things.size()];
			checked = new boolean[things.size()];
			permutation(0);

			System.out.println("#" + t + " " + answer);
		}

	}

	public static void permutation(int n) { // 순열
		if (n == things.size()) {
			findDist();
			return;
		}

		for (int i = 0; i < things.size(); i++) {
			if (checked[i])
				continue;

			output[n] = i;
			checked[i] = true;
			permutation(n + 1);
			checked[i] = false;
		}
	}

	public static void findDist() { // 거리 계산
		HashSet<Integer> finish = new HashSet<>();
		int curR = 0;
		int curC = 0;
		int sum = 0;

		for (int i = 0; i < things.size(); i++) {
			Thing cur = things.get(output[i]);

			if (map[cur.row][cur.column] > 0) // 몬스터인 경우
				finish.add(map[cur.row][cur.column]);
			else // 고객인 경우
			if (!finish.contains(Math.abs(map[cur.row][cur.column])))
				return; // 몬스터가 잡히지 않았는데 고객에게 간 경우

			sum += Math.abs(curR - cur.row) + Math.abs(curC - cur.column); // 거리합 갱신
			curR = cur.row; // 위치 이동
			curC = cur.column; // 위치 이동
		}

		answer = Math.min(answer, sum);
	}
}
