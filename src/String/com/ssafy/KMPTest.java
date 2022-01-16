package String.com.ssafy;

import java.util.*;
import java.io.*;

public class KMPTest {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int tLength = text.length;
		int pLength = pattern.length;
		
		// 부분 일치 테이블 작성
		int[] pi = new int[pLength];
		for(int i = 1, j = 0; i < pLength; i++) { // i:접미사 포인터, j:접두사 포인터
			while(j>0 && pattern[i]!=pattern[j])
				j = pi[j-1];
			
			if(pattern[i] == pattern[j]) pi[i] = ++j;
			else pi[i] = 0;
		}
		
		int cnt = 0; // 텍스트에서의 패턴 개수
		ArrayList<Integer> list = new ArrayList<Integer>(); // 텍스트와 패턴이 일치하는 시작 인덱스
		
		for(int i = 0, j = 0; i < tLength; i++) { // i:텍스트 포인터, j:패턴 포인터
			while(j>0 && text[i]!=pattern[j])
				j = pi[j-1];
			
			if(text[i] == pattern[j]) { // 두 글자가 일치하는 경우
				if(j == pLength-1) { // 텍스트와 패턴이 완전히 일치하는 경우
					++cnt;
					list.add(i+1-pLength);
					j = pi[j];
				} else // 텍스트와 패턴이 일치하고 있는 경우 (패턴 앞쪽 일치하며 진행중인 상황)
					++j;	
			}
		}
		
		System.out.println(cnt);
		 
		if(cnt > 0)
			System.out.println(list);
	}
}