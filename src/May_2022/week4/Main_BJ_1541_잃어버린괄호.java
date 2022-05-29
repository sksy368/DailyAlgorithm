package May_2022.week4;

import java.io.*;

public class Main_BJ_1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String statement = br.readLine() + "+0";
		
		String num = "";
		boolean minus = false;
		int answer = 0;
		
		for(int i = 0; i < statement.length(); i++) {
			char c = statement.charAt(i);
			
			if(c >= '0' && c <= '9') // 숫자인 경우
				num += c;
			else {
				if(c == '-' && !minus) { // -가 처음인 경우
					answer += Integer.parseInt(num); // 수를 더함
					minus = true;
				}
				else {
					if(minus) answer -= Integer.parseInt(num);
					else answer += Integer.parseInt(num);
				}

				num = "";
			}
		}
		
		System.out.println(answer);
	}
}