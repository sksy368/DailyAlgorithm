package Algorithm.DataStructure.Practice_0806;

import java.util.*;
import java.io.*;
 
public class Solution_SWEA_1861_정사각형방 {
     
    static int N;
    static int[][] room;
    static int[] cnt;
     
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
     
    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
         
        while(!queue.isEmpty()) {
            int[] current = new int[2];
            current = queue.poll();
             
            for(int d = 0; d < 4; d++) {
                int row = current[0] + dr[d];
                int column = current[1] + dc[d];
                 
                if(row >= 0 && row < N && column >= 0 && column < N
                        && room[row][column] == room[current[0]][current[1]]+1) {
                    queue.offer(new int[] {row, column});
                    cnt[room[i][j]]++;
                    break;
                }
            }
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            room = new int[N][N];
            cnt = new int[N*N+1];
             
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++)
                    room[i][j] = Integer.parseInt(st.nextToken());
            }
             
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    bfs(i, j);
                }
            }
             
            int max = 0;
            int maxIdx = 0;
            for(int i = 1; i < N*N+1; i++) {
                if(cnt[i] > max) {
                    max = cnt[i];
                    maxIdx = i;
                }
            }
             
            System.out.println("#" + t + " " + maxIdx + " " + (max+1));
        }
    }
}