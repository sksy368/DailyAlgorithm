package May_2022.week1;

public class Recruitment_2022_썸머코딩여름방학스타트업인턴프로그램_3 {
	
	static int[] left;
	static int[] right;
	static int[] answer;
	
	public int[] solution(String line) {
        answer = new int[line.length()];
        left = new int[] {1, 0};
        right = new int[] {1, 9};

        String alpha = "QWERTYUIOP";

        for(int i = 0; i < line.length(); i++) {
        	char c = line.charAt(i);
        	int num = -1, idx = -1, leftDiff = -1, rightDiff = -1; // 숫자, 문자인 경우에 위치한 인덱스, 왼쪽 손가락에서의 거리, 오른쪽 손가락에서의 거리

        	if(c >= '0' && c < '9') { // 숫자인 경우
        		num = Integer.parseInt(c+"");
        		if(num == 0) num = 10;
        		leftDiff = Math.abs(left[0] - 0) + Math.abs(left[1] - (num-1));
        		rightDiff = Math.abs(right[0] - 0) + Math.abs(right[1] - (num-1));
        	} else { // 문자인 경우
        		idx = alpha.indexOf('c');
        		leftDiff = Math.abs(left[0] - 1) + Math.abs(left[1] - idx);
        		rightDiff = Math.abs(right[0] - 1) + Math.abs(right[1] - idx);
        	}

        	if(leftDiff > rightDiff) set(false, i, new int[] {0, num-1}); // 오른쪽 손가락에서 더 가까운 경우
    		else if (leftDiff < rightDiff) set(true, i, new int[] {0, num-1}); // 왼쪽 손가락에서 더 가까운 경우
    		else { // 두 손가락에서의 거리가 같은 경우
    			if(num != -1) { // 숫자인 경우
    				if(left[0] == 0) set(true, i, new int[] {0, num-1}); // 왼쪽 손가락과 수평 거리가 같은 경우
    				else if(right[0] == 0) set(false, i, new int[] {0, num-1}); // 오른쪽 손가락과 수평 거리가 같은 경우
    				else if(num > 0 && num < 6) set(true, i, new int[] {0, num-1}); // 키보드 왼쪽에 위치한 경우
    				else set(false, i, new int[] {0, num-1}); // 키보드 오른쪽에 위치한 경우
    			} else { // 문자인 경우
					if(left[0] == 1) set(true, i, new int[] {1, num-1}); // 왼쪽 손가락과 수평 거리가 같은 경우
					else if(right[0] == 1) set(false, i, new int[] {0, idx}); // 오른쪽 손가락과 수평 거리가 같은 경우
					else if(idx >= 0 && num < 5) set(true, i, new int[] {0, idx}); // 키보드 왼쪽에 위치한 경우
    				else set(false, i, new int[] {0, idx}); // 키보드 오른쪽에 위치한 경우
    			}
    		}
        }

        return answer;
    }


	public void set(boolean leftOk, int idx, int[] loc) {
		if(leftOk) { // 왼쪽 손가락이 누르는 경우
			answer[idx] = 0;
			left = new int[] {loc[0], loc[1]};
		}
		else { // 오른쪽 손가락이 누르는 경우
			answer[idx] = 1;
			right = new int[] {loc[0], loc[1]};
		}
	}
}