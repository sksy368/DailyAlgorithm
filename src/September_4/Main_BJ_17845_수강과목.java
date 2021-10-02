package September_4;

import java.util.Scanner;

public class Main_BJ_17845_수강과목 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt(); // 최대 공부시간
		int K = scanner.nextInt(); // 과목 개수
		
		int[] importance = new int[K+1];
		int[] time = new int[K+1];
		
		for(int i = 1; i <= K; i++) {
			importance[i] = scanner.nextInt();
			time[i] = scanner.nextInt();
		}
		
		int[][] D = new int[K+1][N+1]; // D[과목][최대 공부시간]
		for(int i = 1; i <= K; i++) {
			for(int j = 1; j < N+1; j++) {
				if(time[i] > j) // 시간을 넘어서는 경우
					D[i][j] = D[i-1][j];
				else {
					D[i][j] = Math.max(D[i-1][j], D[i-1][j-time[i]]+importance[i]);
				}
			}
		}
		
		System.out.println(D[K][N]);
	}
}