package Mar_2022.week4;

import java.util.*;
import java.io.*;

public class Main_BJ_2002_추월 {
	
	static class Car {
		String no; // 차 번호
		HashSet<String> front = new HashSet<>(); // 이전의 차들 번호
		Car(String no, HashSet<String> front){
			this.no = no;
			this.front = front;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 차의 대수
		int cnt = 0; // 추월한 차 대수
		
		Car[] cars = new Car[N];
		HashSet<String> set = new HashSet<>();
		
		for(int n = 0; n < N; n++) {
			String car = br.readLine();
			cars[n] = new Car(car, set);
			set.add(car);
			System.out.println(cars[n].front.size());
		}
		
		for(int n = 0; n < N; n++) {
			String car = br.readLine();
			if(cars[n].no.equals(car)) { // 이전의 순서와 같은 경우
				cnt++;
				continue;
			}
			
			HashSet<String> front = cars[n].front;
			int beforeSize = front.size();
			front.add(car);
			int afterSize = front.size();
			
			if(beforeSize < afterSize) cnt++;
		}
		
		System.out.println(cnt);
	}
}