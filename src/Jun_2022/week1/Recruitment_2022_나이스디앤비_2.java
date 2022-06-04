package Jun_2022.week1;

import java.util.*;

public class Recruitment_2022_나이스디앤비_2 {
	
	static class Grade implements Comparable<Grade> {
		int idx, grade;
		Grade(int idx, int grade){
			this.idx = idx;
			this.grade = grade;
		}
		public int compareTo(Grade g) {
			return g.grade - this.grade;
		}
	}
	
	public int[] solution(int[] grade) {
		PriorityQueue<Grade> pq = new PriorityQueue<>();
		int[] answer = new int[grade.length];
		
		for(int i = 0; i < grade.length; i++)
			pq.offer(new Grade(i, grade[i]));
		
		int score = -1;
		int rank = 0;
		int cnt = 1;
		
		while(!pq.isEmpty()) {
			Grade cur = pq.poll();
			
			if(score == cur.grade) cnt++;
			else {
				score = cur.grade;
				rank += cnt;
				cnt = 1;
			}
			
			answer[cur.idx] = rank;
		}
		
		return answer;
	}
}
