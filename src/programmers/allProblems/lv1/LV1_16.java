package programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.List;

public class LV1_16 {

	public static void main(String[] args) {
		SolutionLV1_16 sol = new SolutionLV1_16();
		int n = 45;
		//int n = 125;
		//int n = 1;
		int answer = sol.solution(n);
		System.out.println("answer : " + answer);

	}

}

class SolutionLV1_16 {
    public int solution(int n) {
        
    	//월간 코드 챌린지 시즌1 > 3진법 뒤집기
    	int answer = 0;
        
        //자연수 n(10진법)을 3진법으로 표기 후 3진법을 앞뒤 반전 시킨 다음 10진법으로 표현
    	//n이 45면, 45 -> 1200 -> 0021 -> 7
    	//n이 125면, 125 -> 11122 -> 22111 -> 229
    	
    	// 정리하면,
    	// 1. n을 3진법으로 표기
    	// 2. 3진법 숫자를 뒤집기
    	// 3. 다시 10진법으로 나타내기
    	
    	// n은 1 이상 1억(100,000,000) 이하의 자연수
    	
    	// * 3진법으로 나타내기
    	// - 3진법 각 자릿수는 0~2까지 가능하다. (2진법은 0,1로 나타내는 것처럼)
    	//	 1200 이면 3^3 * 1 + 3^2 * 2 + 3^1 * 0 + 3^0 * 0 = 27 + 18 = 45
    	// - 45/3=15..0 -> 15/3=5..0 -> 5/3=1..2 ===> 마지막 몫 + 나머지들 값 = 1 + 2 + 0 + 0
    	// - 125/3=41..2 -> 41/3=13..2 -> 13/3=4..1 -> 4/3=1..1 ===> 1 + 1 + 1 + 2 + 2
    	
    	// 3진법으로 바꾼 값을 역순으로 List에 넣어준 다음 각 자릿수를 3진법으로 계산해서 결과를 도출
    	List<Integer> reverse = new ArrayList<Integer>();
    	
    	if(n < 3) { //n이 3보다 작으면 3진법 표기 시 0으로 나타나므로 역으로 뒤집어도 0, 따라서 n값을 그대로 리턴
    		return n;
    	}else {
    		reverse = ternaryScale(n);
        	int result = 0;
        	System.out.println("math : " + Math.pow(3, 3));
        	for(int i=0; i<reverse.size(); i++) {
        		result += ((int)Math.pow(3, reverse.size()- 1 - i)) * reverse.get(i);
        		System.out.println("result : " + result);
        	}
        	answer = result;
        	
            return answer;
    	}
    	
    	//다른 사람들 풀이
    	//Integer.parseInt("1200", 3) -> parseInt로 진수 표현이 가능하다. 1200을 3진수로 변환한다는 말
    	//System.out.println("### : " + Integer.parseInt("1200", 3));
    }
    
    public List<Integer> ternaryScale(int n) {
    	
    	List<Integer> reverse = new ArrayList<Integer>();
    	int rest = 0;
    	int shareResult = n;
    	int lastShare = 0;
    	while(shareResult >= 3) {
    		
    		rest = shareResult % 3;
    		shareResult /= 3;
    		reverse.add(rest);
    		System.out.println("rest : " + rest);
    		System.out.println("shareResult : " + shareResult);
    		if(shareResult < 3) {
    			lastShare = shareResult;
    			reverse.add(lastShare);
    			break;
    		}
    	}
    	
    	System.out.println("lastShare : " + lastShare);
    	System.out.println("result : " + reverse);
    	
    	return reverse;
    }
}
