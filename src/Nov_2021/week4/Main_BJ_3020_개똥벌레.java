package Nov_2021.week4;

import java.util.*;
import java.io.*;

public class Main_BJ_3020_개똥벌레 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		int N = Integer.parseInt(st.nextToken()); // 동굴의 길이
		int H = Integer.parseInt(st.nextToken()); // 동굴의 높이
		
		int[] low = new int[H+2];
		int[] high = new int[H+2];

		for (int i = 0; i < N / 2; i++) {
			low[Integer.parseInt(br.readLine())]++;
			high[H - Integer.parseInt(br.readLine())+1]++;
		}
		
		for (int i = H; i > 0; i--) low[i] += low[i+1];
		for (int i = 1; i <= H; i++) high[i+1] += high[i];

		int min = Integer.MAX_VALUE;
		int cnt = 0;

		for (int i = 1; i <= H; i++) {
			int obstacle = low[i] + high[i];

			if (obstacle < min) {
				min = obstacle;
				cnt = 1;
			} else if (obstacle == min)
				cnt++;
		}

		System.out.println(min + " " + cnt + "\n");
	}
}