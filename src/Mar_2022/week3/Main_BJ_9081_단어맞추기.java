package Mar_2022.week3;

import java.io.*;
import java.util.*;

public class Main_BJ_9081_단어맞추기 {
	
	static String word;
	static char[] wordArr;
	static int[] output;
	static boolean[] checked;
	static String answer;
	static char[] answerArr;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			word = br.readLine();
			wordArr = word.toCharArray();
			
			checked = new boolean[wordArr.length];
			output = new int[wordArr.length];
			answerArr = new char[wordArr.length];
			answer = "";
			
			Arrays.fill(answerArr, 'Z');
			
			permutation(0);
			
			if(answer.equals("")) System.out.println(word);
			System.out.println(answer);
		}
	}
	
	public static void permutation(int n) {
		if(n == wordArr.length) {
			compare();
			return;
		}
		
		for(int i = 0; i < wordArr.length; i++) {
			if(checked[i]) continue;
			checked[i] = true;
			
			output[n] = i;
			permutation(n+1);
			checked[i] = false;
		}
	}
	
	public static void compare() {
		String result = "";
		char[] resultArr = new char[wordArr.length];
		boolean flag = false;
		
		for(int i = 0; i < wordArr.length; i++) {
			if(wordArr[i]<wordArr[output[i]]) flag = true;
			if(wordArr[output[i]]>answerArr[i]) return;
			
			result += wordArr[output[i]];
			resultArr[i] = wordArr[output[i]];
		}
		
		if(flag) {
			answerArr = resultArr;
			answer = result;
		}
		
	}
}
