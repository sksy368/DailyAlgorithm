package Nov_2021.week3;

import java.util.*;
import java.io.*;

public class Main_BJ_20057_마법사상어와토네이도 {
	
	static int N;
	static double ans;
	static double[][] A;
	
	static int[][] d = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; // 좌 -> 하 -> 우 -> 상
	static int[][] d1 = {{-1, 1}, {1, 1}}; // 모래 1%가 이동하는 부분 (y 기준)
	static int[][] d2 = {{-2, 0}, {2, 0}}; // 모래 2%가 이동하는 부분 (y 기준)
	static int[][] d7 = {{-1, 0}, {1, 0}}; // 모래 7%가 이동하는 부분 (y 기준)
	static int[][] d10 = {{-1, -1}, {1, -1}}; // 모래 10%가 이동하는 부분 (y 기준)
	static int[][] d5 = {{0, -2}}; // 모래 5%가 이동하는 부분 (y 기준)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 격자의 크기
		A = new double[N][N];
		ans = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++)
				A[i][j] = Integer.parseInt(st.nextToken()); // 모래의 양
		}
		
		for(int n = 0; n < N/2; n++) {
			int row = N/2 - n; // 현재 x 위치(행)
			int column = N/2 + n; // 현재 x 위치(열)
			int direction = 0; // 현재 이동 방향
			int num = 0;
			System.out.print("n : " + n + "  row : " + row + "  column : " + column);
			for(int i = 0; i < (2*n+1)*4+1; i++) {
				if(num < 2*n+1) {
					tornadoes(row, column, 0); // 좌(0)
					direction = 0;
					System.out.println("좌");
				}
				else if(num < 2*(2*n+1)) {
					tornadoes(row, column, 1); // 하(1)
					direction = 1;
					System.out.println("하");
				}
				else if(num < 3*(2*n+1)+1) {
					tornadoes(row, column, 2); // 우(2)
					direction = 2;
					System.out.println("우");
				}
				else {
					tornadoes(row, column, 3); // 상(3)
					direction = 3;
					System.out.println("상");
				}
				
				row += d[direction][0];
				column += d[direction][1];
				num++;
			}
		}
		for(int j = N-2; j > 0; j--)
			tornadoes(0, j, 0);
		
		System.out.println(ans);
	}
	
	static void tornadoes(int row, int column, int direction) {
		int r = row + d[direction][0]; // y의 위치(행)
		int c = column + d[direction][1]; // y의 위치(열)
		
		if(A[r][c] <= 0) return;
		
		int tmpR = r + d[direction][0]; // å의 위치(행)
		int tmpC = c + d[direction][1]; // å의 위치(열)
		
		moveSand(tmpR+(d[direction][0]+1)%4, tmpC+(d[direction][0]+1)%4, 10, A[r][c]); // 10%
		moveSand(tmpR+(d[direction][0]+3)%4, tmpC+(d[direction][0]+3)%4, 10, A[r][c]); // 10%
		moveSand(r+(d[direction][0]+1)%4, c+(d[direction][0]+1)%4, 7, A[r][c]); // 7%
		moveSand(r+(d[direction][0]+3)%4, c+(d[direction][0]+3)%4, 7, A[r][c]); // 7%
		moveSand(r+((d[direction][0]+1)%4)*2, c+((d[direction][0]+1)%4)*2, 2, A[r][c]); // 2%
		moveSand(r+((d[direction][0]+3)%4)*2, c+((d[direction][0]+3)%4)*2, 2, A[r][c]); // 2%
		moveSand(row+(d[direction][0]+1)%4, column+(d[direction][0]+1)%4, 1, A[r][c]); // 1%
		moveSand(row+(d[direction][0]+3)%4, column+(d[direction][0]+3)%4, 1, A[r][c]); // 1%
		moveSand(r+d[direction][0]*2, c + d[direction][1]*2, 5, A[r][c]); // 5%
		moveSand(tmpR, tmpC, 55, A[r][c]); // å
		
		A[r][c] = 0;
	}
	
	static void moveSand(int row, int column, int percentage, double quantity) {
		try{
			A[row][column] +=quantity * percentage * 0.01;
			A[row][column] = Math.floor(A[row][column] * 100) / 100.0;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("quantity : " + quantity + "  percentage: " + percentage + "  ans : " + ans);
			ans += quantity * percentage * 0.01;
			ans = Math.floor(ans * 100) / 100.0;
		}
	}
}
