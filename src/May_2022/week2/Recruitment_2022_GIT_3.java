package May_2022.week2;

import java.io.*;
import java.util.*;

public class Recruitment_2022_GIT_3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, ",");
		
		String B = st.nextToken();
		String A = st.nextToken();
		
		while(A.contains(B)) { // A에 B가 있는 경우
			A = A.replace(B, ""); // B 제외
		}
		
		boolean flag = false;
		
		for(int i = 0; i < A.length(); i++) {
			A = A.substring(1) + A.charAt(0); // 맨 앞 문자를 뒤에 붙인 경우
			if(A.equals(B)) { // A와 B가 같은 경우
				flag = true;
				break;
			}
		}
		
		System.out.println(flag);
	}
}
