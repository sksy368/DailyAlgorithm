package December.week1;

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
	static ArrayList<Integer>[] result;
	static LinkedList<Integer> answer;
	
	static PriorityQueue<Person> queue;
	static boolean[] checked;
	static int[] distance;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 관계의 수
			M = Integer.parseInt(st.nextToken()); // 정치인의 수
			people = new ArrayList[M];
			result = new ArrayList[M];
			
			for(int m = 0; m < M; m++) {
				people[m] = new ArrayList<Person>();
				result[m] = new ArrayList<Integer>();
			}
			
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
			if(answer != null) {
				for(int i = 0; i < answer.size(); i++)
					System.out.print(answer.get(i) + " ");
				System.out.println();
			}
			else
				System.out.println(-1);
		}
	}
	
	static void dijkstra() {
		queue = new PriorityQueue<>();
		checked = new boolean[N];
		distance = new int[N]; Arrays.fill(distance, 987654321);
		
		queue.offer(new Person(0, 0));
		distance[0] = 0;
		
		boolean flag = false;
		
		loop:while(!queue.isEmpty()) {
			Person cur = queue.poll();
			
			if(checked[cur.friend]) continue;
			//System.out.println(cur.friend); //remove
			checked[cur.friend] = true;
			
			for(Person next : people[cur.friend]) {
				if(distance[next.friend] > distance[cur.friend] + next.friendship) {
					distance[next.friend] = distance[cur.friend] + next.friendship;
					queue.offer(new Person(next.friend, distance[next.friend]));
					
					result[cur.friend].add(next.friend);
					
					if(next.friend == M-1) {
						flag = true;
						break loop;
					}
				}
			}
		}
		
		for(int i = 0; i < result.length; i++)
			System.out.println(result[i].toString());
		
		if(flag) bfs();
		else return;
	}
	
	static void bfs() {
		Queue<LinkedList<Integer>> queue = new LinkedList<>();
		LinkedList<Integer> list = new LinkedList<>();
		list.add(0);
		queue.offer(list);
		
		answer = new LinkedList<Integer>();
		
		while(!queue.isEmpty()) {
			LinkedList<Integer> cur = queue.poll();
			
			
			for(int n : result[cur.get(cur.size()-1)]) {
				LinkedList<Integer> tmp = new LinkedList<>();
				tmp.addAll(cur);
				tmp.add(n);
				
				if(n == M-1) {
					answer.addAll(tmp);
					return;
				}
				
				queue.offer(tmp);
			}
		}
	}
}
