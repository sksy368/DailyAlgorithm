package May_2022.week4;

import java.io.*;
import java.util.*;

public class Main_BJ_14891_톱니바퀴 {
	
	static List<Integer>[] state;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		state = new LinkedList[5];
		int answer = 0;
		
		for(int i = 1; i <= 4; i++) {
			state[i] = new LinkedList<>(); 
			String input = br.readLine();
			for(int j = 0; j < input.length(); j++)
				state[i].add(Integer.parseInt(input.charAt(j)+"")); // N극:0, S극:1
		}
		
		int K = Integer.parseInt(br.readLine()); // 회전 횟수
		
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken());
			int direct = Integer.parseInt(st.nextToken());
			
			move(no, direct); // 해당 톱니바퀴 회전
			
			int leftIdx = no - 1; // 왼쪽 톱니바퀴의 번호
			int rightIdx = no + 1; // 오른쪽 톱니바퀴의 번호
			int leftDirect = direct; // 왼쪽 톱니바퀴의 회전 방향
			int rightDirect = direct; // 오른쪽 톱니바퀴의 회전 방향
			
			while(leftIdx > 0) { // 왼쪽 톱니바퀴 회전
				if(state[leftIdx+1].get(6+leftDirect) != state[leftIdx].get(2)) { // 극이 다른 경우
					leftDirect *= (-1); // 회전 방향 변경
					move(leftIdx, leftDirect); // 반대방향으로 회전
					leftIdx--;
				}
				else break;
			}
			
			while(rightIdx <= 4) { // 오른쪽 톱니바퀴 회전
				if(state[rightIdx-1].get(2+rightDirect) != state[rightIdx].get(6)) { // 극이 다른 경우
					rightDirect *= (-1); // 회전 방향 변경
					move(rightIdx, rightDirect); // 오른쪽 톱니바퀴 회전
					rightIdx++;
				}
				else break;
			}
		}
		
		for(int i = 1; i <= 4; i++)
			answer += state[i].get(0)==1 ? Math.pow(2, i-1) : 0;
		
		System.out.println(answer);
	}
	
	public static void move(int no, int direct) { // no: 톱니바퀴의 번호, direct: 방향 (1:시계방향, -1:반시계방향)
		if(direct == 1) { // 시계방향인 경우
			state[no].add(0, state[no].get(7));
			state[no].remove(8);
		}
		else if(direct == -1) { // 반시계방향인 경우
			state[no].add(state[no].get(0));
			state[no].remove(0);
		}
	}
}
