package Oct_2021.week3;

import java.io.*;

public class Main_BJ_2661_좋은수열 {
	
	static int N;
	
	private static boolean check(String num) {
		if(num.length() == 1) return true;
		
		int cut = (num.length() + 1) / 2;
		
		for(int i = cut; i < num.length(); i++) {
			String num2 = num.substring(i);
			String num1 = num.substring(i-num2.length(), i);
			
			if(num2.equals(num1)) return false;
		}
		
		return true;
	}
	
	private static void sequence(String num) {
		if(num.length() == N) {
			if(check(num)) {
				System.out.println(num);
				System.exit(0);
			}
			return;
		}
		
		for(int i = 1; i <= 3; i++) {
			if(check(num + i))
				sequence(num + i);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 수열의 길이
		
		sequence("");
	}
}