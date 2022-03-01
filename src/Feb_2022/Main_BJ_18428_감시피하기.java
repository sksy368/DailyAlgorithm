package Feb_2022;

import java.io.*;
import java.util.*;

public class Main_BJ_18428_감시피하기 {
	
	static class Coordi {
		int row, column; 
		public Coordi(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}
	
	static int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	static int N;
	static char[][] map;
	static ArrayList<Coordi> empty;
	static ArrayList<Coordi> students;
	static Coordi[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		empty = new ArrayList<>();
		students = new ArrayList<>();
		select = new Coordi[3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0); // 학생:S, 선생님:T, 공백:X
				
				if(map[i][j] == 'X')
					empty.add(new Coordi(i, j));
				if(map[i][j] == 'S')
					students.add(new Coordi(i, j));
			}
		}
		
		combination(0, 0);
		System.out.println("NO");
	}
	
	
	public static void combination(int cnt, int start) { // 장애물을 설치할 3곳 선정하기
		if(cnt == 3) {
			if(check()) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}
		
		for(int i = start; i < empty.size(); i++) {
			select[cnt] = empty.get(i);
			combination(cnt+1, i+1);
		}
	}
	
	
	public static boolean check() {
		char[][] copyMap = new char[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				copyMap[i][j] = map[i][j];
		}
		
		for(int i = 0; i < 3; i++) { // 장애물 표시하기
			int r = select[i].row;
			int c = select[i].column;
			copyMap[r][c] = 'O';
		}
		
		for(int i = 0; i < students.size(); i++) {
			Coordi cur = students.get(i);
			
			for(int d = 0; d < 4; d++) {
				int k = 1;
				while(true) {
					int r = cur.row + D[d][0]*k;
					int c = cur.column + D[d][1]*k;
					
					if(r<0 || r>=N || c<0 || c>=N || copyMap[r][c] == 'O') break;
					if(copyMap[r][c] == 'T') {
						return false;
					}
					
					k++;
				}
			}
		}
		
		return true;
	}
}
