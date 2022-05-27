package programmers.allProblems.lv1;

public class LV1_29 {

	public static void main(String[] args) {
		SolutionLV1_29 sol = new SolutionLV1_29();
		int num = 626331;
		int answer = sol.solution(num);
		System.out.println("answer : " + answer);

	}

}

class SolutionLV1_29 {
    public int solution(int num) {
    	//연습문제 > 콜라츠 추측
        int answer = 0;
        
        //주어진 수가 1이 될 때까지 작업 반복
        //1. 입력된 수가 짝수라면 2로 나눔
        //2. 입력된 수가 홀수라면 3을 곱하고 1을 더함
        //num은 1이상 8,000,000 미만인 정수 -> int형 범위에 대해 생각해야 함
        
        int count = 0;
        
        if(num == 1) {
        	answer = 0;
        	return answer;
        }
        long overNum = (long)num;
        
        while(true) {
        	if(overNum % 2 == 0) {
        		overNum /= 2;
        	}else {
        		overNum = overNum * 3 + 1;
        	}
        	count++;
        	//System.out.println("num : " + overNum);
        	//System.out.println("count : " + count);
        	
        	if(count >= 500) {
        		answer = -1;
        		break;
        	}
        	
        	if(overNum == 1) {
        		answer = count;
        		break;
        	}
        	
        }
        
        return answer;
    }
}