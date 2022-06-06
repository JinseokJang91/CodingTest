package programmers.allProblems.lv1;

public class LV1_36 {

	public static void main(String[] args) {
		SolutionLV1_36 sol = new SolutionLV1_36();
		String s = "+1234";
		int answer = sol.solution(s);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_36 {
    public int solution(String s) {
        
    	//연습문제 > 문자열을 정수로 바꾸기
    	int answer = 0;
        
    	//앞에 부호(+,-)가 붙어서 substring이나 indexOf등 String 메소드로 처리해줘야 한다고 생각할 수 있지만
    	//+,- 부호가 붙어있어도 바로 parse가 되는 것을 확인할 수 있는 문제
    	answer = Integer.parseInt(s);
        
        return answer;
    }
}