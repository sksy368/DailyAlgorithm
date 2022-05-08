package May_2022.week1;

public class Recruitment_2022_썸머코딩스타트업인턴프로그램 {
	public int solution(int[][] atmos) {

        int answer = 0;
		int day = 0;

		for(int i = 0; i < atmos.length; i++) {

			if(day > 2) day = 0;

			if(atmos[i][0] >= 151 && atmos[i][1] >=76) { // 둘 다 매우나쁨 일 때
				if(day > 2 || day == 0) answer++;
				day = 0;
			}

			else if(atmos[i][0] >= 81 || atmos[i][1] >= 36) { //  나쁨일때
                if(day > 2 || day == 0) {
                    answer++;
                    day = 0;
                }
				day++;
			}
			
            else if(day != 0) day++;
            
		}

		return answer;

    }
}