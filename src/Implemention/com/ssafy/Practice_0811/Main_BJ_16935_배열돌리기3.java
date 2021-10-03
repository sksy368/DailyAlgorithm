package Implemention.com.ssafy.Practice_0811;

import java.util.*;
import java.io.*;

public class Main_BJ_16935_배열돌리기3 {
	
	static int N, M, R;
	static int[][] arr;
	
	public static void calOne() { // 1번 : 배열을 상하 반전시키는 연산
		for(int i = 0; i < arr.length/2; i++) {
			int[] temp = arr[i].clone();
			arr[i] = arr[arr.length-i-1].clone();
			arr[arr.length-i-1] = temp;
		}
	}
	
	public static void calTwo() { // 2번 : 배열을 좌우 반전시키는 연산
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][arr[0].length-j-1];
				arr[i][arr[0].length-j-1] = temp;
			}
		}
	}
	
	public static void calThree() { // 3번 : 배열을 오른쪽으로 90도 회전시키는 연산
		int[][] rotate = new int[arr[0].length][arr.length];
		
		for(int i = 0; i < arr[0].length; i++) {
			for(int j = 0; j < arr.length; j++)
				rotate[i][j] = arr[arr.length-j-1][i];
		}
		
		arr = rotate;
	}
	
	public static void calFour() { // 4번 : 배열을 왼쪽으로 90도 회전시키는 연산
		int[][] rotate = new int[arr[0].length][arr.length];
		
		for(int i = 0; i < arr[0].length; i++) {
			for(int j = 0; j < arr.length; j++)
				rotate[i][j] = arr[j][arr[0].length-i-1];
		}
		
		arr = rotate;
	}
	
	public static void calFive() { // 5번 : 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동시키는 연산
		int[][] areaOne = new int[arr.length/2][arr[0].length/2];
		int[][] areaTwo = new int[arr.length/2][arr[0].length/2];
		int[][] areaThree = new int[arr.length/2][arr[0].length/2];
		int[][] areaFour = new int[arr.length/2][arr[0].length/2];
		
		for(int i = 0; i < arr.length/2; i++) {
			for(int j = 0; j < arr[0].length/2; j++) {
				areaOne[i][j] = arr[i][j];
				areaTwo[i][j] = arr[i][j+arr[0].length/2];
				areaThree[i][j] = arr[i+arr.length/2][j+arr[0].length/2];
				areaFour[i][j] = arr[i+arr.length/2][j];
			}
		}
		
		for(int i = 0; i < arr.length/2; i++) {
			for(int j = 0; j < arr[0].length/2; j++) {
				arr[i][j] = areaFour[i][j];
				arr[i][j+arr[0].length/2] = areaOne[i][j];
				arr[i+arr.length/2][j+arr[0].length/2] = areaTwo[i][j];
				arr[i+arr.length/2][j] = areaThree[i][j];
			}
		}
	}
	
	public static void calSix() { // 6번 : 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동시키는 연산
		int[][] areaOne = new int[arr.length/2][arr[0].length/2];
		int[][] areaTwo = new int[arr.length/2][arr[0].length/2];
		int[][] areaThree = new int[arr.length/2][arr[0].length/2];
		int[][] areaFour = new int[arr.length/2][arr[0].length/2];
		
		for(int i = 0; i < arr.length/2; i++) {
			for(int j = 0; j < arr[0].length/2; j++) {
				areaOne[i][j] = arr[i][j];
				areaTwo[i][j] = arr[i][j+arr[0].length/2];
				areaThree[i][j] = arr[i+arr.length/2][j+arr[0].length/2];
				areaFour[i][j] = arr[i+arr.length/2][j];
			}
		}
		
		for(int i = 0; i < arr.length/2; i++) {
			for(int j = 0; j < arr[0].length/2; j++) {
				arr[i][j] = areaTwo[i][j];
				arr[i][j+arr[0].length/2] = areaThree[i][j];
				arr[i+arr.length/2][j+arr[0].length/2] = areaFour[i][j];
				arr[i+arr.length/2][j] = areaOne[i][j];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 배열의 크기(행)
		M = Integer.parseInt(st.nextToken()); // 배열의 크기(열)
		R = Integer.parseInt(st.nextToken()); // 수행해야 하는 연산의 수
		
		arr = new int[N][M];
		for(int n = 0; n < N; n++) { // 배열의 원소 입력
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++)	arr[n][m] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()); // 수행해야 하는 연산
		while(st.hasMoreTokens()) {
			switch(st.nextToken()) {
				case "1":
					calOne();
					break;
				case "2":
					calTwo();
					break;
				case "3":
					calThree();
					break;
				case "4":
					calFour();
					break;
				case "5":
					calFive();
					break;
				case "6":
					calSix();
					break;
			}
		}
		
		for(int i = 0; i < arr.length; i++) { // 배열의 원소 출력
			for(int j = 0; j < arr[i].length; j++)	System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
}
