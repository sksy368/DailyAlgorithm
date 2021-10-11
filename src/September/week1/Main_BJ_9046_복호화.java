package September.week1;

import java.util.*;
import java.io.*;

public class Main_BJ_9046_복호화 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스

		for(int t = 0; t < T; t++) {
			String str = br.readLine();
			int[] cnt = new int[26];
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == ' ') continue;
				
				cnt[str.charAt(i) - 'a']++;
			}
			
			int[] temp = cnt.clone();
			Arrays.sort(temp);
			
			if(temp[temp.length-1] == temp[temp.length-2]) System.out.println("?");
			else {
				int max = 0, idx = 0;
				for(int i = 0; i < cnt.length; i++) {
					if(max < cnt[i]) {
						max = cnt[i];
						idx = i;
					}
				}
				System.out.println((char)(idx + 'a'));
			}
		}
	}
}

