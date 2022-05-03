package Mar_2022.week2;

import java.util.*;
import java.io.*;

public class Solution_SW_CodeBattle_오타교정시스템 {
	
	static class Search {
		int mId, searchTimestamp;
		char[] searchWord;
		Search(int mId, int searchTimestamp, char[] searchWord){
			this.mId = mId;
			this.searchTimestamp = searchTimestamp;
			this.searchWord = searchWord;
		}
	}
	
	static class DB {
		char[] wrongWord, perfectWord;
		HashSet<Integer> users = new HashSet<Integer>();
		DB(char[] wrongWord, char[] perfectWord, int userNum){
			this.wrongWord = wrongWord;
			this.perfectWord = perfectWord;
			this.users.add(userNum);
		}
	}
	
	static int num, cnt;
	static ArrayList<Search> searches;
	static ArrayList<DB> addDB, changeDB, deleteDB;
	static String right;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			init(Integer.parseInt(br.readLine()));
			
			searches = new ArrayList<>(); // 검색 기록
			addDB = new ArrayList<>(); // 오타 교정 DB(추가)
			changeDB = new ArrayList<>(); // 오타 교정 DB(치환)
			deleteDB = new ArrayList<>(); // 오타 교정 DB(삭제)
			right = "galaxy";
			cnt = 0;
			
			for(int n = 0; n < num; n++) {
				cnt += search();
			}
			
			System.out.println(cnt);
		}

	}
	
	private static char[][] words =  new char[4000][11];
	
	private static void String2Char(String s, char[] b) {
		int n = s.length();
		
		for(int i = 0; i < n; i++) {
			b[i] = s.charAt(i);
		}
		b[n] = '\0';
	}
	
	private static void inputWords(int wordCnt, Scanner sc) {
		for(int i = 0; i < wordCnt; ++i) {
			String2Char(sc.next(), words[i]);
		}
	}
	
	public static void init(int N) { // 각 testcase 시작 시 초기화를 위해 1번 호출
		num = N; // N:사용자 수
	}

	public static int search(int mId, int searchTimestamp, char[] searchWord, char[][] correctWord) {
		// mId의 사용자가 searchTimestamp 시간에 searchWord로 검색
		// 오타가 교정된 경우 교정된 단어를 correctWord에 대입하여 반환
		
		if(searches.size()+1 != searchTimestamp) {
			for(int i = 0; i < searchTimestamp-searches.size(); i++)
				searches.add(new Search(-1, searches.size(), new char[] {}));
		}
		
		Search search = new Search(mId, searchTimestamp, searchWord);
		searches.add(search); // 검색 기록 추가
		
		if(searchWord.length == right.length()) {
			int wrongCnt = 0;
			for(int i = 0; i < searchWord.length; i++)
				if(searchWord[i] != right.charAt(i)) wrongCnt++;
			
			if(wrongCnt == 1) changeDB.add(new DB(searchWord, right.toCharArray(), mId)); // 오타 교정 DB(치환)에 등록
		}
		else if(searchWord.length == right.length()+1) {
			boolean change = false;
			boolean flag = false;
			String copyRight = String.copyValueOf(right.toCharArray());
			for(int i = 0; i < searchWord.length; i++) {
				if(searchWord[i] != copyRight.charAt(i)) {
					if(!change) {
						copyRight = copyRight.substring(0, i) + searchWord[i] + copyRight.substring(i);
						change = true;
					}
					else {
						flag = true;
						break;
					}
				}
			}
			
			if(!flag) addDB.add(new DB(searchWord, right.toCharArray(), mId)); // 오타 교정 DB(추가)에 등록
		}
		else if(searchWord.length+1 == right.length()) {
			boolean change = false;
			boolean flag = false;
			String copySearchWord = String.copyValueOf(searchWord);
			for(int i = 0; i < copySearchWord.length(); i++) {
				if(right.charAt(i) != copySearchWord.charAt(i)) {
					if(!change) {
						copySearchWord = copySearchWord.substring(0, i) + right.charAt(i) + copySearchWord.substring(i);
						change = true;
					}
					else {
						flag = true;
						break;
					}
				}
			}
			
			if(!flag) deleteDB.add(new DB(searchWord, right.toCharArray(), mId)); // 오타 교정 DB(삭제)에 등록
		}
		
		if(searchTimestamp < 10) return 0;
		
		for(int i = 0; i < searches.size(); i++) {
			Search before = searches.get(i);
			
			if(before.mId == mId) { // 10초 이내에 사용자의 이전 검색이 존재하는 경우
				
			}
		}
		
		searches.remove(0);
	}
}
