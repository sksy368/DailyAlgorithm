package October.week2;

import java.io.*;

public class Main_BJ_1032_명령프롬프트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 파일의 개수
		String[] names = new String[N];
		String same = "";
		
		for(int i = 0; i < N; i++) {
			names[i] = br.readLine(); // 파일 이름
			
			if(i == 0) {
				same = names[i];
				continue;
			}
			
			for(int j = 0; j < names[i].length(); j++) {
				if(same.charAt(j) != names[i].charAt(j))
					same = same.substring(0, j) + "?" + same.substring(j+1, same.length());
			}
		}
		
		System.out.println(same);
	}
}