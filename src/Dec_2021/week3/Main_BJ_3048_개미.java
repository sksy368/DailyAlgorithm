package December.week3;

import java.util.*;
import java.io.*;

public class Main_BJ_3048_개미 {
	
	static class Ant {
		char name, d;
		Ant(char name, char d){
			this.name = name;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n1 = Integer.parseInt(st.nextToken()); // 첫 번째 그룹의 개미의 수
		int n2 = Integer.parseInt(st.nextToken()); // 두 번째 그룹의 개미의 수
		
		String orderN1 = br.readLine(); // 첫 번째 그룹의 개미의 순서
		String orderN2 = br.readLine(); // 두 번째 그룹의 개미의 순서
		
		ArrayList<Ant> order = new ArrayList<>();
		
		for(int i = 0; i < n1; i++) order.add(0, new Ant(orderN1.charAt(i), 'r')); // 오른쪽(r)으로 이동
		for(int i = 0; i < n2; i++) order.add(new Ant(orderN2.charAt(i), 'l')); // 왼쪽(l)으로 이동
		
		int T = Integer.parseInt(br.readLine()); // 지난 시간
		
		while(T-- > 0) {
			for(int i = 1; i < order.size(); i++) {
				if(order.get(i-1).d == 'r' && order.get(i).d == 'l') {
					Ant tmp = order.get(i);
					order.remove(i);
					order.add(i-1, tmp);
					i++;
				}
			}
		}
		
		for(int i = 0; i < order.size(); i++) System.out.print(order.get(i).name);
	}
}
