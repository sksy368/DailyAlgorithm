package May_2022.week2;

import java.util.*;

public class Main_Goorm_88520_놀이공원 {

public static final Scanner scanner = new Scanner(System.in);
	
	public static void testCase(int caseIndex) {
		int N = scanner.nextInt();  // 지도의 크기 
		int K = scanner.nextInt();  // 놀이공원의 크기
		
		int[][] wastes = new int[N][N]; // 각 칸의 쓰레기 존재 여부 
		for (int r = 0; r < N; r += 1) {
			for (int c = 0; c < N; c += 1) {
				wastes[r][c] = scanner.nextInt();
			}
		}
		
		int answer = Integer.MAX_VALUE;
		
		for(int i = 0; i <= N-K; i++){
			for(int j = 0; j <= N-K; j++){
				answer = Math.min(answer, countWaste(i, j, K, wastes));
			}
		}
		
		System.out.println(answer);
	}
	
	public static int countWaste(int row, int column, int size, int[][] wastes){
		int cnt = 0;
		for(int i = row; i < row+size; i++){
			for(int j = column; j < column+size; j++){
				if(wastes[i][j] == 1) cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();
		
		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
		
	}
}