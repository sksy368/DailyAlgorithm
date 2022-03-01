package Jan_2022.week1;

import java.io.*;

public class Main_BJ_16916_부분문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] S = br.readLine().toCharArray(); // 문자열
		char[] P = br.readLine().toCharArray(); // 부분 문자열
		
		int lengthS = S.length;
		int lengthP = P.length;
		
		int[] table = new int[lengthP]; // 부분 일치 테이블
		
		for(int i=1, j=0; i<lengthP; i++) {
			while(j>0 && P[i]!=P[j])
				j = table[j-1];
			
			if(P[i] == P[j])
				table[i] = ++j;
			else
				table[i] = 0;
		}
		
		boolean flag = false;
		
		for(int i=0, j=0; i<lengthS; i++) {
			while(j>0 && S[i]!=P[j])
				j = table[j-1];
			
			if(S[i] == P[j]) {
				if(j == P.length-1) {
					flag = true;
					break;
				}
				else
					j++;
			}
		}
		
		if(flag) System.out.println(1);
		else System.out.println(0);
	}
}