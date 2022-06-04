package Jun_2022.week1;

public class Recruitment_2022_나이스디앤비_4 {
	
	static long max;
	
	public long solution(int n) {
		max = 0;
		bestSum(n, n, 0, 1);
		return max;
	}
	
	public void bestSum(int i, int n, int sum, long mul) {
		if(n <= 0 || sum > i) return;
		else if(sum == i) max = Math.max(max, mul);
		else {
			if(n+sum > i) {
				while(n+sum > i) n--;
			}
			
			bestSum(i, n, sum+n, mul*n);
			bestSum(i, n-1, sum, mul);
		}
	}
}