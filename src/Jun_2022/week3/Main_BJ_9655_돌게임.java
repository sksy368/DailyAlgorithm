package Jun_2022.week3;

import java.io.*;

public class Main_BJ_9655_돌게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 돌 개수
		
		if(N % 2 == 0) System.out.println("CY");
		else System.out.println("SK");
	}
}