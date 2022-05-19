package programmers.allProblems;

public class LV1_26 {

	public static void main(String[] args) {
		SolutionLV1_26 sol = new SolutionLV1_26();
		//int[] arr = {1,2,3,4};
		int[] arr = {5, 5};
		double answer = sol.solution(arr);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_26 {
    public double solution(int[] arr) {
    	
    	//연습문제 > 평균 구하기
        double answer = 0;
        
        double sum = 0;
        for(int i=0; i<arr.length; i++) {
        	sum += arr[i];
        }
        System.out.println("sum : " + sum);
        answer = sum / arr.length;
        
        return answer;
    }
}