package October.week3;

import java.util.*;
import java.io.*;

public class Main_BJ_1966_프린터큐 {
	
	static class Point {
		int no, importance;
		boolean isTarget;
		public Point(int no, int importance, boolean isTarget) {
			super();
			this.no = no;
			this.importance = importance;
			this.isTarget = isTarget;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서의 개수
			int M = Integer.parseInt(st.nextToken()); // 순서가 궁금한 문서의 현재 Queue에서의 위치
			
			st = new StringTokenizer(br.readLine());
			
			Queue<Point> queue = new LinkedList<>();
			for(int n = 0; n < N; n++)
				queue.offer(new Point(n, Integer.parseInt(st.nextToken()), n==M?true:false));
			
			int cnt = 0;
			
			while(true) {
				Point cur = queue.poll();
				
				Iterator it = queue.iterator();
				boolean flag = true;
				
				while(it.hasNext()) { // 중요도가 가장 높은지 체크
					Point next = (Point)it.next();
					if(cur.importance < next.importance){
						flag = false;
						break;
					}
				}
				
				if(flag) { // 중요도가 가장 높은 경우
					cnt++;
					if(cur.isTarget) break; // 순서가 궁금한 문서인 경우
				}
				else queue.offer(cur);
			}
			
			System.out.println(cnt);
		}
	}
}