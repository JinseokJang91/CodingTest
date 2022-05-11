package programmers.allProblems;

import java.util.ArrayList;
import java.util.List;

public class LV1_18 {

	public static void main(String[] args) {
		SolutionLV1_18 sol = new SolutionLV1_18();
		int[] arr = {1,1,3,3,0,1,1};
		//int[]arr = {4,4,4,3,3};
		int[] answer = {};
		answer = sol.solution(arr);
		for(int i=0; i<answer.length; i++) {
			System.out.printf("%d ", answer[i]);
		}System.out.println();

	}

}

class SolutionLV1_18 {
    public int[] solution(int []arr) {
        
    	//연습문제 > 같은 숫자는 싫어
    	int[] answer = {};
        
        //각 배열에서 연속으로 나타나는 숫자는 하나만 남기고 전부 제거
    	//그리고 배열 arr의 원소들의 순서를 유지해야 한다.
    	//1,1,3,3,0,1,1 이면 1,3,0,1을 리턴
    	
    	//List를 사용해서 최초 인덱스 0 값은 넣어주고
    	//i값과 i+1값을 비교해서 이전 값과 같지 않으면 list에 넣어준다.
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(arr[0]);
    	for(int i=0; i<arr.length; i++) {
    		if(i+1 < arr.length) {
    			if(arr[i] != arr[i+1]) {
    				list.add(arr[i+1]);
    			}
    		}
    	}
    	
    	System.out.println("list : " + list);
    	answer = new int[list.size()];
    	for(int i=0; i<answer.length; i++) {
    		answer[i] = list.get(i);
    	}
    	
    	/* 조건과 일치하지 않으므로 Set은 사용하지 못할듯 - 연속된 숫자만 제거하기 때문
    	Set<Integer> set = new HashSet<Integer>();
    	for(int i=0; i<arr.length; i++) {
    		set.add(arr[i]);
    		System.out.println("arr[i] : " + arr[i]);
    	}
    	System.out.println("set : " + set);
    	//############################################################
    	//HashSet은 자동 정렬이 되지 않음에도 4,4,4,3,3을 넣었을 때 3,4로 출력되는 이유는
    	//정렬에 의해서가 아니라 key값과 HashSet의 테이블의 크기간에 &연산을 진행하기 때문이다.
    	//예를 들어 1,17,3,3,2라고 할 때 HashSet에 담으면 1,17,2,3으로 출력된다. 1과 17은 같은 테이블 인덱스를 가지고 있기 때문

    	Iterator<Integer> iter = set.iterator();
    	answer = new int[set.size()];
    	int index = 0;
    	
    	while(iter.hasNext()) {
    		answer[index] = iter.next();
    		index++;
    	}
    	*/

        return answer;
    }
}