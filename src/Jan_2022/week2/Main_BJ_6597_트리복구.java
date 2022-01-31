package Jan_2022.week2;

import java.util.*;
import java.io.*;

public class Main_BJ_6597_트리복구 {
	
	static String pre, in, answer;
	static LinkedList<String> inStrings;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			try {
				st = new StringTokenizer(br.readLine());
				
				pre = st.nextToken(); // 프리오더로 순회한 결과
				in = st.nextToken(); // 인오더로 순회한 결과
			} catch(NullPointerException e) {
				break;
			}
			
			if("".equals(pre)) break;
			
			answer = "";
			inStrings = new LinkedList<String>();
			inStrings.add(in);
			
			inOrder(pre.charAt(0));
			
			System.out.println(answer);
		}
	}
	
	public static void inOrder(char standard) {
		String target = inStrings.get(0);
		
		int i = 0;
		while(i < target.length()) {
			if(target.charAt(i++) == standard)
				break;
		}
		
		String left = target.substring(0, i-1);
		String right = target.substring(i);
		
		inStrings.remove(0);
		inStrings.add(0, left);
		inStrings.add(1, right);
		
		// 포스트오더
		preOrder(left);
		preOrder(right);
		answer += standard;
	}
	
	public static void preOrder(String standard) {
		if(standard.length() <= 1) {
			answer += standard;
			inStrings.remove(0);
			return;
		}
		
		String target = "";
				
		int i = 0;
		while(i < pre.length()) {
			char c = pre.charAt(i);
			if(standard.contains(c+""))
				target += c;
			i++;
		}
		
		inOrder(target.charAt(0));
	}
}