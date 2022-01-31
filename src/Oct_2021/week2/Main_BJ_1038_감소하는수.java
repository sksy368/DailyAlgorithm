package October.week2;

import java.io.*;
import java.util.*;

public class Main_BJ_1038_감소하는수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Long> list = new ArrayList<>(); // 감소하는 수를 넣을 리스트
		String num = "1"; // 1이 1번째 감소하는 수
		
		while(true) {
			if(list.size() == N) break; // 리스트에 감소하는 수가 N만큼 있는 경우
			else if("9876543210".equals(num)) {
				list.add(Long.parseLong(num));
				break;
			}
			
			boolean flag = true;
			
			for(int i = 0; i < num.length(); i++) {
				if(i+1 < num.length() && Integer.parseInt(num.charAt(i)+"") <= Integer.parseInt(num.charAt(i+1)+"")) {
					flag = false;
					break;
				}
			}
			
			if(flag) list.add(Long.parseLong(num));
			
			num = (Long.parseLong(num) + 1) + ""; // 숫자 증가
		}
		
		if(list.size() != N)
			System.out.println(-1);
		else
			System.out.println(list.get(list.size()-1));
	}
}