package programmers.allProblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LV1_22 {

	public static void main(String[] args) {
		SolutionLV1_22 sol = new SolutionLV1_22();
		String s = "Zbcdefg";
		String answer = sol.solution(s);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_22 {
    public String solution(String s) {
    	
    	//연습문제 > 문자열 내림차순으로 배치하기
        String answer = "";
        
        //소문자가 대문자보다 큰 것으로 간주
        //문자를 큰 것부터 작은 순으로 정렬
        char[] arr = new char[s.length()];
        arr = s.toCharArray();
        
        //프로그래머스 기준 2~5대
        List<Character> list = new ArrayList<Character>();
        for(int i=0; i<arr.length; i++) {
        	list.add(arr[i]);
        }
        
        list.sort(Comparator.reverseOrder());
        System.out.println("list : " + list);
        
        for(int i=0; i<list.size(); i++) {
        	answer += list.get(i);
        }
        
        /*//선택정렬 -> 프로그래머스 기준 처리 속도 10대 - 다소 비효율적임
        for(int i=0; i<arr.length; i++) {
        	for(int j=i; j<arr.length; j++) {
        		if(arr[j] > arr[i]) {
        			char temp = arr[j];
        			arr[j] = arr[i];
        			arr[i] = temp;
        		}
        	}
        }
        
        for(int i=0; i<arr.length; i++) {
        	System.out.printf("%c", arr[i]);
        }System.out.println();
        
        for(int i=0; i<arr.length; i++) {
        	answer += arr[i];
        }
        */
        
        return answer;
    }
}