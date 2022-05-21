package programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LV1_19 {

	public static void main(String[] args) {
		SolutionLV1_19 sol = new SolutionLV1_19();
		//int[] arr = {5, 9, 7, 10};
		//int divisor = 5;
		//int[] arr = {2, 36, 1, 3};
		//int divisor = 1;
		int[] arr = {3, 2, 6};
		int divisor = 10;
		int[] answer = sol.solution(arr, divisor);
		for(int i=0; i<answer.length; i++) {
			System.out.printf("%d", answer[i]);
		}
		System.out.println();
	}

}

class SolutionLV1_19 {
    public int[] solution(int[] arr, int divisor) {
    	
    	//연습문제 > 나누어 떨어지는 숫자 배열
        int[] answer = {};
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<arr.length; i++) {
        	if(arr[i] % divisor == 0) {
        		list.add(arr[i]);
        	}
        }
        
        if(list.isEmpty()) {
        	list.add(-1);
        }
        
        list.sort(Comparator.naturalOrder());
        System.out.println("list : " + list);
        
        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}