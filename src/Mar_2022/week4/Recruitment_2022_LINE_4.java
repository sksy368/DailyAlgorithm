package Mar_2022.week4;

public class Recruitment_2022_LINE_4 {
	
	public int solution(int[] arr, int[] brr) { // 초기 셀들의 너비, 원하는 셀들의 너비
		int answer = 0;
		
		while(true) {
			boolean flag = false;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] != brr[i]) { // 셀의 너비와 원하는 셀의 너비가 다른 경우가 있는 경우
					flag = true;
					break;
				}
			}
			if(!flag) break; // 셀의 너비와 원하는 셀의 너비가 전부 같은 경우
			
			for(int i = 0; i < arr.length-1; i++) {
				if(arr[i] == brr[i]) continue;
				
				int sub = arr[i] - brr[i]; // 셀의 너비와 원하는 셀의 너비의 차이
				
				for(int j = 0; j < Math.abs(sub); j++) {
					if(sub > 0) { // 셀의 너비가 더 큰 경우
						arr[i] -= 1;
						arr[i+1] += 1;
					}
					else { // 원하는 셀의 너비가 더 큰 경우
						if(arr[i+1] <= 1) break; // 길이가 1이하인 경우 더이상 줄이지 못함
						arr[i] += 1;
						arr[i+1] -= 1;
					}
				}
				
				answer++;
			}
		}
		
		return answer;
	}
}