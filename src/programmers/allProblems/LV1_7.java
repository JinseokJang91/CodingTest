package programmers.allProblems;

import java.util.ArrayList;
import java.util.List;

public class LV1_7 {

	public static void main(String[] args) {
		
		int a = 1;
		int b = 1;
		//int a = 1;
		//int b = 7;
		SolutionLV1_7 sol = new SolutionLV1_7();
		String answer = sol.solution(a, b);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_7 {
    public String solution(int a, int b) {
        
    	//연습문제 > 2016년
    	String answer = "";
        
    	//2016년은 윤년(2월 29일까지 존재)
    	//윤년의 조건은
    	//1. 4로 나누어 떨어진다.
    	//2. 4로 나누어 떨어지고 100으로 나누어 떨어지지 않는다. -> 2100년은 평년
    	//3. 4로 나누어 떨어지고 100으로 나누어 떨어지지 않거나  400으로 나누어 떨어진다. -> 2000년은 윤년
    	
    	//2016년 1월 1일은 금요일
    	//1,3,5,7,8,10,12월은 31일까지
    	//4,6,9,11월은 30일까지
    	//2월은 29일까지(윤년)
    	
    	//요일을 구하는 것이니 총 일수를 구해서 7로 나눈 나머지를 찾으면 될 것 같다.
    	
    	//각 월을 배열이나 리스트에 담아놓고 사용할 지 고민
    	
    	int[] arr1 = {1, 3, 5, 7, 8, 10, 12};
    	int[] arr2 = {4, 6, 9, 11};
    	int[] arr3 = {2};
    	String[] dayNames = 
    		{
    			"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"
    		};
    	
    	List<Integer> thirtyOne = new ArrayList<Integer>();
    	List<Integer> thirty = new ArrayList<Integer>();
    	List<Integer> twentyEight = new ArrayList<Integer>();
    	
    	for(int i=0; i<arr1.length; i++) {
    		thirtyOne.add(arr1[i]);
    	}
    	for(int i=0; i<arr2.length; i++) {
    		thirty.add(arr2[i]);
    	}
    	for(int i=0; i<arr3.length; i++) {
    		twentyEight.add(arr3[i]);
    	}
    	System.out.println("31 : " + thirtyOne);
    	System.out.println("30 : " + thirty);
    	System.out.println("29 : " + twentyEight);
    	
    	int totalDayCnt = 0;
    	
    	if(a>1) {
    		for(int i=1; i<a; i++) {
        		if(thirtyOne.contains(i)) {
        			System.out.println(i + "월은 31일");
        			totalDayCnt += 31;
        		}else if(thirty.contains(i)) {
        			System.out.println(i + "월은 30일");
        			totalDayCnt += 30;
        		}else if(twentyEight.contains(i)){
        			System.out.println(i + "월은 29일");
        			totalDayCnt += 29;
        		}
        	}
    		totalDayCnt += b-1;
    	}else {
    		totalDayCnt = b-1;;
    	}
    	
    	System.out.println("totalDayCnt : " + totalDayCnt);
    	
    	int dayIndex = totalDayCnt%7;
    	System.out.println("dayName : " + dayIndex);
    	
    	answer = dayNames[dayIndex];

        return answer;
    }
}