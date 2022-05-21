package programmers.allProblems.lv1;

public class LV1_25 {

	public static void main(String[] args) {
		SolutionLV1_25 sol = new SolutionLV1_25();
		//String phone = "01033334444";
		String phone = "027778888";
		String answer = sol.solution(phone);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_25 {
    public String solution(String phone_number) {
    	
    	//연습문제 > 핸드폰 번호 가리기
        String answer = "";
        
        int frontLen = phone_number.length() - 4;
        System.out.println(phone_number.substring(phone_number.length() - 4));
        for(int i=0; i<frontLen; i++) {
        	answer += "*";
        }
        answer += phone_number.substring(phone_number.length() - 4);
        
        return answer;
    }
}