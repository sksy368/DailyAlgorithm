package December.week3;

import java.util.*;
import java.io.*;

public class Main_BJ_2082_시계 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String[][] num = {{"###", "#.#", "#.#", "#.#", "###"}, {"..#", "..#", "..#", "..#", "..#"}, {"###", "..#", "###", "#..", "###"},
				{"###", "..#", "###", "..#", "###"}, {"#.#", "#.#", "###", "..#", "..#"}, {"###", "#..", "###", "..#", "###"},
				{"###", "#..", "###", "#.#", "###"}, {"###", "..#", "..#", "..#", "..#"}, {"###", "#.#", "###", "#.#", "###"},
				{"###", "#.#", "###", "..#", "###"}};
		
		String[][] input = new String[5][4];
		
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 4; j++) input[i][j] = st.nextToken();
		}
		
		String hour = "";
		String minute = "";
		
		for(int i = 0; i < 4; i++) {
			boolean flag = true;
			int min = -1;
			
			loop : for(int n = 0; n < 10; n++) {
				flag = true;
				for(int j = 0; j < 5; j++) {
					if((input[j][i].charAt(0) == '#' && num[n][j].charAt(0) == '.')
							|| (input[j][i].charAt(1) == '#' && num[n][j].charAt(1) == '.')
							|| (input[j][i].charAt(2) == '#' && num[n][j].charAt(2) == '.')) {
						flag = false; 
						break;
					}
					
					if(j == 4) {
						min = n; 
						break loop;
					}
				}
			}
			
			if(flag) {
				if(hour.length() != 2) hour += min;
				else minute += min;
			}
		}
		
		System.out.println(hour + ":" + minute);
	}
}