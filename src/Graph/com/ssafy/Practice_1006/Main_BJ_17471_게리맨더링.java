package Graph.com.ssafy.Practice_1006;

import java.util.*;
import java.io.*;

public class Main_BJ_17471_게리맨더링 {
	
	static int N, min;
	static int[] population;
	static ArrayList<Integer>[] adjList;
	
	static boolean[] checked;
	
	private static boolean isConnect(boolean[] district, int area) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(area);
		district[area] = false;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i = 0; i < adjList[cur].size(); i++) {
				if(district[adjList[cur].get(i)]) {
					queue.add(adjList[cur].get(i));
					district[adjList[cur].get(i)] = false; // 연결된 지역은 false로 변경
				}
			}
		}
		
		for(int i = 1; i <= N; i++)
			if(district[i]) return false; // true인 지역이 있는 경우, false 반환
		return true; // true인 지역이 없는 경우, true 반환
	}
	
	
	private static void subset(int cnt) {
		if(cnt == N+1) {
			boolean[] district1 = new boolean[N+1], district2 = new boolean[N+1];
			int sum1 = 0, sum2 = 0;
			int area1 = -1, area2 = -1;
			
			for(int i = 1; i <= N; i++) { // 두 선거구로 지역 분할
				if(checked[i]) {
					district1[i] = true; // 선거구에 포함되는 지역 체크
					sum1 += population[i]; // 선거구에 포함되는 지역의 인구
					area1 = i; // 선거구에 포함되는 지역
				}
				else {
					district2[i] = true;
					sum2 += population[i];
					area2 = i;
				}
			}
			
			// 각 선거구는 구역을 적어도 하나 포함 && 각 선거구에 포함된 구역이 모두 연결
			if(area1 != -1 && area2 != -1 && isConnect(district1, area1) && isConnect(district2, area2))
				min = Math.min(Math.abs(sum1-sum2), min);
			
			return;
		}
		
		checked[cnt] = true;
		subset(cnt+1);
		checked[cnt] = false;
		subset(cnt+1);
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 구역의 개수
		population = new int[N+1];
		adjList = new ArrayList[N+1];
		min = Integer.MAX_VALUE;
		
		for(int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 1; n <= N; n++)
			population[n] = Integer.parseInt(st.nextToken()); // 각 구역의 인구

		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int adjNum = Integer.parseInt(st.nextToken()); // 인접한 구역의 수
			
			for(int i = 0; i < adjNum; i++)
				adjList[n].add(Integer.parseInt(st.nextToken()));
		}
		
		checked = new boolean[N+1];
		subset(1);
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}	
}