package programmers.allProblems.lv1;

public class LV1_35 {

	public static void main(String[] args) {
		SolutionLV1_35 sol = new SolutionLV1_35();
		int n = 4;
		String answer = sol.solution(n);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_35 {
    public String solution(int n) {
        
    	//연습문제 > 수박수박수박수박수수박수?
    	String answer = "";
        
        /*
        for(int i=1; i<=n; i++){
            if(i%2 == 1){
                answer += "수";
            }else{
                answer += "박";
            }
        }
        */
        //System.out.println("answer : " + answer);
        
    	//아래 방법이 훨씬 빠름
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            if(i%2 == 1){
                sb.append("수");
            }else{
            	sb.append("박");
            }
        }
        System.out.println("sb : " + sb.toString());
        
        return answer;
    }
}