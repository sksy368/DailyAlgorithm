package Dec_2021.week1;

import java.util.*;
import java.io.*;

public class Solution_SWEA_2383_점심시간 {
	
	static class Step {
		int r, c, l;
		public Step(int r, int c, int l) {
			super();
			this.r = r;
			this.c = c;
			this.l = l;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); // 방의 한 변의 길이
			ArrayList<int[]> person = new ArrayList<>(); // 사람들의 좌표
			ArrayList<Step> steps = new ArrayList<>(); // 계단들의 좌표&길이
			
			for(int n1 = 0; n1 < N; n1++) {
				st = new StringTokenizer(br.readLine());
				
				for(int n2 = 0; n2 < N; n2++) {
					int num = Integer.parseInt(st.nextToken()); // 1:사람, 2이상:계단의 길이
					
					if(num == 1) person.add(new int[] {n1, n2}); // 사람인 경우
					else if(num >= 2) steps.add(new Step(n1, n2, num)); // 계단인 경우
				}
			}
			
			ArrayList<Integer> dist1 = new ArrayList<>(); // 각 사람부터 계단1까지의 길이
			ArrayList<Integer> dist2 = new ArrayList<>(); // 각 사람부터 계단2까지의 길이
			
			char[][] D1 = new char[10][10]; // 계단1에 대한 TimeTable
			char[][] D2 = new char[10][10]; // 계단2에 대한 TimeTable
			// 'a':도착, 'w':대기, 's':계단 내려가는 중, 'f':이동 완료
			
			for(int i = 0; i < person.size(); i++) {
				int d1 = Math.abs(person.get(i)[0] - steps.get(0).r) + Math.abs(person.get(i)[1] - steps.get(0).c);
				int d2 = Math.abs(person.get(i)[0] - steps.get(1).r) + Math.abs(person.get(i)[1] - steps.get(1).c);
				
				if(d1 > d2) {
					dist2.add(d2);
					D2[d2][i] = 'a';
				}
				else {
					dist1.add(d1);
					D1[d1][i] = 'a';
				}
			}
			
			int time = 0;
			
			for(int i = 1; i < 10; i++) {
				for(int j = 0; j < dist1.size(); j++) {
					if(i-1 >= 0 && D1[i-1][j] == '\u0000') continue;
					
					if((i-1 >= 0 && D1[i-1][j] == 'f') || (i-steps.get(1).l >= 0 && D1[i-steps.get(1).l][j] == 's')) // '이동 완료'인 경우
						D1[i][j] = 'f';
					else if((i-1 >= 0 && D1[i-1][j] == 's' && i-steps.get(1).l >= 0 && D1[i-steps.get(1).l][j] != 's')) // '계단을 내려가는 중'인 경우(1)
						D1[i][j] = 's';
					else if(i-1 >= 0 && D1[i-1][j] == 'w') { // '계단을 내려가는 중'인 경우(2)
						if(j >= 3 && D1[i][j-3] == 's') D1[i][j] = 'w';
						else D1[i][j] = 's';
					}
					else // '대기'인 경우
						D1[i][j] = 'w';
				}
				
				if(D1[i][dist1.size()-1] == 'f') {
					System.out.println(i + "초 걸림!");
					time = Math.max(time, i);
					break;
				}
			}
			
			for(int i = 0; i < 10; i++) {
				System.out.print(i + "초: ");
				for(int j = 0; j < 10; j++)
					System.out.print("사람" + j + ":" + D1[i][j] + " ");
				System.out.println();
			}
			System.out.println("시간 : " + time);
		}
	}
}