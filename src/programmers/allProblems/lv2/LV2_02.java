package programmers.allProblems.lv2;

import java.util.ArrayList;
import java.util.List;

public class LV2_02 {

	public static void main(String[] args) {
		SolutionLV2_02 sol = new SolutionLV2_02();
		int[][] arr1 = {{2, 3, 2},{4, 2, 4},{3, 1, 4}};
		int[][] arr2 = {{5, 4},{2, 4},{3, 1}};
		int[][] answer = sol.solution(arr1, arr2);
		for(int i=0; i<answer.length; i++) {
			for(int j=0; j<answer[i].length; j++) {
				System.out.printf("%d ", answer[i][j]);
			}
			System.out.println();
		}System.out.println();
		

	}

}

class SolutionLV2_02 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        //연습문제 > 행렬의 곱셈
    	int[][] answer = {};
        
        //[2, 3, 2]   [5, 4, 3] 
    	//[4, 2, 4] x [2, 4, 1]
    	//[3, 1, 4]   [3, 1, 1]
        
    	/* =========================================================================================================
    	//[22, 22, 11] 은 (2*5 + 3*2 + 2*3), (2*4 + 3*4 + 2*1), (2*3 + 3*1 + 2*1)
    	//행렬의 곱은 arr1의 행과 arr2의 열을 곱하는 것이므로
    	//2,3,2 와 인덱스 0~2에 해당하는 열 5,2,3/4,4,1/3,1,1 을 곱하면 된다.
    	//즉 arr1에 속하는 각 행의 길이(원소 개수)가 arr2에 속하는 총 행의 개수와 같으면 곱셈이 가능하다.    	
    	
    	//예시 2를 정리하면
    	//첫 번째 반복에서 arr1[0][0~2] 를 arr2[0~2][0]와 곱하게 되는 것
    	
    	//예시 1을 나열해보면
    	//arr1[0][0]*arr2[0][0] + arr1[0][1]*arr2[1][0], arr1[0][0]*arr2[0][1] + arr1[0][1]*arr2[1][1] -> 15, 15
    	//arr1[1][0]*arr2[0][0] + arr1[1][1]*arr2[1][0], arr1[1][0]*arr2[0][1] + arr1[1][1]*arr2[1][1] -> 15, 15
    	//arr1[2][0]*arr2[0][0] + arr1[2][1]*arr2[1][0], arr1[2][0]*arr2[0][1] + arr1[2][1]*arr2[1][1] -> 15, 15
    	
    	//[1, 4]   3 | 3
    	//[3, 2] x 3 | 3
    	//[4, 1]   
    	
    	//arr1[i][j]는 그대로, arr2[j][x]의 j도 순서대로 사용하면 됨
    	//단, x는 예시 1을 보면 0 두 번, 1 두 번 그리고 다시 0 두 번, 1 두 번.. 과 같은 형식이기 때문에
    	//arr2의 length를 count로 잡고 index를 초기화해주는 방식으로 하면 좋을 것 같음
    	========================================================================================================= */
    	
    	//### 여기서부터 풀이!!! 위엔 고민 과정
    	//arr2를 가공하면 되지 않을까?
    	//[2, 3, 2]   	[5, 4]      [5, 2, 3]
    	//[4, 2, 4] x 	[2, 4] ---> [4, 4, 1] 로 바꾸는 거지 --> 결과는 [22,22],[36,28],[29,20]
    	//[3, 1, 4]   	[3, 1]
    	
    	//1. arr3를 가공한 결과를 담을 배열 크기로 설정
    	int[][] arr3 = new int[arr2[0].length][arr2.length];

    	//2. arr2를 가공해서 arr3에 삽입
    	for(int i=0; i<arr2[0].length; i++) {
    		for(int j=0; j<arr2.length; j++) {
    			arr3[i][j] = arr2[j][i];
    		}
    	}
    	
    	for(int i=0; i<arr3.length; i++) {
    		for(int j=0; j<arr3[i].length; j++) {
    			System.out.printf("%d ", arr3[i][j]);
    		}
    		System.out.println();
    	}System.out.println("==================");
    	
    	//3. 3중 for문을 사용해 행렬의 곱 결과를 List에 담아줌
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i=0; i<arr1.length; i++) {			//i = 0, 1, 2
    		for(int j=0; j<arr3.length; j++) {	//j = 0, 1
    			int result = 0;
    			for(int k=0; k<arr1[0].length; k++) {
    				System.out.println(arr1[i][k]*arr3[j][k]);
    				result += arr1[i][k]*arr3[j][k];
    			}
    			list.add(result);
    			System.out.println("result : " + result);
    		}
    	}
    	System.out.println("list : " + list);
    	
    	//4. answer에 list값을 차례대로 삽입
    	int index = 0;
    	answer = new int[arr1.length][arr2[0].length];
    	for(int i=0; i<answer.length; i++) {
    		for(int j=0; j<answer[i].length; j++) {
    			answer[i][j] = list.get(index++);
    		}
    	}
    	
    	
        return answer;
    }
}