package Implemention.com.ssafy.Practice_1006;

import java.util.*;
import java.io.*;

public class Solution_SWEA_4014_활주로건설 {
	
	static int N, X, cnt;
	static int[][] map;
	
	private static boolean checkOneSide(int[] arr, int i, int length) { 
		if(i-length >= 0 && arr[i-length] > arr[i]) { // 왼쪽에 설치해야 하는 경우
			if(X > length || Math.abs(arr[i-length] - arr[i]) > 1) return false; // 경사로의 길이가 평지보다 길거나 높이 차이가 1 보다 큰 경우
		}
		else if(i+1 < N && arr[i+1] > arr[i]) { // 오른쪽에 설치해야 하는 경우
			if(X > length || Math.abs(arr[i+1] - arr[i]) > 1) return false; // 경사로의 길이가 평지보다 길거나 높이 차이가 1 보다 큰 경우
		}
		return true;
	}
	
	private static boolean checkBothSides(int[] arr, int i, int length) { // 양쪽에 설치해야 하는 경우
		if(i-length >= 0 && arr[i-length] > arr[i] && i+1 < N && arr[i+1] > arr[i]) {
			if(X*2 > length ||  Math.abs(arr[i-length] - arr[i]) > 1 ||  Math.abs(arr[i+1] - arr[i]) > 1) // 경사로 두 개의 길이가 평지보다 길거나 높이 차이가 1보다 큰 경우
				return false;
		}
		return true;
	}
	
	
	private static boolean isPossible(int[] arr) {
		int length = 1; // 평지의 길이
		
		for(int i = 0; i < N; i++) {
			if(i == N-1) { // 마지막 지형인 경우
				if((length > 1 && !checkOneSide(arr, i, length)) || (arr[i] < arr[i-1])) return false; // 평지 길이가 1 보다 크고 왼쪽에 설치해야 하는데 할 수 없거나 이전 지형보다 낮은 경우
				else break;
			}
			
			if(arr[i] == arr[i+1]) { // 평지인 경우(이전 지형과 높이가 같은 경우)
				length++;
				continue;
			}
			
			if(!checkBothSides(arr, i, length) || !checkOneSide(arr, i, length)) return false;
			
			length = 1; // 경사로를 설치했기 때문에 다른 평지를 확인하고자 1로 초기화
		}
		
		return true;
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지도의 한 변의 크기
			X = Integer.parseInt(st.nextToken()); // 경사로의 길이
			
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			cnt = 0;
			int[] arr = new int[N];
			
			for(int i = 0; i < N; i++) {
				if(isPossible(map[i])) // 특정 행의 가능 여부 판단
					cnt++; 
				
				for(int j = 0; j < N; j++)
					arr[j] = map[j][i];
				if(isPossible(arr)) // 특정 열의 가능 여부 판단
					cnt++;
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}