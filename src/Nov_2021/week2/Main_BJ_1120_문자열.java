package Nov_2021.week2;

import java.io.*;
import java.util.*;

public class Main_BJ_1120_문자열 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String word1 = st.nextToken();
		String word2 = st.nextToken() + " ";
		
		int num = word2.length() - word1.length(); // 비교 횟수 = 두 문자열 길이의 차
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < num; i++) {
			String temp = word2.substring(i, i+word1.length());
			
			int sum = 0;
			for(int j = 0; j < word1.length(); j++) {
				if(word1.charAt(j) != temp.charAt(j))
					sum++;
			}
			
			min = Math.min(sum, min);
		}
		
		System.out.println(min);
	}
}