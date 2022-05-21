package programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LV1_06 {

	public static void main(String[] args) {
		
		Solution6 sol = new Solution6();
		int[] numbers = {2, 1, 3, 4, 1};

		sol.solution(numbers);
	}

}

class Solution6 {
    public int[] solution(int[] numbers) {
        
    	//월간 코드 챌린지 시즌1>두 개 뽑아서 더하기
    	int[] answer = {};
        
        int check = 0;
        if(numbers.length >= 2 && numbers.length <= 100) {
        	for(int i=0; i<numbers.length; i++) {
        		if(numbers[i] >= 0 && numbers[i] <= 100) {
        			check = 1;
        		}else {
        			check = 0;
        			break;
        		}
        	}
        }
        
        if(check == 1) {
        	
        	List<Integer> list = new ArrayList<Integer>();
        	
        	for(int i=0; i<numbers.length; i++) {
        		for(int j=0; j<numbers.length; j++) {
        			if(i != j) {
        				int sum = numbers[i] + numbers[j];
        				if(!list.contains(sum)) {
        					list.add(sum);
        				}
        			}
        		}
        	}
        	
        	System.out.println("list : " + list);
        	
        	list.sort(Comparator.naturalOrder());
        	
        	
        	System.out.println("list : " + list);
        	
        	answer = new int[list.size()];
        	for(int i=0; i<answer.length; i++) {
        		answer[i] = list.get(i);
        	}
        	/*
        	//아래와 같은 방법으로도 정렬 가능
        	Arrays.sort(answer);
        		
        	
        	for(int i=0; i<answer.length; i++) {
        		System.out.print(answer[i] + " ");
        	}
        	*/
        	
        	//***참고사항***
        	//String 배열의 내림차순의 경우 Arrays.sort(answer, Collections.reverseOrder());
        	//를 사용하는데, 이 문제의 경우 int배열이므로 해당되지 않음.
        	//int형 배열 내림차순은 Arrays.stream(answer).mapToInt(i -> i).toArray();
        	//이런 식으로 짜야 하는데 그것보다는 그냥 temp변수 사용해서 교체해주는 것이 맞는 것 같다.
        }
        
        return answer;
    }
}