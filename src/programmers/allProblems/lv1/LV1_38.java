package programmers.allProblems.lv1;

public class LV1_38 {

	public static void main(String[] args) {
		SolutionLV1_38 sol = new SolutionLV1_38();
		int n = 987;
		int answer = sol.solution(n);
		System.out.println("answer : " + answer);

	}

}

class SolutionLV1_38 {
    public int solution(int n) {
    	//연습문제 > 자릿수 더히기
    	int answer = 0;

    	String val = String.valueOf(n);
    	for(int i=0; i<val.length(); i++) {
    		answer += Integer.valueOf(String.valueOf(val.charAt(i)));
    	}

        return answer;
    }
}