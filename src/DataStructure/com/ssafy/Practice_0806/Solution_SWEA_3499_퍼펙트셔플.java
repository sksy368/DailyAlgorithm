package DataStructure.com.ssafy.Practice_0806;

import java.util.*;
import java.io.*;
 
public class Solution_SWEA_3499_퍼펙트셔플 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            Queue<String> leftQueue = new LinkedList<>();
            Queue<String> rightQueue = new LinkedList<>();
             
            for(int n = 0; n < (N+1)/2; n++)
                leftQueue.offer(st.nextToken());
            for(int n = (N+1)/2; n < N; n++)
                rightQueue.offer(st.nextToken());
             
            System.out.print("#" + t + " ");
            while(!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
                if(!leftQueue.isEmpty())
                    System.out.print(leftQueue.poll() + " ");
                if(!rightQueue.isEmpty())
                    System.out.print(rightQueue.poll() + " ");
            }
            System.out.println();
        }
    }
 
}