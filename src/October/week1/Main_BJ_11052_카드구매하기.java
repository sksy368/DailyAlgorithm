package October.week1;

import java.util.Scanner;

public class Main_BJ_11052_카드구매하기 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int[] pay = new int[N+1];
		int[][] D = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++)
			pay[i] = scanner.nextInt();
		
		for(int i = 1; i <= N; i++) { // 카드팩 번호
			for(int j = 1; j <= N; j++) { // 카드 개수
				if(i > j) // 해당 개수를 해당 카드팩으로 구매할 수 없는 경우
					D[i][j] = D[i-1][j];
				else {
					D[i][j] = Math.max(D[i][j-i] + pay[i], D[i-1][j]);
				}
			}
		}
		
		System.out.println(D[N][N]);
	}
}