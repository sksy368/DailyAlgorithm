package Apr_2022.week4;

import java.io.*;

public class Main_BJ_10829_이진수변환 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long N = Long.parseLong(br.readLine());
		
		while(N > 0) {
			sb.append(N%2==0? "0": "1");
			N /= 2;
		}
		
		System.out.println(sb.reverse().toString());
	}
}