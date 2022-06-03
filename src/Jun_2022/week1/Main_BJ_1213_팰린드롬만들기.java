package Jun_2022.week1;

import java.io.*;
import java.util.Arrays;

public class Main_BJ_1213_팰린드롬만들기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name = br.readLine(); // 임한수의 영어 이름
		char[] answer = new char[name.length()];
		int[] num = new int[26];
		int idx = 0;
		
		for(int i = 0; i < name.length(); i++) num[name.charAt(i)-'A']++;
		
		for(int i = 0; i < 26; i++) {
			if(idx >= answer.length/2) break;
			
			if(num[i] == 0) continue;
			else if(num[i] % 2 != 0) {
				System.out.println("I'm Sorry Hansoo");
				System.exit(0);
			}
			while(num[i]-- > 0) {
				if(num[i] % 2 == 0) answer[idx] = (char)(i+'A');
				else answer[answer.length-1-idx] = (char)(i+'A');
				idx++;
				
			}
		}
		
		for(char c : answer) System.out.print(c);
	}
}
