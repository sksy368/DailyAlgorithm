package Mar_2022.week4;

import java.util.*;

public class Recruitment_2022_LINE_5 {
	
	public static class Who implements Comparable<Who> {
		int sub, high, low; // 능력 차이, 큰 능력치, 작은 능력치
		Who(int sub, int high, int low){
			this.sub = sub;
			this.high = high;
			this.low = low;
		}
		
		public int compareTo(Who o) {
			return o.sub - this.sub; // 오름차순
		}
	}
	
	public long solution(int[] abilities, int k) {
		long answer = 0;
		ArrayList<Who> who = new ArrayList<>();
		
		Arrays.sort(abilities); // 능력치가 높은 순서대로 정렬
		
		int num = (abilities.length+1)/2; // 진행 횟수
		int idx = abilities.length-1;
		
		while(num-- > 0) {
			if(idx == 0) {
				who.add(new Who(abilities[idx], abilities[idx], 0));
				break;
			}
				
			if(abilities[idx] == abilities[idx-1]) { // 능력치가 같은 경우 -> 와일드카드를 쓰지 않아도 됨
				answer += abilities[idx];
				idx -= 2; // 인덱스 갱신
				continue;
			}
			
			int num1 = abilities[idx];
			int num2 = abilities[idx-1];
			
			who.add(new Who(Math.abs(num1-num2), Math.max(num1, num2), Math.min(num1, num2)));
			idx -= 2; // 인덱스 갱신
		}
		
		Who[] whoArr = new Who[who.size()];
		for(int i = 0; i < who.size(); i++) whoArr[i] = who.get(i);
			
		Arrays.sort(whoArr); // 능력치 차이가 큰 순서대로 정렬 -> 능력치 차이가 큰 경우일 수록 와일드카드를 쓰는게 이득임
		
		for(int i = 0; i < whoArr.length; i++) {
			if(k > 0) { // 와일드카드가 남아 있는 경우
				answer += whoArr[i].high;
				k -= 1;
			} // 와일드카드가 없는 경우
			else answer += whoArr[i].low;
		}
		
		return answer;
	}
}
