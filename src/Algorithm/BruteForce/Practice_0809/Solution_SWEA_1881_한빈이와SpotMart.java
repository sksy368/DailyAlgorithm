package Algorithm.BruteForce.Practice_0809;

import java.util.Scanner;

public class Solution_SWEA_1881_한빈이와SpotMart {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for(int t = 1; t <= T; t++) {
            int N = scanner.nextInt(); // 과자 봉지의 개수
            int M = scanner.nextInt(); // 과자 봉지 무게 합 제한
             
            int[] snacks = new int[N];
            for(int n = 0; n < N; n++) snacks[n] = scanner.nextInt();
             
            int max = 0;
            for(int i = 0; i < N; i++) {
                for(int j = i + 1; j < N; j++)
                    if(snacks[i] + snacks[j] <= M) max = Math.max(max,  snacks[i] + snacks[j]);
            }
             
            System.out.print("#" + t + " ");
            if(max == 0) System.out.println(-1);
            else System.out.println(max);
        }
    }
}