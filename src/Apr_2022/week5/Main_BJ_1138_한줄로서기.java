package Apr_2022.week5;

import java.io.*;
import java.util.*;

public class Main_BJ_1138_한줄로서기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 사람의 수
		int[] taller = new int[N]; // 왼쪽에 있는 자기보다 키가 큰 사람의 수
		ArrayList<Integer> order = new ArrayList<>(); // 줄을 선 순서대로의 키
		
		st = new StringTokenizer(br.readLine());
		
		for(int n = 0; n < N; n++) taller[n] = Integer.parseInt(st.nextToken());
		
		for(int n = N-1; n >= 0; n--) order.add(taller[n], n+1);
		
		for(int n = 0; n < order.size(); n++) System.out.print(order.get(n) + " ");
	}
}
