package Dec_2021.week1;

import java.util.*;
import java.io.*;

public class Main_BJ_9694_무엇을아느냐가아니라누구를아느냐가문제다 {
	
	static class Person implements Comparable<Person> {
		int friend, friendship;
		LinkedList<Integer> list = new LinkedList<>();
		Person(int friend, int friendship){
			super();
			this.friend = friend;
			this.friendship = friendship;
		}
		
		public int compareTo(Person p) {
			return Integer.compare(this.friendship, p.friendship);
		}
	}
	
	static int N, M;
	static ArrayList<Person>[] people;
	
	static PriorityQueue<Person> queue;
	static boolean[] checked;
	static int[] distance;
	static String[] path;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 관계의 수
			M = Integer.parseInt(st.nextToken()); // 정치인의 수
			people = new ArrayList[M];
			
			for(int m = 0; m < M; m++) people[m] = new ArrayList<Person>();
	
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken()); // 정치인
				int y = Integer.parseInt(st.nextToken()); // 친구
				int z = Integer.parseInt(st.nextToken()); // 친밀도
				
				people[x].add(new Person(y, z));
				people[y].add(new Person(x, z));
			}
			
			dijkstra();
			
			System.out.print("Case #" + t + ": ");
			
			if(path[M-1] != null) System.out.println(path[M-1]);
			else System.out.println(-1);
		}
	}
	
	static void dijkstra() {
		queue = new PriorityQueue<>();
		checked = new boolean[M];
		distance = new int[M]; Arrays.fill(distance, 987654321);
		path = new String[M]; // 한신이부터 각각까지의 최소 경로
		
		queue.offer(new Person(0, 0));
		distance[0] = 0;
		path[0] = "0 ";
		
		while(!queue.isEmpty()) {
			Person cur = queue.poll();
			
			if(checked[cur.friend]) continue;
			checked[cur.friend] = true;
			
			for(Person next : people[cur.friend]) {
				if(distance[next.friend] > distance[cur.friend] + next.friendship) {
					distance[next.friend] = distance[cur.friend] + next.friendship;
					queue.offer(new Person(next.friend, distance[next.friend]));
					
					path[next.friend] = path[cur.friend] + next.friend + " ";
				}
			}
		}
	}
}
