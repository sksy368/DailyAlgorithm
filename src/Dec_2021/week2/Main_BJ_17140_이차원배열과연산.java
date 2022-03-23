package Dec_2021.week2;

import java.util.*;
import java.io.*;

public class Main_BJ_17140_이차원배열과연산 {
	
	static class Num implements Comparable<Num> {
		int number, cnt;
		Num(int number, int cnt){
			this.number = number;
			this.cnt = cnt;
		}
		
		public int compareTo(Num n) {
			if(this.cnt != n.cnt)
				return Integer.compare(this.cnt, n.cnt);
			else
				return Integer.compare(this.number, n.number);
		}
	}
	
	static int r, c, k, columnMaxSize, time;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[3][3];
		columnMaxSize = 3;
		time = 0;
		
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
	
			for(int j = 0; j < 3; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		while(arr[r-1][c-1] != k && ++time <= 3) {
			System.out.println(time + "초");
			if(arr.length >= columnMaxSize) {
				System.out.println("r실행");
				r(); // R 연산 실행
			}
			else {
				System.out.println("c실행");
				c(); // C 연산 실행
			}

			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++)
					System.out.print(arr[i][j] + " ");
				System.out.println();
			}
			System.out.println("maxColumnSize : " + columnMaxSize + "\n");
		}
		
		if(time > 100) System.out.println(-1);
		else System.out.println(time);
	}
	
	static void r() {
		for(int i = 0; i < arr.length; i++) {
			ArrayList<Num> list = new ArrayList<>();
			HashSet<Integer> check = new HashSet<>();
			
			for(int j = 0; j < arr[i].length; j++) {
				int num = arr[i][j];
				int beforeSize = check.size();
				int afterSize;
				
				check.add(num);
				afterSize = check.size();
				
				if(beforeSize == afterSize) {
					for(int k = 0; k < list.size(); k++) {
						if(list.get(k).number == num) {
							list.get(k).cnt++;
							break;
						}
					}
				} else
					list.add(new Num(num, 1));
			}
			
			Num[] nums = new Num[list.size()];
			for(int j = 0; j < list.size(); j++)
				nums[j] = list.get(j);
			Arrays.sort(nums);
			
			int[] result = new int[nums.length*2];
			for(int j = 0; j < nums.length; j++) {
				if(j >= 50) break;
				result[j*2] = nums[j].number;
				result[j*2+1] = nums[j].cnt;
			}
			
			arr[i] = result.clone();
			columnMaxSize = Math.max(columnMaxSize, arr[i].length); // 제일 긴 column 길이 갱신
		}
	}
	
	static void c() {
		for(int i = 0; i < columnMaxSize; i++) {
			ArrayList<Num> list = new ArrayList<>();
			HashSet<Integer> check = new HashSet<>();
			
			for(int j = 0; j < arr.length; j++) {
				if(i >= arr[j].length) break;
				
				int num = arr[j][i];
				
				int beforeSize = check.size();
				int afterSize;
				
				check.add(num);
				afterSize = check.size();
				
				if(beforeSize == afterSize) {
					for(int k = 0; k < list.size(); k++) {
						if(list.get(k).number == num) {
							list.get(k).cnt++;
							break;
						}
					}
				} else
					list.add(new Num(num, 1));
			}
			
			Num[] nums = new Num[list.size()];
			for(int j = 0; j < list.size(); j++) nums[j] = list.get(j);
			Arrays.sort(nums);
			
//			if(time == 2) {
//				for(int x = 0; x < nums.length; x++)
//					System.out.print(nums[x].number + ":" +  nums[x].cnt+ "번  ->  ");
//				System.out.println();
//			}
			
			int[] result = new int[nums.length*2];
System.out.println("result는????");
			for(int j = 0; j < nums.length; j++) {
				result[j*2] = nums[j].number;
				result[j*2+1] = nums[j].cnt;
				System.out.print(result[j*2] + " " + result[j*2+1] + " ");
			}
			System.out.println("result는????");
			for(int j = 0; j < result.length; j++) {
				try {
					arr[j][i] = result[j];
				} catch (ArrayIndexOutOfBoundsException e) {
					int[] newArray = new int[i+1];
					newArray[i] = result[j];
					int[][] tmp = new int[arr.length+1][];
					tmp = arr.clone();
					tmp[tmp.length-1] = newArray;
					arr = tmp.clone();
				}
				
//				if(j >= arr.length) {
//					int[] newArray = new int[] {result[j]};
//					int[][] tmp = new int[arr.length+1][];
//					tmp = arr.clone();
//					tmp[tmp.length-1] = newArray;
//					arr = tmp.clone();
//				}
//				else
//					arr[j][i] = result[j];
			}
		}
	}
}