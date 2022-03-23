package Algorithm.BruteForce.Practice_0809;

import java.util.*;
import java.io.*;
 
public class Solution_SWEA_5215_햄버거다이어트 {
     
    static int max;
     
    public static void subset(int N, int L, int[][] foods, boolean[] checked, int cnt) {
        if(cnt == N) {
            int tasteSum = 0;
            int calSum = 0;
             
            for(int i = 0; i < N ; i++) {
                if(checked[i]) {
                    tasteSum += foods[i][0];
                    calSum += foods[i][1];
                }
            }
             
            if(calSum <= L)
                max = Math.max(tasteSum, max);
             
            return;
        }
         
        checked[cnt] = true;
        subset(N, L, foods, checked, cnt+1);
        checked[cnt] = false;
        subset(N, L, foods, checked, cnt+1);
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // food num
            int L = Integer.parseInt(st.nextToken()); // cal
             
            int[][] foods = new int[N][2];
            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                foods[n][0] = Integer.parseInt(st.nextToken()); // taste
                foods[n][1] = Integer.parseInt(st.nextToken()); // cal
            }
             
            max = 0;
            boolean[] checked = new boolean[N];
            subset(N, L, foods, checked, 0);
             
            System.out.println("#" + t + " " + max);
        }
    }
}
