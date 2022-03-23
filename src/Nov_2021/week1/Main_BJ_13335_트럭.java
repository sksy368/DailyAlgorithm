package Nov_2021.week1;

import java.io.*;
import java.util.*;

public class Main_BJ_13335_트럭 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 트럭의 개수
		int w = Integer.parseInt(st.nextToken()); // 다리 길이
		int l = Integer.parseInt(st.nextToken()); // 다리의 최대 하중
		
		Queue<Integer> trucks = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			trucks.offer(Integer.parseInt(st.nextToken()));
		
		int time = 0;
		int totalCnt = 0; // 다리 위 트럭들의 무게 합
		Queue<Integer> bridge = new LinkedList<>();
		
		for(int i = 0; i < w; i++)
			bridge.offer(0); // 다리 위에 무게가 0인 트럭들로 세팅
		
		while(!bridge.isEmpty()) {
			time++;
			totalCnt -= bridge.poll();
			
			if(!trucks.isEmpty()) {
				if(totalCnt + trucks.peek() <= l) { // 다음 트럭을 다리 위에 놓을 수 있는 경우
					int truck = trucks.poll();
					
					bridge.offer(truck); // 다리 위에 트럭 추가
					totalCnt += truck; // 다리 위의 트럭들의 무게에 트럭 무게 추가
				}
				else // 다음 트럭을 다리 위에 놓을 수 없는 경우
					bridge.offer(0); //  무게가 0인 트럭 출발
			}	
		}
		
		System.out.println(time);
	}
}