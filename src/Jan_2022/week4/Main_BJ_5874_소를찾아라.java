package Jan_2022.week4;

import java.io.*;

public class Main_BJ_5874_소를찾아라 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String grass = br.readLine();
	
		int cnt = 0;
		int hindLegs = 0; // 뒷다리 개수
		
		for(int i = 0; i < grass.length()-1; i++) {
			if(grass.charAt(i) == '(' && grass.charAt(i+1) == '(') // 뒷다리인 경우
				hindLegs++;
			if(grass.charAt(i) == ')' && grass.charAt(i+1) == ')') // 앞다리인 경우
				cnt += hindLegs;
		}
		
		System.out.println(cnt);
	}
}