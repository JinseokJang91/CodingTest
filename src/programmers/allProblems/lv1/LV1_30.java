package programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LV1_30 {

	public static void main(String[] args) {
		SolutionLV1_30 sol = new SolutionLV1_30();
		int[] arr = {10};
		int[] answer = sol.solution(arr);
		for(int i=0; i<answer.length; i++) {
			System.out.printf("%d ", answer[i]);
		}System.out.println();

	}

}

class SolutionLV1_30 {
    public int[] solution(int[] arr) {
    	//연습문제 > 제일 작은 수 제거하기
        int[] answer = {};
        
        //배열에서 가장 작은 수를 제거한 배열을 리턴
        //가장 작은 수를 제거한 배열이 빈 배열일 경우 -1을 채워서 리턴
        
        //진행순서
        //1. PriorityQueue를 이용해 최소값을 찾은 후 list에 최소값을 제외한 값을 넣는다.
        //2. list값을 다시 answer배열에 넣어준다.
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        //Queue<Integer> heap = new PriorityQueue<Integer>();
        for(Integer find : arr) {
        	heap.add(find);
        	//System.out.println("find : " + find);
        }
        //System.out.println("heap : " + heap);
        //System.out.println("최소값 : " + heap.poll());
        int minVal = heap.poll();
        
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++) {
        	if(arr[i] != minVal) {
        		list.add(arr[i]);
        	}
        }
        System.out.println("list : " + list);
        
        if(!list.isEmpty()) {
        	answer = new int[list.size()];
            for(int i=0; i<answer.length; i++) {
            	answer[i] = list.get(i);
            }
        }else {
        	answer = new int[1];
        	answer[0] = -1;
        }
        
        return answer;
    }
}