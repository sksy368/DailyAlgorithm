package November.week1;

import java.util.*;
import java.io.*;

public class Main_BJ_14465_소가길을건너간이유5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 횡단보도 개수
		int K = Integer.parseInt(st.nextToken()); // 연속하는 신호등 개수
		int B = Integer.parseInt(st.nextToken()); // 고장난 신호등 개수
		
		boolean[] broken = new boolean[N+1];
		for(int b = 0; b < B; b++)
			broken[Integer.parseInt(br.readLine())] = true; // 고장난 신호등은 true
		
		int cnt = 0;
		int min = Integer.MAX_VALUE;

		for(int i = 1; i <= N; i++) {
			if(i <= K) {
				if(broken[i]) cnt++;
				continue;
			}
			
			if(broken[i-K] && !broken[i]) // i-K번째 신호등이 고장났고, i번째 신호등이 고장나지 않은 경우
				cnt--;
			else if(!broken[i-K] && broken[i]) // i-K번째 신호등이 고장나지 않았고, i번째 신호등이 고장난 경우
				cnt++;
			
			// i-K번째 신호등과 i번째 신호등이 둘 다 고장난 경우와 i-K번째 신호등과 i번째 신호등이 둘 다 고장나지 않은 경우는 고려할 필요가 없음
			
			min = Math.min(cnt, min);
		}
		
		System.out.println(min);
	}
}