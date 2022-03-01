package Dec_2021.week4;

import java.util.*;
import java.io.*;

public class Main_BJ_1302_베스트셀러 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 하루 동안 팔린 책의 개수
		
		HashMap<String, Integer> map = new HashMap<>();
		int max = 1; // 제일 많이 팔린 책의 개수
		
		for(int n = 0; n < N; n++) {
			String subject = br.readLine();
			
			if(map.containsKey(subject)) {
				int num = map.get(subject) + 1;
				map.replace(subject, num);
				max = Math.max(max, num);
			}
			else
				map.put(subject, 1);
		}
		
		ArrayList<String> al = new ArrayList<>(map.keySet());
		Collections.sort(al);
		
		for(String s : al) {
			if(map.get(s) == max) {
				System.out.println(s);
				break;
			}
		}
	}
}
