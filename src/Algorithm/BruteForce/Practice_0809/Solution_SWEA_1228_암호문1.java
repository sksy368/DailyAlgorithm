package Algorithm.BruteForce.Practice_0809;

import java.util.LinkedList;
import java.util.Scanner;
 
public class Solution_SWEA_1228_암호문1 {
     
    private static LinkedList<String> secretCode;
    private static Scanner scanner = new Scanner(System.in);
     
    public static void insert(int x, int y) {
        for(int i = 0; i < y; i++) secretCode.add(x++, scanner.next());
    }
 
    public static void main(String[] args) {
         
        for(int t = 1; t <= 10; t++) {
            int N = scanner.nextInt(); // 원본 암호문의 길이
            secretCode = new LinkedList<>();
            for(int n = 0; n < N; n++) // 원본 암호문
                secretCode.add(scanner.next());
             
            int num = scanner.nextInt(); // 명령어의 개수
            for(int n = 0; n < num; n++) {
                scanner.next();
                insert(scanner.nextInt(), scanner.nextInt());
            }
             
            System.out.print("#" + t);
            for(int i = 0; i < 10; i++)
                System.out.print(" " + secretCode.get(i));
            System.out.println();
        }
    }
}