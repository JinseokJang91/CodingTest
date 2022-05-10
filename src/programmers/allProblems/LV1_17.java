package programmers.allProblems;

public class LV1_17 {

	public static void main(String[] args) {
		SolutionLV1_17 sol = new SolutionLV1_17();
		String s = "abcd";
		String answer = sol.solution(s);
		System.out.println("answer : " + answer);

	}

}

class SolutionLV1_17 {
    public String solution(String s) {
    	
    	//연습문제 > 가운데 글자 가져오기
        String answer = "";
        
        //단어의 길이가 홀수라면 가운데 한 글자를 반환
        //단어의 길이가 짝수라면 가운데 두 글자를 반환
        StringBuilder sb = new StringBuilder();
        
        int length = s.length();
        int oddIdx = 0;
        int evenIdx1 = 0;
        int evenIdx2 = 0;
        
        if(length % 2 == 1) {
        	oddIdx = length / 2;
        	//answer += s.charAt(oddIdx);
        	sb.append(s.charAt(oddIdx));
        }else {
        	evenIdx2 = length / 2;
        	evenIdx1 = evenIdx2 - 1;
        	
        	//answer += s.charAt(evenIdx1);
        	//answer += s.charAt(evenIdx2);
        	sb.append(s.charAt(evenIdx1));
        	sb.append(s.charAt(evenIdx2));
        }
        System.out.println("sb : " + sb);
        answer = sb.toString();
        
        //answer += 하는 것보다 StringBuilder가 훨씬 빠르다.
        //answer += 는 10몇ms, StringBuilder는 0.0몇ms 나옴
        
        return answer;
    }
}