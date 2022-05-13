package May_2022.week2;

import java.util.*;
import java.io.*;

public class Main_Goorm_47878_사은품교환하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			
			long N = Long.parseLong(st.nextToken()); // 성태가 보유한 시즌 한정 음료 쿠폰 수
			long M = Long.parseLong(st.nextToken()); // 성태가 보유한 일반 음료 쿠폰 수
			long cnt = 0;
			
			cnt += Math.min(N/5, M/7);
			N -= 5*cnt;
			M -= 7*cnt;
			
			if (N >= 5 && M+N >= 12) { // 질문: M이 7보다 작거나 N이 5보다 작아서 M+N>=12 조건이 필요없지 않나요?
									   // 답: M이 7보다 작거나 N이 5보다 작아도 M+N<12인 경우가 있는데, 이 때에도 카운트되기 때문에 해당 조건은 필요함.
									   //     (예시: N=8, M=2)
					N -= (12-M);
					M = 0;
					cnt++;
			}
				
			cnt += N / 12;
			
			System.out.println(cnt);
		}
	}
}
