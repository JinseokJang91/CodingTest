package programmers.stackqueue;

public class StackQueue1 {

	public static void main(String[] args) {
		SolutionStackQueue1 sol = new SolutionStackQueue1();
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		int[] answer = {};
		answer = sol.solution(progresses, speeds);

	}

}

class SolutionStackQueue1 {
    public int[] solution(int[] progresses, int[] speeds) {
        
    	//스택/큐 > 기능 개발
    	int[] answer = {};
        
    	//뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있음
    	//뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포
    	
    	//progresses : 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 배열
    	//speeds : 각 작업의 개발 속도가 적힌 배열
    	
    	//
    	
    	
        return answer;
    }
}