package Mar_2022.week4;

import java.io.*;
import java.util.*;

public class Main_BJ_2002_추월 {
	
	static class Car {
		String no;
		HashSet<String> set;
		Car(String no, HashSet<String> set){
			this.no = no;
			this.set = set;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 차의 대수
		int cnt = 0; // 추월한 차 대수
		
		Car[] input = new Car[N];
		String[] output = new String[N];
		
		for(int i = 0; i < N; i++) {
			String car = br.readLine();
			HashSet<String> set = new HashSet<>();
			
			for(int j = 0; j < i; j++) set.add(input[j].no);
			
			input[i] = new Car(car, set);
		}
		
		for(int n = 0; n < N; n++) output[n] = br.readLine();
		
		for(int i = 0; i < N; i++) {
			int idx = -1;
			
			for(int j = 0; j < N; j++)
				if(output[i].equals(input[j].no)) idx = j;
			
			for(int j = 0; j < i; j++) input[idx].set.remove(output[j]);
			
			if(input[idx].set.size() != 0) cnt++;
		}
		
		System.out.println(cnt);
	}
}