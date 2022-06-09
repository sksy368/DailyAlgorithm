package Jun_2022.week2;

import java.io.*;
import java.util.*;

public class Main_BJ_10815_숫자카드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드의 개수
		int[] cards = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) cards[n] = Integer.parseInt(st.nextToken()); // 숫자 카드에 적혀있는 정수
		
		Arrays.sort(cards);
		
		int M = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자인지 아닌지를 구해야 할 정수의 개수
		st = new StringTokenizer(br.readLine());
		
		for(int m = 0; m < M; m++) {
			int num = Integer.parseInt(st.nextToken()); // 상근이가 가지고 있는 숫자인지 아닌지를 구해야 할 정수
			int min = 0;
			int max = N-1;
			boolean flag = false;
			
			while(max >= min) {
				if(num == cards[(min+max)/2]) {
					flag = true;
					break;
				}
				else if(num > cards[(min+max)/2]) min = (min+max)/2 + 1;
				else max = (min+max)/2 - 1;
			}
			
			if(flag) System.out.print(1 + " ");
			else System.out.print(0 + " ");
		}
	}
}
