package Algorithm.DataStructure.Practice_0810;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_1158_요세푸스문제 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		
		for(int i = 1; i <= N; i++)
			queue.add(i);
		
		int check = 1;
		System.out.print("<");
		
		while(!queue.isEmpty()) {
			if(check == K) {
				System.out.print(queue.poll());
				if(!queue.isEmpty())
					System.out.print(", ");
				
				check = 1;
				continue;
			}
			
			queue.add(queue.poll());
			check += 1;
		}
		
		System.out.print(">");
	}
}