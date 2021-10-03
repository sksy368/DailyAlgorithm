package Implemention.com.ssafy.Practice_1001;

import java.util.*;
import java.io.*;
 
public class Solution_SWEA_4013_특이한자석 {
     
    static int K, answer;
    static ArrayList<Integer>[] magnetic;
    static int[][] rotateInfo;
     
    public static void rotate(int no) {
        int lastPole = magnetic[no].get(7);
        magnetic[no].add(0, lastPole);
        magnetic[no].remove(8);
    }
     
    public static void reverseRotate(int no) {
        int firstPole = magnetic[no].get(0);
        magnetic[no].add(magnetic[no].size(), firstPole);
        magnetic[no].remove(0);
    }
     
    public static void play() {
        for(int k = 0; k < K; k++) {
            int no = rotateInfo[k][0]; // 자석의 번호
            int direction = rotateInfo[k][1]; // 회전 방향
             
            if(direction == 1) // 시계 방향으로 회전할 경우
                rotate(no);
            else // 반시계 방향으로 회전할 경우
                reverseRotate(no);
             
            int beforeD = direction; // 이전 톱니바퀴의 회전 방향
            for(int i = no-1; i > 0; i--) { // 해당 톱니바퀴 왼쪽에 있는 톱니바퀴들 체크
                if((beforeD == 1 && magnetic[i].get(2) == magnetic[i+1].get(7))
                        || (beforeD == -1 && magnetic[i].get(2) == magnetic[i+1].get(5))) { // 자성이 같을 경우
                    break;
                }
                 
                if(beforeD == 1) // 시계 방향으로 회전한 경우
                    reverseRotate(i);
                else // 반시계 방향으로 회전한 경우
                    rotate(i);
                 
                beforeD *= -1; // 이전 톱니바퀴의 회전 방향 갱신
            }
             
            beforeD = direction;
            for(int i = no+1; i <= 4; i++) { // 해당 톱니바퀴 오른쪽에 있는 톱니바퀴들 체크
                if((beforeD == 1 && magnetic[i-1].get(3) == magnetic[i].get(6))
                        || (beforeD == -1 && magnetic[i-1].get(1) == magnetic[i].get(6))){ // 자성이 같을 경우
                    break;
                }
                 
                if(beforeD == 1) // 시계 방향으로 회전한 경우
                    reverseRotate(i);
                else // 반시계 방향으로 회전한 경우
                    rotate(i);
                 
                beforeD *= -1; // 이전 톱니바퀴의 회전 방향 갱신
            }
        }
         
        for(int i = 1; i <= 4; i++) {
            if(magnetic[i].get(0) == 0)
                continue;
             
            answer += Math.pow(2, i-1);
        }
    }
 
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
                 
        for(int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine()); // 회전 횟수
            magnetic = new ArrayList[5];
            rotateInfo = new int[K][2];
             
            for(int i = 1; i <= 4; i++) {
                magnetic[i] = new ArrayList<>();
                st = new StringTokenizer(br.readLine());
                 
                for(int j = 0; j < 8; j++)
                    magnetic[i].add(Integer.parseInt(st.nextToken())); // 0:N극, 1:S극
            }
             
            for(int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int no = Integer.parseInt(st.nextToken()); // 자석의 번호
                int direction = Integer.parseInt(st.nextToken()); // 회전 방향 (1:시계방향, -1:반시계방향)
                 
                rotateInfo[k][0] = no;
                rotateInfo[k][1] = direction;
            }
             
            answer = 0;
            play();
             
            System.out.println("#" + t + " " + answer);
        }
    }
}