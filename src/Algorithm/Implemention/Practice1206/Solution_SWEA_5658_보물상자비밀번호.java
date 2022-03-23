package Algorithm.Implemention.Practice1206;

import java.io.*;
import java.util.*;

public class Solution_SWEA_5658_보물상자비밀번호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 숫자의 개수
			int K = Integer.parseInt(st.nextToken()); // 크기 순서
			
			String s = br.readLine();
			ArrayList<Character> al = new ArrayList<>();
			HashSet<String> hs = new HashSet<>();
			
			for(int i = 0; i < N; i++) al.add(s.charAt(i));
			
			for(int i = 0; i < N/4; i++) {
				String s1 = "", s2 = "", s3 = "", s4 = "";
				
				for(int j = 0; j < N/4; j++) {
					s1 += al.get(j);
					s2 += al.get(j+N*1/4);
					s3 += al.get(j+N*2/4);
					s4 += al.get(j+N*3/4);
				}
				
				hs.add(s1);
				hs.add(s2);
				hs.add(s3);
				hs.add(s4);
				
				// 시계방향으로 회전
				al.add(0, al.get(N-1));
				al.remove(N);
			}
			
			TreeSet<String> ts = new TreeSet<>();
			ts.addAll(hs);
			Object[] nums = ts.toArray();
			
			System.out.println("#" + t + " " + Integer.parseInt((String) nums[ts.size()-K], 16)); // 16진수를 10진수로 변환
		}
	}
}
