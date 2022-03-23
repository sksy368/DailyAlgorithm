package Algorithm.BruteForce.Practice_0818;

import java.util.*;
import java.io.*;
 
public class Solution_SWEA_4012_요리사 {
     
    static int N;
    static int[][] foods;
    static boolean[] select;
    static int min;
     
    private static void cook() {
        int sum1 = 0;
        int sum2 = 0;
         
        for(int i = 1; i <= N; i++) {
            for(int j = i+1; j <= N; j++) {
                if(select[i] && select[j])
                    sum1 += (foods[i][j] + foods[j][i]);
                else if(!select[i] && !select[j])
                    sum2 += (foods[i][j] + foods[j][i]);
            }
        }
         
        min = Math.min(Math.abs(sum1-sum2), min);
    }
     
     
    private static void combination(int cnt, int start) {
        if(cnt == N/2) {
            cook();
            return;
        }
         
        for(int i = start; i <= N; i++) {
            select[i] = true;
            combination(cnt+1, i+1);
            select[i] = false;
        }
    }
     
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
             
            N = Integer.parseInt(br.readLine());
            foods = new int[N+1][N+1];
            select = new boolean[N+1];
             
            for(int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= N; j++)
                    foods[i][j] = Integer.parseInt(st.nextToken());
            }
             
            min = Integer.MAX_VALUE;
            combination(0, 1);
             
            System.out.println("#" + t + " " + min);
        }
    }
}