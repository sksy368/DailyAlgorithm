package May_2022.week1;

public class Recruitment_2022_썸머코딩여름방학스타트업인턴프로그램_1 {
	public int solution(int[][] atmos) {

        int answer = 0;
		int day = 0;

		for(int i = 0; i < atmos.length; i++) {

			if(day > 2) day = 0;

			if(atmos[i][0] >= 151 && atmos[i][1] >=76) { // 둘 다 매우나쁨 일 때
				if(day > 2 || day == 0) answer++;
				day = 0;
			}

			else if(atmos[i][0] >= 81 || atmos[i][1] >= 36) { //  나쁨 일 때
                if(day > 2 || day == 0) {
                    answer++;
                    day = 0;
                }
				day++;
			}
			
            else if(day != 0) day++; // 마스크를 착용하지 않더라도 착용 시간 갱신
            
		}

		return answer;
    }
}