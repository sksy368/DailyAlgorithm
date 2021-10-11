package Graph.com.ssafy.Practice_0916;

import java.util.*;
import java.io.*;

public class Solution_SWEA_1263_사람네트워크2_BFS {
	
	static class Person {
        int no, distance;
        public Person(int no, int distance) {
            this.no = no;
            this.distance = distance;
        }
    }
     
    static int N, minCC;
    static ArrayList<Integer>[] network;
    static boolean[] checked;
     
     
    private static int dijkstra(int start) {
        Queue<Person> queue = new LinkedList<>();
        checked = new boolean[N+1];
        int sum = 0;
         
        queue.offer(new Person(start, 0));
        checked[start] = true;
         
        while(!queue.isEmpty()) {
            Person cur = queue.poll();
            sum += cur.distance;
             
            for(int i = 0; i < network[cur.no].size(); i++) {
                int p = network[cur.no].get(i);
                 
                if(!checked[p]) {
                    queue.offer(new Person(p, cur.distance+1));
                    checked[p] = true;
                }
            }
        }
         
        return sum;
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
         
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 사람 수
            network = new ArrayList[N+1];
            minCC = Integer.MAX_VALUE;
             
            for(int i = 1; i <= N; i++)
                network[i] = new ArrayList<>();
             
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(Integer.parseInt(st.nextToken()) == 1) {
                        network[i].add(j);
                        network[j].add(i);
                    }
                }
            }
             
            for(int i = 1; i <= N; i++)
                minCC = Math.min(dijkstra(i), minCC);
             
            System.out.println("#" + t + " " + minCC);
        }
    }
}