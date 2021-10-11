package September.week4;

import java.util.Scanner;

public class Main_BJ_14501_퇴사 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		
		int[] time = new int[N+1];
		int[] pay = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			time[i] = scanner.nextInt();
			pay[i] = scanner.nextInt();
		}
		
		int[] D = new int[N+2];
		
		for(int i = N; i > 0; i--) {
			if(time[i] > N-i+1) // 시간이 넘어선 경우
				D[i] = D[i+1];
			else {
				D[i] = Math.max(D[i+1], D[i+time[i]]+pay[i]);
			}
		}
		
		System.out.println(D[1]);
	}
}