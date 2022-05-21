package programmers.allProblems.lv1;

public class LV1_23 {

	public static void main(String[] args) {
		SolutionLV1_23 sol = new SolutionLV1_23();
		int x = -4;
		int n = 2;
		long[] answer = sol.solution(x, n);
		for(int i=0; i<answer.length; i++) {
			System.out.printf("%d ", answer[i]);
		}System.out.println();

	}

}

class SolutionLV1_23 {
    public long[] solution(int x, int n) {
    	
    	//연습문제 > x만큼 간격이 있는  n개의 숫자
        long[] answer = {};
        
        answer = new long[n];
        for(int i=1; i<=n; i++) {
        	answer[i-1] = (long) x * i;
        }
        // (long) x * i 해야되는 이유
        // (long) (x * i) 를 하면 (x * i)가 int로 계산된 후에 long 타입으로 바꾸는 것이고,
        // (long) x * i 를 하면 x가 long타입으로 바뀐 후에 i랑 계산되므로 결과값도 long이 된다.
        
        
        return answer;
    }
}