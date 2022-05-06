package May_2022.week1;

import java.util.*;
import java.io.*;

public class Main_BJ_5052_전화번호목록 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine()); // 전화번호 수
			
			PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
				public int compare(String s1, String s2) {
					for(int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
						if(s1.charAt(i) != s2.charAt(i)) return s1.charAt(i)-s2.charAt(i);
					}
					return s1.length()-s2.length();
				}
			});
			
			for(int n = 0; n < N; n++) pq.offer(br.readLine());
			
			boolean flag = false;
			String s1 = pq.poll();
			while(!pq.isEmpty()) {
				String s2 = pq.poll();
				
				if(s1.length()<=s2.length() && s1.equals(s2.substring(0, s1.length()))) {
					flag = true;
					break;
				}
				
				s1 = s2;
			}
			
			if(flag) System.out.println("NO");
			else System.out.println("YES");
		}
	}
}