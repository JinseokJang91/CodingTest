package programmers.allProblems.lv1;

public class LV1_02 {

	public static void main(String[] args) {
		
		Solution2 sol = new Solution2();
		String s = "one4seveneight";
		int answer = sol.solution(s);
		
		//s = "zero1234";
		//System.out.println(s.startsWith("zero"));
		//s = "0zero1234";
		//System.out.println(s.startsWith("0"));

	}

}

class Solution2 {
    public int solution(String s) {
    	
    	//2021 카카오 채용연계형 인턴십 > 숫자 문자열과 영단어
    	
        int answer = 0;
        
        int check = 0;
        if(s.length()>=1 && s.length()<=50) {
        	if(!s.startsWith("zero") || !s.startsWith("0")) {
        		check = 1;
        	}
        }
        
        System.out.println("check : " + check);
        if(check == 1) {

        	String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        	for(int i=0; i<arr.length; i++) {
        		if(s.contains(arr[i])) {
        			System.out.println("뭐 포함하는지 : " + arr[i]);
        			switch(arr[i]) {
        			case "zero" :
        				s = s.replaceAll("zero", "0");
        				break;
        			case "one" :
        				s = s.replaceAll("one", "1");
        				System.out.println("replace결과1 : " + s.replaceAll("one", "1"));
        				break;
        			case "two" :
        				s = s.replaceAll("two", "2");
        				break;
        			case "three" :
        				s = s.replaceAll("three", "3");
        				break;
        			case "four" :
        				s = s.replaceAll("four", "4");
        				break;
        			case "five" :
        				s = s.replaceAll("five", "5");
        				break;
        			case "six" :
        				s = s.replaceAll("six", "6");
        				break;
        			case "seven" :
        				s = s.replaceAll("seven", "7");
        				System.out.println("replace결과2 : " + s.replaceAll("seven", "7"));
        				break;
        			case "eight" :
        				s = s.replaceAll("eight", "8");
        				break;
        			case "nine" :
        				s = s.replaceAll("nine", "9");
        				break;
        			}
        		}
        	}
        	
        	System.out.println("s : " + s);
        	
        	answer = Integer.valueOf(s);
        	System.out.println("answer : " + answer);
        }
        
        //다른 사람의 풀이 본 결과 contains랑 switch문 안써도 단순하게 replaceAll 메소드를 사용해서
        //zero~nine까지 문자열만 숫자로 치환해준다면 간단하게 표현할 수 있음
        
        return answer;
    }
}