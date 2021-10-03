package Greedy.com.ssafy.Practice_0817;

import java.util.*;

public class Main_JOL_1828_냉장고 {
     
    static class Chemi implements Comparable<Chemi> {
        int low, high;
        Chemi (int low, int high){
            this.low = low;
            this.high = high;
        }
         
        public int compareTo(Chemi c) {
            int value = this.low - c.low;
            if(value == 0) value = this.high - c.high;
             
            return value;
        }
    }
     
     
    public static void main(String[] args) throws Exception {
        Scanner scanner= new Scanner(System.in);
         
        int N = scanner.nextInt(); // 화학물질의 수
        Chemi[] chemicals = new Chemi[N];
         
        for(int i = 0; i < N; i++) {
            int low = scanner.nextInt();
            int high = scanner.nextInt();
             
            chemicals[i] = new Chemi(low, high);
        }
         
        Arrays.sort(chemicals);
         
        int low = 10001;
        int high = -271;
        int cnt = 0;
        for(int i = 0; i < N; i++) { // 겹치는 부분이 없을 때까지 범위 갱신 (겹치는 부분이 없으면 냉장고 개수 증가)
            if(chemicals[i].low > high) { // 현재 온도 범위로 화학물질 i를 보관할 수 없는 경우
                cnt++;
                low = chemicals[i].low;
                high = chemicals[i].high;
            }
            else {
                low = Math.max(chemicals[i].low, low);
                high = Math.min(chemicals[i].high, high);
            }
        }
         
        System.out.println(cnt);
    }
}