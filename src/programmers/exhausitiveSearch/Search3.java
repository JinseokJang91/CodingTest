package programmers.exhausitiveSearch;

import java.util.ArrayList;
import java.util.List;

public class Search3 {

	public static void main(String[] args) {
		
		SolutionSearch3 sol = new SolutionSearch3();
		int brown = 24;
		int yellow = 24;
		int[] answer = sol.solution(brown, yellow);
		
		// 결과 출력
		System.out.print("answer : ");
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		System.out.println();
		
	}

}

class SolutionSearch3 {
    public int[] solution(int brown, int yellow) {
    	
    	// 완전 탐색 > 카펫
        int[] answer = new int[2];
        
        int check = 0;
        if((brown >= 8 && brown <= 5000)
        	&& (yellow >= 1 && yellow <= 2000000))
        {
        	check = 1;
        }
        
        if(check == 1) {
        	
        	
        	// brown이 카펫의 테두리 1줄의 개수에 해당함
        	/* 테두리 길이는 (가로 + 세로) * 2 - 4 -> 4는 겹치는 부분이 사각형 네 꼭지점에 해당하는 영역이기 때문
        	 * 예시를 살펴보면
        	 * [4, 3] -> (4+3)*2 - 4 = 10
        	 * [3, 3] -> (3+3)*2 - 4 = 8
        	 * [8, 6] -> (8+6)*2 - 4 = 24
        	 * 단, 주어지는 값이 brown, yellow 이고 answer 배열(가로, 세로)을 구해야 하므로
        	 * answer이 [x, y]일 때 brown = (x+y)*2 - 4 이 된다.
        	 * yellow는 가로*세로에서 brown개수만큼 빼면 되므로 yellow = (x*y) - brown
        	 * 구해야 하는 값은 x, y
        	 * - 제한 조건 : 가로 >= 세로
        	*/
        	
        	/* x*y = brown + yellow
        	 * 중요 체크 - brown이 yellow를 감싸고 있는지 판단
        	 * -> brown = (x+y)*2 - 4 인지 확인
        	 * */
        	
        	/* brown + yellow 즉, 사각형의 넓이는 answer[0] * answer[1] 이다.
        	 * 사각형의 넓이는 brown + yellow 즉, 사각형 넓이의 약수로 이루어 진다.
        	 * 예를 들면, brown이 10, yellow가 2일 때 사각형의 넓이는 12이므로 
        	 * 12의 약수인 1,2,3,4,6,12 중 두 개를 곱해 12가 되는 x,y 중에 brown = (x+y) * 2 -4 를 만족하는 x,y를 찾으면 된다.
        	 * 그럼 x,y 리스트는 12,1 / 6,2 / 4,3 세 가지가 나옴
        	 * 그 다음 (x+y) * 2 - 4에 대입해보면
        	 * (12+1) * 2 - 4 = 22
        	 * (6+2) * 2 - 4 = 12
        	 * (4+3) * 2 - 4 = 10  ->  brown값과 같음
        	 * 
        	 * 그럼 단계별로 구분하면
        	 * 1. brown + yellow의 약수를 구한다.
        	 * 2. 약수들 중 두 개를 곱해 brown + yellow 값이 나오는 x, y를 구한다.
        	 * 3. 구한 x, y가 brown = (x+y) * 2 - 4 를 만족하는지 확인한다.
        	 * */
        	List<Integer> list = new ArrayList<Integer>();
        	
        	//1. 약수 list에 삽입
        	int sum = brown + yellow;
        	for(int i=1; i<=sum; i++) {
        		if(sum % i == 0) {
        			list.add(i);
        		}
        	}
        	
        	//2. 약수 중 두 개를 곱하는데, 양쪽 끝에서 하나씩 서로 곱하면 됨(홀수인 경우는 해당 값을 두번 곱하면 됨 -> 1, 5, 25인 경우 5*5=25)
        	for(int i=0; i<list.size(); i++) {
        		int x = list.get(list.size()-1-i);
        		int y = list.get(i);
        		//System.out.println(x + "*" + y + "=" + x*y);
        		//가로가 세로보다 크거나 같으므로
        		if(x >= y && x * y == sum) {
        			System.out.println("제한 조건 거른 경우의 수");
        			System.out.println(x + "*" + y + "=" + x*y);
        			if((x + y ) * 2 - 4 == brown) {
        				System.out.println("정답 구하기 -> " + x + "*" + y + "=" + x*y);
        				answer[0] = x;
        				answer[1] = y;
        			}
        			
        		}
        	}
        	
        	
        	
        }
        
        return answer;
    }
}