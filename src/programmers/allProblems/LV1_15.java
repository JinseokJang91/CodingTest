package programmers.allProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LV1_15 {

	public static void main(String[] args) {
		SolutionLV1_15 sol = new SolutionLV1_15();
		//int[][] sizes = {{60, 50},{30, 70},{60, 30},{80, 40}};
		//int[][] sizes = {{10, 7},{12, 3},{8, 15},{14, 7},{5, 15}};
		int[][] sizes = {{14, 4},{19, 6},{6, 16},{18, 7},{7, 11}};
		int answer = sol.solution(sizes);
		System.out.println("answer : " + answer);

	}

}

class SolutionLV1_15 {
    public int solution(int[][] sizes) {
    	
    	//위클리 챌린지  > 최소 직사각형
        int answer = 0;
        
        //명함 지갑 가로 세로 길이 정하기
        //가로로 돌려서 수납하는 방법도 고려해야 함
        
        // 간단하게 생각해보면
        // 가로, 세로 길이가 담겨있는 배열에서
        // 가로, 세로 여부와 관계없이 
        // 두 값 중 큰 값에 해당하는 값들 중 가장 큰 값
        // 그리고 두 값중 작은 값에 해당하는 값들 중 가장 큰 값을 구하면
        // 자연스럽게 최적화된 지갑 크기를 정할 수 있다.
        
        //예를 들면, 문제의 예시 1에서
        //60, 50 -> 60이 큰 값 / 50이 작은 값
        //30, 70 -> 70이 큰 값 / 30이 작은 값
        //60, 30 -> 60이 큰 값 / 30이 작은 값
        //80, 40 -> 80이 큰 값 / 40이 작은 값
        
        //정리하면
        //큰 값 리스트 : 60, 70, 60, 80
        //작은 값 리스트 : 50, 30, 30, 40
        //따라서 큰 값 리스트에서 80, 작은 값 리스트에서 50을 뽑으면 된다.
        
        List<Integer> bigVal = new ArrayList<Integer>();
        List<Integer> smallVal = new ArrayList<Integer>();
        
        for(int i=0; i<sizes.length; i++) {
        	int width = sizes[i][0];
        	int height = sizes[i][1];
        	
        	if(width > height) {
        		bigVal.add(width);
        		smallVal.add(height);
        	}else {
        		bigVal.add(height);
        		smallVal.add(width);
        	}
        }
        System.out.println("bigVal : " + bigVal);
        System.out.println("smallVal : " + smallVal);
        
        //내림차순 정렬
        Collections.sort(bigVal, Comparator.reverseOrder());
        Collections.sort(smallVal, Comparator.reverseOrder());
        
        System.out.println("bigVal : " + bigVal);
        System.out.println("smallVal : " + smallVal);
        
        answer = bigVal.get(0) * smallVal.get(0);
        
        return answer;
    }
}
