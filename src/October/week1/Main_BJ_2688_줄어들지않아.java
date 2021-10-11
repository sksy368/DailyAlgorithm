package October.week1;

import java.util.Scanner;

public class Main_BJ_2688_줄어들지않아 {
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		for(int t = 1; t <= T; t++) {
			int n = scanner.nextInt();
			
			long[][] D = new long[n+1][10];
			long sum = 0;
			
			for(int i = 1; i <= n; i++) {
				for(int j = 0; j < 10; j++) {
					if(i == 1 || j == 0) D[i][j] = 1;
					else
						D[i][j] = D[i][j-1] + D[i-1][j];
					
					if(i == n) sum += D[i][j];
				}
			}
			
			System.out.println(sum);
		}
	}
}
