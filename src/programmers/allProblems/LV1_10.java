package programmers.allProblems;

public class LV1_10 {

	public static void main(String[] args) {
		SolutionLV1_10 sol = new SolutionLV1_10();
		int n = 10;
		int answer = sol.solution(n);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_10 {
    public int solution(int n) {
        int answer = 0;
        
        //월간 코드 챌린지 시즌3 > 나머지가 1이 되는 수 찾기
        if(n >= 3 && n <= 1000000) {
        	//n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return
        	//n % x = 1 이 되는 가장 작은 자연수
        	//나머지가 1이 되려면 x는 무조건 n보다 1이상 작은 숫자
        	
        	for(int i=1; i<n; i++) {
        		if(n % i == 1) {
        			System.out.println("i : " + i);
        			answer = i;
        			break; //가장 작은 숫자 구하는 거기 때문에 break써서 바로 빠져나온다.
        		}
        	}
        }
        
        return answer;
    }
}