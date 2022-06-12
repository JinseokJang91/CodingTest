package programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.List;

public class LV1_40 {

	public static void main(String[] args) {
		SolutionLV1_40 sol = new SolutionLV1_40();
		String s = "a B z Y";
		int n = 4;
		String answer = sol.solution(s, n);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_40 {
    public String solution(String s, int n) {
    	
    	//연습문제 > 시저 암호
        String answer = "";
        
        //s를 n만큼 밀어내는 암호화 방식
        //AB를 1만큼 밀면 BC
        //z를 1만큼 밀면 a
        //aBz를 4만큼 밀면 eFd
        
        //A-Z : 65-90
        //a-z : 97-122
        char[] arr = s.toCharArray();
        
        /*
        for(int i=0; i<arr.length; i++) {
        	//n만큼 밀어낸 값
        	int x = (int)arr[i] + n;
        	//각 알파벳이 A-Z인 경우
        	if(arr[i] >= 'A' && arr[i] <= 'Z') {
        		if(x > 90) {
        			arr[i] = (char)(x - 90 + 65 - 1);
        		}else {
        			arr[i] = (char) x;
        		}
        	}
        	//각 알파벳이 a-z인 경우
        	if(arr[i] >= 'a' && arr[i] <= 'z') {
        		if(x > 122) {
        			arr[i] = (char)(x - 122 + 97 - 1);
        		}else {
        			arr[i] = (char) x;
        		}
        	}
        }
        
        for(int i=0; i<arr.length; i++) {
        	answer += arr[i];
        }
        */
        
        List<Character> list = new ArrayList<Character>();
        for(int i=0; i<arr.length; i++) {
        	int x = (int)arr[i] + n;
        	//각 알파벳이 A-Z인 경우
        	if(arr[i] >= 'A' && arr[i] <= 'Z') {
        		if(x > 90) {
        			list.add((char)(x - 90 + 65 - 1));
        		}else {
        			list.add((char) x);
        		}
        	}
        	//각 알파벳이 a-z인 경우
        	if(arr[i] >= 'a' && arr[i] <= 'z') {
        		if(x > 122) {
        			list.add((char)(x - 122 + 97 - 1));
        		}else {
        			list.add((char) x);
        		}
        	}
        	//공백인 경우
        	if(arr[i] == ' ') {
        		list.add(' ');
        	}
        }
        
        for(int i=0; i<list.size(); i++) {
        	answer += list.get(i);
        }
        
        //주석처리 해놓은 배열 방법을 쓰면 9ms 정도
        //List 쓰면 1.3ms정도
        
        return answer;
    }
}