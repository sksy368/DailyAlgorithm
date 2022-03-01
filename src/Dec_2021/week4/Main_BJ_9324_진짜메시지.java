package Dec_2021.week4;

import java.util.*;
import java.io.*;

public class Main_BJ_9324_진짜메시지 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			String S = br.readLine();
			int[] num = new int[26];
			boolean flag = true;
			
			for(int s = 0; s < S.length(); s++) {
				num[S.charAt(s)-'A']++;
				
				if(num[S.charAt(s)-'A'] == 3) {
					if(s+1 >= S.length() || S.charAt(s+1) != S.charAt(s)) {
						flag = false;
						break;
					}
					else {
						num[S.charAt(s)-'A'] = 0;
						s++;
					}
				}
			}
			
			if(flag) System.out.println("OK");
			else System.out.println("FAKE");
		}
	}
}
