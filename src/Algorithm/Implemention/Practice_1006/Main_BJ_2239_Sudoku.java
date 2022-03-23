package Algorithm.Implemention.Practice_1006;

import java.util.*;
import java.io.*;

public class Main_BJ_2239_Sudoku {
	
	static ArrayList<int[]> empty;
	
	private static boolean isPossible(int num, int row, int column, int[][] board) { // 각 라인, 칸(3x3)에 중복이 없는지 검사
		int rowStart = (row / 3) * 3;
		int columnStart = (column / 3) * 3;
		
		for(int i = rowStart; i < rowStart+3; i++) {
			for(int j = columnStart; j < columnStart+3; j++) {
				if(board[i][j] == num) return false; // 같은 칸(3x3)에 같은 수가 있는 경우, false 반환 
			}
		}

		for(int i = 0; i < 9; i++) {
			if(board[row][i] == num || board[i][column] == num) return false; // 같은 라인에 같은 수가 있는 경우, false 반환
		}
		
		return true;
	}
	
	
	private static void fill(int row, int column, int[][] board) {
		if(input > 9)
			return;
		
		if(cnt == empty.size()) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++)
					System.out.print(board[i][j] + " ");
				System.out.println();
			}
			return;
		}
		
		int[][] newBoard = new int[9][9];
		for(int i = 0; i < 9; i++) newBoard[i] = board[i].clone();
		
		for(int i = 0; i < 9; i++)
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] board = new int[9][9];
		empty = new ArrayList<>();
		
		for(int i = 0; i < 9; i++){
			String s = br.readLine();
			for(int j = 0; j < 9; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] == 0)
					fill(i, j, board);
			}
		}
		
		fill(0, 1, board);
	}
}
