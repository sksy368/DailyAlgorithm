package Apr_2022.week3;

import java.io.*;

public class Main_BJ_24524_아름다운문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
		
		int[] tIdxNum = new int[T.length()];
		int cnt = 0;
		
		for(int s = 0; s < S.length(); s++) {
			char c = S.charAt(s);
			
			if(T.indexOf(c) == -1) // T에 없는 문자인 경우
				continue;
			else if(T.indexOf(c) == 0 || tIdxNum[T.indexOf(c)]<tIdxNum[T.indexOf(c)-1]) { // T의 첫문자이거나 이전 문자의 개수가 많을 경우
				tIdxNum[T.indexOf(c)]++; 
				
				if(T.indexOf(c) == T.length()-1) // T의 마지막 문자인 경우
					cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}