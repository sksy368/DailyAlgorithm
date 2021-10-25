package October.week4;

import java.util.*;
import java.io.*;

public class Main_BJ_5464_주차장 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 주차 공간 수
		int M = Integer.parseInt(st.nextToken()); // 차 수
		
		int[] price = new int[N+1];
		int[] weight = new int[M+1];
		
		for(int n = 1; n <= N; n++) price[n] = Integer.parseInt(br.readLine());
		for(int m = 1; m <= M; m++) weight[m] = Integer.parseInt(br.readLine());
			
		int[] cars = new int[M+1];
		Queue<Integer> wait = new LinkedList<>(); // '대기하는 차'를 담는 Queue
		PriorityQueue<Integer> empty = new PriorityQueue<>(); // '빈 주차 공간'을 담는 PriorityQueue
		for(int i = 1; i <= N; i++) empty.offer(i); // 처음에는 모두 비어있기 때문에 모든 주차 공간을 삽입
		
		int profit = 0;
		
		for(int i = 0; i < 2*M; i++) {
			int carNum = Integer.parseInt(br.readLine());
			if(carNum > 0) { // 들어오는 경우
				if(empty.isEmpty()) { // 주차 공간이 없는 경우
					wait.offer(carNum);
					continue;
				}
			} else { // 나가는 경우
				empty.offer(cars[(-1)*carNum]);
				if(!wait.isEmpty()) // 대기하는 차가 없는 경우
					carNum = wait.poll();
				else continue;
			}
			
			int spaceNum = empty.poll(); // 빈 주차 공간 중 번호가 가장 작은 곳
			cars[carNum] = spaceNum;
			profit += weight[carNum] * price[spaceNum];
		}
		
		System.out.println(profit);
	}
}