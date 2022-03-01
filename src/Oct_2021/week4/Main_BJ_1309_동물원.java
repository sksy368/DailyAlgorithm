package Oct_2021.week4;

import java.io.*;

public class Main_BJ_1309_동물원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] D = new int[N+1];
		D[0] = 1;
		D[1] = 3;
		
		for(int i = 2; i <= N; i++)
			D[i] = (D[i-2] + D[i-1]*2) % 9901;
		
		System.out.println(D[N]);
	}
}