package Mar_2022.week4;

import java.util.*;

public class Recruitment_2022_LINE_3 {
	
	public static void solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) { // 팀의 개수, 재택인 업무들, 출근해야 하는 업무들, 사원들 정보
		StringTokenizer st; 
		boolean[] workOffice = new boolean[num_teams+1]; // 출근해야 하는 업무인 팀원이 있는 팀인 경우
		HashSet<String> office = new HashSet<>();
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayList<Integer>[] list = new ArrayList[num_teams+1];
		
		for(int i = 1; i <= num_teams; i++) list[i] = new ArrayList<>();
		for(int i = 0; i < office_tasks.length; i++) office.add(office_tasks[i]); // 출근해야 하는 업무들 set 만들기
		
		for(int i = 1; i <= employees.length; i++) {
			st =  new StringTokenizer(employees[i-1]);
			
			int no = Integer.parseInt(st.nextToken()); // 사원의 번호
			String task = st.nextToken(); // 사원이 맡은 업무
			
			if(office.contains(task)) workOffice[no] = true; // 출근해야 하는 업무인 경우 
			else list[no].add(i);
		}
		
		
		for(int i = 1; i <= num_teams; i++) {
			if(!workOffice[i]) { // 재택 업무인 팀원들만 있는 경우
				for(int j = 1; j < list[i].size(); j++) ans.add(list[i].get(j)); // 첫번째 사원(j=0) 제외하고 전부 추가
			}
			else ans.addAll(list[i]); // 출근해야 하는 업무인 팀원이 있는 경우, 팀 내에서 재택 업무인 팀원들 전부 추가
		}
		
		int[] answer = new int[ans.size()];
		for(int i = 0; i < ans.size(); i++) answer[i] = ans.get(i); // 순열리스트를 배열로 변환
		Arrays.sort(answer); // 정렬
	}
}
