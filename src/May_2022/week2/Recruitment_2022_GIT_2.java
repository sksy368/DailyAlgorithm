package May_2022.week2;

import java.io.*;
import java.util.*;

public class Recruitment_2022_GIT_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, "$");
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		int cnt = 0;
		
		while(A.contains(B)) { // A에 B가 포함되어 있는 경우
			
			int idx = A.indexOf(B); // B가 있는 인덱스 위치
			
			for(int i = 0; i < B.length(); i++)
				A = A.substring(0, idx) + A.substring(idx+1); // B에서 A 부분 제외
			
			cnt++; // 개수 추가
		}
		
		System.out.println(cnt + " " + A);
	}
}
