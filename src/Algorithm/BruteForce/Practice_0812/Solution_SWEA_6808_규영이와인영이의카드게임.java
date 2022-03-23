package Algorithm.BruteForce.Practice_0812;

import java.util.*;
import java.io.*;
 
public class Solution_SWEA_6808_규영이와인영이의카드게임 {
     
    private static boolean[] numCheck;
    private static int[] kyuCard;
    private static int[] lastCard;
    private static int[] InCard;
    private static int kyuWin;
    private static int kyuLose;
 
    static boolean[] isSelected;
     
    public static void permutation(int cnt) { // 인영이 카드 순열
        if(cnt == 9) {
            score();
            return;
        }
         
        for(int i = 0; i < 9; i++) {
            if(isSelected[i])
                continue;
             
            InCard[cnt] = lastCard[i];
            isSelected[i] = true;
             
            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }
     
    public static void score() { // 점수 비교
        int kyuScore = 0;
        int InScore = 0;
         
        for(int i = 0; i < 9; i++) {
            if(kyuCard[i] > InCard[i])
                kyuScore += kyuCard[i] + InCard[i];
            else if(kyuCard[i] < InCard[i])
                InScore += kyuCard[i] + InCard[i];
        }
         
        if(kyuScore > InScore)
            kyuWin += 1;
        else if(kyuScore < InScore)
            kyuLose += 1;
    }
 
     
    public static void main(String[] args) throws IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int T = Integer.parseInt(st.nextToken());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
             
            numCheck = new boolean[19];
            kyuCard = new int[9];
            for(int i = 0; i < kyuCard.length; i++) { // 규영이 카드
                kyuCard[i] = Integer.parseInt(st.nextToken());
                numCheck[kyuCard[i]] = true;
            }
             
            lastCard = new int[9];
            int index = 0;
            for(int i = 1; i < 19; i++) { // 인영이 카드
                if(!numCheck[i])
                    lastCard[index++] = i;
            }
                 
            kyuWin = 0;
            kyuLose = 0;
 
            isSelected = new boolean[9];
            InCard = new int[9];
            permutation(0);
             
            System.out.println("#" + t + " " + kyuWin + " " + kyuLose);
        }
    }
}