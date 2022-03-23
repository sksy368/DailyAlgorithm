package Mar_2022.week4;

import java.util.*;

public class Main_BJ_1992_쿼드트리 {
	
	public static int N;
	public static char[][] video;
	
	private static boolean check(int row, int column, int size) { // 영역이 같은 색인지 체크
		char temp = video[row][column];
		
		for(int r = row; r < row+size; r++) {
			for(int c = column; c < column+size; c++) {
				if(temp != video[r][c]) return false;
			}
		}
		
		return true;
	}
	
	private static void divide(int startR, int startC, int size) {
		if(check(startR, startC, size)) {
			System.out.print(video[startR][startC]);
			return;
		}
		
		System.out.print("(");
		divide(startR, startC, size/2);
		divide(startR, startC+size/2, size/2);
		divide(startR+size/2, startC, size/2);
		divide(startR+size/2, startC+size/2, size/2);
		System.out.print(")");
	}
	
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt(); // 영상의 크기
		
		video = new char[N][N];
		
		for(int i = 0; i < N; i++)
			video[i] = scanner.next().toCharArray();
		
		divide(0, 0, N);
	}
}