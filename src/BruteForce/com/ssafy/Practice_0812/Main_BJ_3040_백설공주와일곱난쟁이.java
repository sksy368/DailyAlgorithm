package BruteForce.com.ssafy.Practice_0812;

import java.util.*;
import java.io.*;

public class Main_BJ_3040_백설공주와일곱난쟁이 {
	
	static int[] input;
	static int[] result;
	
	private static void combination(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++)
				sum += result[i];
			
			if(sum == 100) {
				for(int i = 0; i < 7; i++)
					System.out.println(result[i]);
			}
			return;
		}
		
		for(int i = start; i < 9; i++) {
			result[cnt] = input[i];
			combination(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = new int[9];
		result = new int[7];
		
		for(int i = 0; i < 9; i++) // 난쟁이가 쓴 모자에 있는 수
			input[i] = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

		combination(0,0);
	}
}