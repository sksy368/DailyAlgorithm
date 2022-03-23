package Algorithm.Implemention.Practice_0811;

import java.util.*;
import java.io.*;

public class Main_BJ_17406_배열돌리기4 {
	
	static class Cal {
		int r, c, s;
		Cal(int r, int c, int s){
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	
	private static int[][] arr;
	private static int[][] copyArr;
	private static Cal[] op;
	private static int min;
	
	private static boolean[] isSelected;
	private static int[] opSeq;
	
	public static void permutation(int cnt) {
		if(cnt == isSelected.length) {
			copyArr = new int[arr.length][arr[0].length];
			for(int i = 0; i < arr.length; i++)
				copyArr[i] = arr[i].clone();

			for(int i = 0; i < cnt; i++) {
				int r = op[opSeq[i]].r;
				int c = op[opSeq[i]].c;
				int s = op[opSeq[i]].s;
				
				rotate(r-s, c-s, r+s, c+s);
			}
            
			minSum();
			return;
		}
			
		for(int i = 0; i < isSelected.length; i++) {
			if(isSelected[i])	continue;
			
			opSeq[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
	
	
	public static void rotate(int startR, int startC, int endR, int endC) {
		int count = Math.min(endR - startR + 1, endC - startC + 1) / 2; // 회전하는 라인 개수

		for(int i = 0; i < count; i++) {
			int temp = copyArr[startR + i][startC + i];
				
			for(int j = startR+i; j < endR-i; j++)	copyArr[j][startC+i] = copyArr[j+1][startC+i]; //라인의 왼쪽 부분
			for(int j = startC+i; j < endC-i; j++)	copyArr[endR-i][j] = copyArr[endR-i][j+1]; // 라인의 아래쪽 부분
			for(int j = endR-i; j > startR+i ;j--)	copyArr[j][endC-i] = copyArr[j-1][endC-i]; // 라인의 오른쪽 부분
			for(int j = endC-i; j > startC+i+1; j--) copyArr[startR+i][j] = copyArr[startR+i][j-1]; // 라인의 위쪽 부분
			
			copyArr[startR + i][startC + i + 1] = temp;
		}
	}
	
	public static void minSum() {
		for(int i = 1; i < copyArr.length; i++) { // 최솟값 구하기
			int sum = 0;
			for(int j = 1; j < copyArr[i].length; j++)
				sum += copyArr[i][j];
			
			min = Math.min(sum,  min);
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 회전 연산 개수
		
		arr = new int[N + 1][M + 1];
		min = Integer.MAX_VALUE;
		
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 1; m <= M; m++)
				arr[n][m] = Integer.parseInt(st.nextToken());
		}
		
		op = new Cal[K];
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			op[k] = new Cal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		isSelected = new boolean[K];
		opSeq = new int[K];
		permutation(0);
		
		System.out.println(min);
	}
}