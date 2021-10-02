package September_2;

import java.util.*;
import java.io.*;

public class Main_BJ_1918_후위표기식 {
	
	static int priority(char c) {
		if(c == '*' || c == '/') return 0;
		if(c == '+' ||  c == '-') return 1;
		return 2;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		Stack<Character> op = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') // 피연산자인 경우 → 출력
				System.out.print(s.charAt(i));
			
			else { // 연산자인 경우
				if(s.charAt(i) == ')') {
					while(op.peek() != '(') System.out.print(op.pop());
					op.pop(); // '(' 버림
				}
				
				else if(op.isEmpty() || s.charAt(i) == '(' || op.peek() == '(') // 1. 스택이 비어 있거나, 여는 괄호일 경우
					op.push(s.charAt(i));

				else {
					while(!op.isEmpty() && priority(s.charAt(i)) >= priority(op.peek())) { //s.charAt(i)가 우선순위가 낮은 경우
						if(op.peek() == '(') {
							op.pop();
							continue;
						}
						System.out.print(op.pop());
					}
					op.push(s.charAt(i));
				}
			}
		}
		
		while(!op.empty()) System.out.print(op.pop());
	}
}