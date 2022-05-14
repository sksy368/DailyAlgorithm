package May_2022.week2;

import java.io.*;
import java.util.*;

public class Recruitment_2022_GIT_4 {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String[] arr = input.split("],");
		
		if(arr.length < 3) System.out.println("Error"); // 3개 이하인 경우
		else {
			int cnt = 0; // 개수
			int sumMax = 0; // 합의 최대값
			String maxArr = ""; // 문자열
			HashSet<String> set = new HashSet<>();
			
			for(int i = 0; i < arr.length; i++) {
				arr[i] = arr[i].replace("[", "");
				arr[i] = arr[i].replace("]", "");
				
				if(set.contains(arr[i])) continue; // 이미 있는 문자열일 경우
				set.add(arr[i]);
				
				boolean flag = true;
				int sum = 0;
				String[] nums = arr[i].split(",");
				for(int j = 0; j < nums.length; j++) {
					int num = 0;
					try {
						num = Integer.parseInt(nums[j]);
					} catch(NumberFormatException e) { // 숫자가 아닌 문자인 경우
						flag = false;
						break;
					}
					sum += num; // 숫자의 합
				}
				
				if(flag) {
					cnt++; // 추가
					
					if(sum > sumMax) { // 합의 최대값인 경우
						sumMax = Math.max(sumMax, sum);
						maxArr = "[" + arr[i] + "]";
					}
				}
			}
			
			System.out.println(cnt + " / " + maxArr);
		}
	}
}
