package Algorithm.DivideConquer.Practice_0818;

import java.util.*;
import java.io.*;

public class Main_BJ_17829_222풀링 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		divide(arr);
	}
	
	public static void divide(int[][] arr) {
		int newSize = arr.length/2;
		
		if(newSize == 0) {
			System.out.println(arr[0][0]);
			return;
		}
		
		int[][] newArr = new int[newSize][newSize];
		
		for(int i = 0; i < newSize; i++) {
			for(int j = 0; j < newSize; j++) {
				newArr[i][j] = findSecond(arr, i*2, j*2);
			}
		}
		
		divide(newArr);
	}
	
	public static int findSecond(int[][] arr, int startR, int startC) {
		int[] tmp = new int[4];
		
		tmp[0] = arr[startR][startC];
		tmp[1] = arr[startR][startC+1];
		tmp[2] = arr[startR+1][startC];
		tmp[3] = arr[startR+1][startC+1];
		
		Arrays.sort(tmp);
		
		return tmp[2];
	}
}
