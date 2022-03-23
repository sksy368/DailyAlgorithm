package Algorithm.BruteForce.Practice_0817;

import java.util.*;

public class Main_BJ_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int five = N / 5;
		int three = (N % 5) / 3;
		boolean possible = true;
		
		while(N != five * 5 + three * 3) {
			if(five == 0) {
				possible = false;
				break;
			}
			five--;
			three = (N - five*5) / 3;
		}
		
		if(possible)	System.out.println(five+three);
		else	System.out.println(-1);
		
	}
}
