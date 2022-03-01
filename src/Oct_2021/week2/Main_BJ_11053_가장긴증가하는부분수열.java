package Oct_2021.week2;

import java.util.Scanner;

public class Main_BJ_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();
		int[] arr = new int[a];
		int[] LIS = new int[a];
		int max = 0;
		
		for(int i = 0; i < a; i++)
			arr[i] = scanner.nextInt();
		
		for(int i = 0; i < a; i++) {
			LIS[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && LIS[i] < LIS[j] + 1)
					LIS[i] = LIS[j] + 1;
			}
			
			max = Math.max(LIS[i], max);
		}
		
		System.out.println(max);
	}
}