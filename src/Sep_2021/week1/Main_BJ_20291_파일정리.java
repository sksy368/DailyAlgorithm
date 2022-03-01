package Sep_2021.week1;

import java.util.*;
import java.io.*;

public class Main_BJ_20291_파일정리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] extensions = new String[N];
		
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			extensions[n] = s.substring(s.indexOf('.')+1);
		}
		
		Arrays.sort(extensions);
		
		int cnt = 1;
		String s = extensions[0];
		for(int i = 1; i < N; i++) {
			if(s.equals(extensions[i])) cnt++;
			else {
				System.out.println(s + " " + cnt);
				s = extensions[i];
				cnt = 1;
			}
			if(i == N-1) System.out.println(s + " " + cnt);
		}
	}
}