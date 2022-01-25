package January.week2;

import java.io.*;

public class Main_BJ_9659_돌게임5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine()) % 6;
		
		if(N % 2 == 0) System.out.println("CY");
		else System.out.println("SK");
	}
}