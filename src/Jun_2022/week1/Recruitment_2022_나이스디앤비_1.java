package Jun_2022.week1;

import java.util.*;

public class Recruitment_2022_나이스디앤비_1 {
	
	public int solution(String[] grades, int[] weights, int threshold) {
		HashMap<String, Integer> map = new HashMap<>();
		int answer = 0;
		
		map.put("A+", 10);
		map.put("A0", 9);
		map.put("B+", 8);
		map.put("B0", 7);
		map.put("C+", 6);
		map.put("C0", 5);
		map.put("D+", 4);
		map.put("D0", 3);
		map.put("F", 0);
		
		for(int i = 0; i < grades.length; i++)
			answer += map.get(grades[i]) * weights[i];
		
		return answer - threshold;
	}
}