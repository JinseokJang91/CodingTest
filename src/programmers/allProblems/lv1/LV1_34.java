package programmers.allProblems.lv1;

public class LV1_34 {

	public static void main(String[] args) {
		SolutionLV1_34 sol = new SolutionLV1_34();
		int n = 12;
		int answer = sol.solution(n);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_34 {
    public int solution(int n) {
    	
    	//연습문제 > 약수의 합
        int answer = 0;
        
        for(int i=1; i<=n; i++){
            if(n % i == 0){
                answer += i;
            }
        }
        
        return answer;
    }
}