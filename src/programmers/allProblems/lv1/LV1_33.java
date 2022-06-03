package programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LV1_33 {

	public static void main(String[] args) {
		SolutionLV1_33 sol = new SolutionLV1_33();
		long n = 118372;
		long answer = sol.solution(n);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_33 {
    public long solution(long n) {
    	
    	//연습문제 > 정수 내림차순으로 배치하기
        long answer = 0;
        
        String nStr = String.valueOf(n);
        //System.out.println("nStr: " + nStr);
        List<Long> list = new ArrayList<Long>();
        for(int i=0; i<nStr.length(); i++){
            list.add(Long.parseLong(String.valueOf(nStr.charAt(i))));
        }
        //System.out.println("list: " + list);
        Collections.sort(list, Comparator.reverseOrder());
        //System.out.println("list: " + list);
        
        String result = "";
        for(int i=0; i<list.size(); i++){
            result += list.get(i);
        }
        
        answer = Long.parseLong(result);
        
        //### 정리 ###
        //Integer.parseInt 이외에
        //Long.parseLong, Short.parseShort, Double.parseDouble 등이 있는 것을 유념하면 좋을 것 같다.
        
        return answer;
    }
}