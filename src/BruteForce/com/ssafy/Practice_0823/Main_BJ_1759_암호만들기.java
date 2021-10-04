package BruteForce.com.ssafy.Practice_0823;

import java.util.*;
import java.io.*;

public class Main_BJ_1759_암호만들기 {
	
	static int L, C;
	static char[] alphabet, result;
	
	public static boolean isPossible(String s) {
		int consonant = 0; // 자음 개수
		int vowel = 0; // 모음 개수
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
				vowel++;
			else
				consonant++;
		}
		
		if(consonant >= 2 && vowel >= 1) // 자음이 2개 이상, 모음이 1개 이상인 경우
			return true;
		else
			return false;
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == L) {
			String s = "";
			
			for(char i : result) s += i;
			
			if(isPossible(s)) System.out.println(s);
			
			return;
		}
		
		for(int i = start; i < C; i++) {
			result[cnt] = alphabet[i];
			combination(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken()); // 암호 길이
		C = Integer.parseInt(st.nextToken()); // 문자 종류
		
		alphabet = new char[C];
		result = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int c = 0; c < C; c++)
			alphabet[c] = st.nextToken().charAt(0);
		
		Arrays.sort(alphabet);
		
		combination(0, 0);
	}

}
