package Jan_2022.week2;

import java.io.*;

public class Main_BJ_1401_Cubeditor {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int max = 0;
		
		for(int s = 0; s < input.length(); s++) {
			char[] S = input.substring(s).toCharArray();
			int[] pi = new int[S.length];
			
			for(int i = 1, j = 0; i < S.length; i++) {
				while(j>0 && S[i]!=S[j])
					j = pi[j-1];
				
				if(S[i] == S[j]) pi[i] = ++j;
				else pi[i] = 0;
			}
			
			for(int i = 0; i < pi.length; i++)
				max = Math.max(pi[i], max);	
		}
		
		System.out.println(max);
	}
}