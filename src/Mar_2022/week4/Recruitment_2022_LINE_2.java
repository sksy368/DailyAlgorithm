package Mar_2022.week4;

import java.util.*;

public class Recruitment_2022_LINE_2 {
	
	public static int N, max;
	static boolean[] isSelected;
	static HashSet<Character>[] sets;
	static int[] grades;
	
	public static int solution(String[] sentences, int n) {
		N = sentences.length;
		
		sets = new HashSet[N];
		grades = new int[N];
		
		
		for(int i = 0; i < sentences.length; i++) {
			String str = sentences[i];
			HashSet<Character> set = new HashSet<>();
			int big = 0; // 대문자의 개수
			int sum = 0;
			
			for(int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if(c == ' ') continue;
				
				if(c >= 'A' && c <= 'Z') { // 대문자일 경우
					set.add((char) (c+('a'-'A')));
					set.add('0'); // '0' -> 대문자
					big++;
				}
				else // 소문자일 경우
					set.add(c);
			}
			
			if(set.size() > n) continue; // 키보드의 개수를 초과한 경우
			
			sum += str.length();
			sum += big;
			
			sets[i] = set;
			grades[i] = sum;
		}
		
		max = 0;
		isSelected = new boolean[N];
		
		subset(0, n);
		
		return max;
	}
	
	public static void subset(int cnt, int n) { // 부분집합 알고리즘
		if(cnt == N) {
			int sum = 0;
			HashSet<Character> set = new HashSet<>();
			
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					sum += grades[i];
					set.addAll(sets[i]);
					
				}
			}
			
			if(set.size() <= n) max = Math.max(sum, max); // n개로 완성할 수 있는 경우, max값 갱신
			
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1, n);
		isSelected[cnt] = false;
		subset(cnt+1, n);
	}
}
