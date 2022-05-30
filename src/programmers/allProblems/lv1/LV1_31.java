package programmers.allProblems.lv1;

public class LV1_31 {

	public static void main(String[] args) {
		SolutionLV1_31 sol = new SolutionLV1_31();
		long n = 121;
		long answer = sol.solution(n);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_31 {
    public long solution(long n) {
        //연습문제 > 정수 제곱근 판별
    	long answer = 0;
        
        //n이 어떤 양의 정수 x의 제곱인지 아닌지 판단
    	//true 이면 x+1의 제곱을 리턴
    	//false 이면 -1을 리턴
    	
    	//Math.sqrt(a) 루트a 값을 구하는 것
    	//Math.pow(a,b)는 a^b를 구하는 것
    	//System.out.println(Math.pow(11, 2));
    	//System.out.println(Math.sqrt(143));
    	//System.out.println((long)Math.sqrt(143) - Math.sqrt(143));
    	
    	//Math.sqrt는 double형이므로 소수점이 존재하는 경우(ex) 143)와 달리
    	//long타입으로 바꾼 값은 소수점이 제거된 결과로 나오기 때문에
    	//두 값의 차이를 구해서 0이 아니면 소수점이 존재한다고 증명할 수 있음
    	//소수점이 존재하는 것은 n이 어떤 양의 정수 제곱이 아니라는 것이기 때문에 조건으로 활용해보자
    	//long타입 - double타입의 결과가 double로 나오는 것은 아마 double이 범위가 더 커서일듯
    	double gap = (long)Math.sqrt(n) - Math.sqrt(n);
        System.out.println("gap : " + gap + ", 0인가? : " + (gap==0));
        if(gap == 0) {
        	long root = (long)Math.sqrt(n);
        	answer = (long)Math.pow(root+1, 2);
        }else {
        	answer = -1;
        }
        
    	
        return answer;
    }
}