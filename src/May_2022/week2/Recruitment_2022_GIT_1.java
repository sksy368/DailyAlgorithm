package May_2022.week2;

import java.io.*;
import java.util.*;

public class Recruitment_2022_GIT_1 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, ",");
		
		Set<Integer> nums = new HashSet<Integer>();
		int sum = 0;
		int cnt = 0;
		
		while(st.hasMoreTokens()) {
			char num = st.nextToken().charAt(0);
			
			if(num >= '0' && num <= '9') { // 숫자인 경우
				int beforeSize = nums.size();
				nums.add(Integer.parseInt(num+""));
				if(beforeSize != nums.size() && Integer.parseInt(num+"")%2!=0) { // 중복된 수가 아니고 홀수인 경우
					sum += Integer.parseInt(num+""); // 합 갱신
					cnt++; // 개수 추가
				}
			}
		}
		
		System.out.println(cnt + " " + sum);
	}
}
