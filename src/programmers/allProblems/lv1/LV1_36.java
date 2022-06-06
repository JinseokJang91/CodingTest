package programmers.allProblems.lv1;

public class LV1_36 {

	public static void main(String[] args) {
		SolutionLV1_36 sol = new SolutionLV1_36();
		String s = "-1234";
		int answer = sol.solution(s);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_36 {
    public int solution(String s) {
        
    	//연습문제 > 문자열을 정수로 바꾸기
    	int answer = 0;
        
    	//앞에 부호(+,-)가 붙어서 substring이나 indexOf등 String 메소드로 처리해줘야 한다고 생각할 수 있지만
    	//+,- 부호가 붙어있어도 바로 parse가 되는 것을 확인할 수 있는 문제
    	//또 이런 문제를 parse를 쓰지 않고 알고리즘으로 풀어보는 방향으로 생각할 수 있는 문제이기도 함
    	answer = Integer.parseInt(s);
    	
    	//parseInt를 쓰지 않는다면 ( 예를 들어 문제가 #을 +부호, @를 -부호로 생각해라는 식으로 나올 수 있기 때문에)

    	//유니코드 범위 확인
    	char a = '7'; // 48~57 -> 0~9
    	System.out.println("a : " + (a - '1'));
    	
    	int result = cal(s);
    	System.out.println("result : " + result);
        
        return answer;
    }
    
    public int cal(String s) {
    	
    	int digit = 0;				//자릿수
    	int value = 0;				//더할값
    	int sum = 0;				//더한 결과값
    	char mark = s.charAt(0);	//맨 앞자리 확인
    	
    	//부호가 있는 경우
    	if(mark < '1' || mark > '9') {
    		for(int i=s.length()-1; i>0; i--) {
        		char c = s.charAt(i);
        		value = c - '0';
        		//System.out.println("plus : " + plus * ((int)Math.pow(10, digit)));
        		sum += value * ((int)Math.pow(10, digit));
        		digit++;
        	}
    	//부호가 없는 경우
    	}else {
    		for(int i=s.length()-1; i>=0; i--) {
        		char c = s.charAt(i);
        		value = c - '0';
        		sum += value * ((int)Math.pow(10, digit));
        		digit++;
        	}
    	}
    	
    	//부호가 -인 경우 음수로 만들기 위해 -1을 곱해줌(문제에서 s길이 1이상 5이하이고, 0으로 시작하지 않기 때문에 0은 없음)
    	if(mark == '-') {
    		sum *= -1;
    	}
    	
    	return sum;
    }
}