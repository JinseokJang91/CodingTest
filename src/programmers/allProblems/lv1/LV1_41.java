package programmers.allProblems.lv1;

public class LV1_41 {

	public static void main(String[] args) {
		SolutionLV1_41 sol = new SolutionLV1_41();
		//String s = "pPoooyY";
		String s = "Pyy";
		boolean answer = sol.solution(s);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_41 {
    boolean solution(String s) {
        //연습문제 > 문자열 내 p와 y의 개수
    	boolean answer = true;

    	int pCnt = 0;
    	int yCnt = 0;
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i) == 'p' || s.charAt(i) == 'P') {
        		pCnt++;
        	}
        	
        	if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
        		yCnt++;
        	}
        }
        
        if(pCnt == yCnt) {
        	answer = true;
        }else {
        	answer = false;
        }
        
        //count를 하나로 해서 하나는 +, 하나는 -로 하는 방식도 있음
        //toLowerCase() 또는 toUpperCase()를 사용해 조건을 하나로 줄이는 방식도 있음

        return answer;
    }
}