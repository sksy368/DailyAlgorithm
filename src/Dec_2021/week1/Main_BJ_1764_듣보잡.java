package Dec_2021.week1;

import java.io.*;
import java.util.*;

public class Main_BJ_1764_듣보잡 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수
		
		String[] neverHeard = new String[N]; // 듣도 못한 사람 이름
		String[] neverSeen = new String[M]; // 보도 못한 사람 이름
		HashSet<String> total = new HashSet<>();
		TreeSet<String> answer = new TreeSet<>();
		
		for(int n = 0; n < N; n++) {
			neverHeard[n] = br.readLine();
			total.add(neverHeard[n]);
		}
		
		for(int m = 0; m < M; m++) {
			neverSeen[m] = br.readLine();
			
			int beforSize = total.size();
			total.add(neverSeen[m]);
			
			if(beforSize == total.size())
				answer.add(neverSeen[m]);
		}
		
		bw.write(answer.size() + "\n");
		
		Iterator<String> it = answer.iterator();
		while(it.hasNext()) {
			bw.write(it.next() + " \n");
		}
		
		bw.flush();
		bw.close();
	}
}