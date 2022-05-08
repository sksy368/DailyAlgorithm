package May_2022.week1;

import java.util.*;

public class Recruitment_2022_썸머코딩여름방학스타트업인턴프로그램_2 {
	class Emp implements Comparable<Emp> {
        String name;
        int dis, cnt;
        Emp(String name, int dis, int cnt){
            this.name = name; // 사원 이름
            this.dis = dis; // 해당 호수까지의 거리
            this.cnt = cnt; // 자리 개수
        }

        public int compareTo(Emp e){
            if(this.cnt != e.cnt) return this.cnt - e.cnt; // 정렬 기준 1순위: 자리 개수
            else if(this.dis != e.dis) return this.dis - e.dis; // 정렬 기준 2순위: 거리
            else{ // 정렬 기준 3순위: 이름
                int size = Math.min(this.name.length(), e.name.length());
                for(int i = 0; i < size; i++){
                    if(this.name.charAt(i) != e.name.charAt(i)) return this.name.charAt(i)-e.name.charAt(i);
                }
            }
            return this.name.length() - e.name.length();
        }
    }
	

    public String[] solution(String[] rooms, int target) {

        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, int[]> map = new HashMap<>();
        PriorityQueue<Emp> pq = new PriorityQueue<>();

        Set<String> set = new HashSet<>(); // 해당 호수에 이미 자리가 있는 사원들 이름

        for(int i = 0; i < rooms.length; i++){
            int[] room = printRoomNo(rooms[i]);
            String[] people = rooms[i].substring(room[0]+1).split(",");

            for(int j = 0; j < people.length; j++){
                if(room[1] == target || set.contains(people[j])){ // 해당 호수에 이미 자리가 있는 경우
                    set.add(people[j]);
                    continue;
                }

                int d = Math.abs(room[1]-target); // 해당 호수까지의 거리
                if(map.containsKey(people[j])) {
                    int[] r = map.get(people[j]);
                    map.put(people[j], new int[]{Math.min(r[0], d), r[1]+1});
                }
                else map.put(people[j], new int[]{d, 1});
            }
        }

        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();

        while(it.hasNext()) {
        	String s = (String) it.next();
            if(set.contains(s)) continue; // 해당 호수에 이미 자리가 있는 사원일 경우
        	int[] r = map.get(s);
        	pq.offer(new Emp(s, r[0], r[1]));
        }

        while(!pq.isEmpty()) answer.add(pq.poll().name);

        return answer.toArray(new String[0]);
    }
 

    public int[] printRoomNo(String s) { // 호수 추출하는 메서드
        String result = "";
        int idx = 0;

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ']') {
                idx = i;
                break;
            }

            result += s.charAt(i);
        }

        return new int[] {idx, Integer.parseInt(result)};
    }
}