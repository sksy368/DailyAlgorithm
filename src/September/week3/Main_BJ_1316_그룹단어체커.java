package September.week3;

import java.util.*;

public class Main_BJ_1316_그룹단어체커 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		
		for(int n = 0; n < N; n++) {
			String word = sc.next()+'?';
			boolean[] check = new boolean[26];
			
			cnt++;
			for(int i = 0; i < word.length()-1; i++) {
				if(word.charAt(i) == word.charAt(i+1)) continue;
				else {
					if(check[word.charAt(i) - 'a']) {
						cnt--;
						break;
					}
					check[word.charAt(i) - 'a'] = true;
				}
			}
		}
		System.out.println(cnt);
	}
}
