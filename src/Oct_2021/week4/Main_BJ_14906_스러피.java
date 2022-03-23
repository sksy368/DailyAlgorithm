package Oct_2021.week4;

import java.io.*;

public class Main_BJ_14906_스러피 {
	
	public static boolean isSlimp(String s) {
		if(s.length() < 2) return false;
		
		else if(s.length() == 2) {
			if("AH".equals(s)) return true;
			else return false;
		}
		else {
			if(s.charAt(1) == 'B')
				return isSlimp(s.substring(2, s.length()-1));
			else
				return isSlimp(s.substring(1, s.length()-1));
		}
	}
	
	public static boolean isSlump(String s) {
		if(s.length() < 3) return false;
		
		else if(s.charAt(0) == 'D' || s.charAt(0) == 'E') {
			if(s.length() == 1) return true;
			
			int idx = 1;
			while(idx < s.length() && s.charAt(idx) == 'F') idx++;
			s = s.substring(0, idx);
			
			if((s.length() == 1 && s.charAt(idx) == 'G') || isSlump(s)) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());

		System.out.println("SLURPYS OUTPUT");
		
		for(int i = 0; i < num; i++) {
			String s = br.readLine();
			
			int cut = s.length() - 1;
			
			while(cut >= 0 && s.charAt(cut) != 'C' && s.charAt(cut) != 'H') {
				cut--;
			}
			
			if(isSlimp(s.substring(0, cut+1)) && isSlump(s.substring(cut+1)))
				System.out.println("YES");
			else
				System.out.println("NO");
			
		}
		System.out.println("END OF OUTPUT");
	}
}
