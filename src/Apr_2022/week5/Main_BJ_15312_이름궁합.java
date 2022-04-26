package Apr_2022.week5;

import java.io.*;
import java.util.*;

public class Main_BJ_15312_이름궁합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] num = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
		
		String A = br.readLine(); // 종민이의 영어 이름
		String B = br.readLine(); // 그녀의 영어 이름
		
		String comp = "";
		
		for(int i = 0; i < A.length(); i++) {
			comp += num[A.charAt(i)-'A'];
			comp += num[B.charAt(i)-'A'];
		}
		
		while(comp.length() > 2) {
			String temp = "";
			int before = Integer.parseInt(comp.charAt(0)+"");
			
			for(int i = 1; i < comp.length(); i++) {
				int now = Integer.parseInt(comp.charAt(i)+"");
				
				temp += ((before+now)%10);
				
				before = now;
			}
			
			comp = temp;
		}
		
		System.out.println(comp);
	}
}
