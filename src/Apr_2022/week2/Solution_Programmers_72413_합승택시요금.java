package Apr_2022.week2;

public class Solution_Programmers_72413_합승택시요금 {
	public static void main(String[] args) {
		int n = 6; // 지점 개수
		int s = 4; // 출발지점
		int a = 5; // A의 도착지점
		int b = 6; // B의 도착지점
		int[][] fares = {{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}} ; // 지점 사이의 예상 택시요금
		
		System.out.println(solution(n, s, a, b, fares));
		
	}
	
	public static int solution(int n, int s, int a, int b, int[][] fares) {
		
		int[][] map = new int[n+1][n+1];
		
		for(int i = 0; i < fares.length; i++) {
			int place1 = fares[i][0];
			int place2 = fares[i][1];
			int fee = fares[i][2];
			
			map[place1][place2] = map[place2][place1] = fee;
		}
		
		for(int n1 = 1; n1 <= n; n1++) {
			for(int n2 = 1; n2 <= n; n2++) {
				if(n1!=n2 && map[n1][n2]==0)
					map[n1][n2] = 100000*n+1;
			}
		}
		
		for(int k = 1; k <= n; k++) {
			for(int n1 = 1; n1 <= n; n1++) {
				for(int n2 = 1; n2 <= n; n2++) {
					map[n1][n2] = Math.min(map[n1][n2], map[n1][k]+map[k][n2]);
				}
			}
		}
		
		int answer = Integer.MAX_VALUE;
		
		for(int i = 1; i <= n; i++) {
			answer = Math.min(answer, map[s][i]+map[i][a]+map[i][b]);
		}
		
		return answer;
	}
}
