package BruteForce.com.ssafy.Practice_0812;

import java.util.*;
import java.io.*;

public class Main_BJ_2961_도영이가만든맛있는음식 {
	
	private static int N;
	private static int[][] material;
	private static boolean[] isSelected;
	private static int min;
	
	public static void powerSet(int cnt) {
		if(cnt == N){
			boolean check = false; // 재료를 사용했는지 여부 확인
			for(int i = 0; i < isSelected.length; i++) {
				if(isSelected[i]) {
					check = true;
					break;
				}
			}
			if(check) // 재료가 적어도 하나 있는 경우
				taste();
			return;
		}
		
		isSelected[cnt] = true;
		powerSet(cnt + 1);
		
		isSelected[cnt] = false;
		powerSet(cnt + 1);
	}
	
	public static void taste() {
		int sour = 1; // 신 맛
		int bitter = 0; //쓴 맛
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) {
				sour *= material[i][0];
				bitter += material[i][1];
			}
		}
		
		min = Math.min(min, (int)(Math.abs(sour-bitter)));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		material = new int[N][2];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			material[n][0] = Integer.parseInt(st.nextToken()); // 재료의 신 맛
			material[n][1] = Integer.parseInt(st.nextToken()); // 재료의 쓴 맛
		}
		
		min = Integer.MAX_VALUE;
		isSelected = new boolean[N];
		powerSet(0);
		System.out.println(min);
	}
}