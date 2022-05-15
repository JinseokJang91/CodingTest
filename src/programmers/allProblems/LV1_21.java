package programmers.allProblems;

public class LV1_21 {

	public static void main(String[] args) {
		SolutionLV1_21 sol = new SolutionLV1_21();
		int price = 3;
		int money = 20;
		int count = 4;
		long answer = sol.solution(price, money, count);
		System.out.println("answer : " + answer);
	}
	
}

class SolutionLV1_21 {
    public long solution(int price, int money, int count) {
    	
    	// 위클리 챌린지 > 부족한 금액 계산하기
        long answer = -1;
        
        // 놀이기구를 N번 째 이용한다면 기존 이용료의 N배를 받는다.
        // 기존 이용료 : 3
        // 가지고 있는 돈 : 20
        // 이용 횟수 : 4
        // 3 + 6 + 9 + 12 = 30
        
        //테스트 18부터 4개인가 틀린 이유는
        //price와 money를 계산하면 수가 비약적으로 커질 수 있기 때문에
        //sum 과 gap은 int가 아닌 long형으로 선언
        long sum = 0;
        for(int i=1; i<=count; i++) {
        	sum += price*i;
        	System.out.println("sum : " + sum);
        }
        
        
        long gap =  sum - money;
        if(gap > 0 ) {
        	answer = gap;
        }else {
        	answer = 0;
        }
        

        return answer;
    }
}
