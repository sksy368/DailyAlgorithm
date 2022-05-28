package May_2022.week4;

import java.io.*;

public class Main_BJ_2292_벌집 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int max = 1;
		int cnt = 1;

		while(N > max) {
			cnt++;
			max += cnt*2 + ((cnt-2)*2+1)*2;
		}
		
		System.out.println(cnt);
	}
}