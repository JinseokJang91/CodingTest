package programmers.allProblems.lv1;

public class LV1_11 {

	public static void main(String[] args) {
		SolutionLV1_11 sol = new SolutionLV1_11();
		//int[] absolutes = {4,7,12};
		//boolean[] signs = {true,false,true};
		int[] absolutes = {1,2,3};
		boolean[] signs = {false,false,true};
		int answer = sol.solution(absolutes, signs);

	}

}

class SolutionLV1_11 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 123456789;
        
        //월간 코드 챌린지 시즌2 > 음양 더하기
        int sum = 0;
        for(int i=0; i<absolutes.length; i++) {
        	if(signs[i] == true) {
        		sum += absolutes[i];
        	}else {
        		sum -= absolutes[i];
        	}
        }
        System.out.println("sum : " + sum);
        answer = sum;
        
        return answer;
    }
}