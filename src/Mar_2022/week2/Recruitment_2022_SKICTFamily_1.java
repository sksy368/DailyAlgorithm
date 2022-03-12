package Mar_2022.week2;

import java.util.*;
import java.io.*;

public class Recruitment_2022_SKICTFamily_1 {
	
	static class Coin implements Comparable<Coin> {
		int type, cost, standard;
		public Coin(int type, int cost, int standard) {
			this.type = type; // 화페 단위
			this.cost = cost; // 생산 단가
			this.standard = standard; // 500원 당 생산 단가
		}
		
		public int compareTo(Coin o) {
			return Integer.compare(this.standard, o.standard);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int money = Integer.parseInt(br.readLine()); // 생산하고자 하는 돈
		int[] costs = new int[6]; // 1, 5, 10, 50, 100원 동전의 생산 단가
		int[] type = new int[] {1, 5, 10, 50, 100, 500}; // 동전의 종류
		Coin[] coins = new Coin[6];
		
		int answer = 0; // 총 생산 화폐 가치
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 6; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
			coins[i] = new Coin(type[i], costs[i], 500/type[i]*costs[i]);
		}
		
		Arrays.sort(coins);
		
		for(int i = 0; i < 6; i++) {
			answer += money / coins[i].type * coins[i].cost;
			money %= coins[i].type;
		}
		
		System.out.println(answer);
	}

}
