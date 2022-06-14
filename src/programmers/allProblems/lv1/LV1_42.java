package programmers.allProblems.lv1;

public class LV1_42 {

	public static void main(String[] args) {
		SolutionLV1_42 sol = new SolutionLV1_42();
		String s = "try hello world";
		String answer = sol.solution(s);
	}
	
}

class SolutionLV1_42 {
    public String solution(String s) {
        String answer = "";
        
        String[] sArr = s.split(" ");
        
        for(int i=0; i<sArr.length; i++){
            for(int j=0; j<sArr[i].length(); j++){
                String s1 = sArr[i].toUpperCase();
                String s2 = sArr[i].toLowerCase();
                if(j % 2 == 0){
                    answer += s1.charAt(j);
                }else{
                    answer += s2.charAt(j);
                }
            }
            answer += " ";
        }
        answer = answer.trim();
        System.out.println("answer : " + answer);
        
        return answer;
    }
}
