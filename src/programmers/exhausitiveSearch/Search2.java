package programmers.exhausitiveSearch;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Search2 {

	public static void main(String[] args) {
		
		SolutionSearch2 sol = new SolutionSearch2();
		String numbers = "123";
		int answer = sol.solution(numbers);
		System.out.println("answer : " + answer);

	}

}

class SolutionSearch2 {
	
	private List<String> chkList = new ArrayList<String>();
	private List<String> list = new ArrayList<String>();
	private int arrLen = 0;
	
    public int solution(String numbers) {
        //완전 탐색 > 소수 찾기
    	int answer = 0;
        
    	int check = 0;
    	if(numbers.length() >= 1 && numbers.length() <= 7) {
    		for(int i=0; i<numbers.length(); i++) {
    			if(numbers.charAt(i) >= '0' && numbers.charAt(i) <= '9') {
    				check = 1;
    			}else {
    				check = 0;
    				break;
    			}
    		}
    	}
    	
    	if(check == 1) {
    		String[] numArr = numbers.split("");
    		arrLen = numArr.length;

    		/*
    		List<String> list = new ArrayList<String>();

    		System.out.print("결과 : ");
    		for(int i=0; i<list.size(); i++){
    			System.out.print(list.get(i) + " ");
    		}
    		System.out.println();
    		*/
    		
    		int totalCases = 0;
        	for(int i=1; i<=arrLen; i++) {
        		totalCases += pactorial(numArr.length, i);
        	}
        	System.out.println("총 경우의 수 : " + totalCases);
        	
        	int x = 0;
        	
        	for(int i=0; i<arrLen; i++) {
        		//한 자리 수 일 때
        		if(chkNum(numArr[i])) {
        			if(!list.contains(numArr[i])) {
        				list.add(numArr[i]);
        			}
        		}
        		findCases(i, numArr[i], numArr);
        	}
        	
        	System.out.println("list : " + list);
    	}

        return answer;
    }
    
    public boolean chkNum(String str) {
    	int num = Integer.parseInt(str);
    	int count = 0;
    	for(int i=1; i<=num; i++) {
    		if(num%i == 0) {
    			count++;
    		}
    	}
    	
    	if(count == 2) {
    		return true;
    	}else {
    		return false;
    	}
    }
    //1,7 이면 1, 7, 17, 71
	//1,2,3 이면 1, 2, 3, 12, 13, 21, 23, 31, 32, 123, 132, 213, 231, 312, 321
	//3P1 + 3P2 + 3P3 => 3!/(3-1)! + 3!/(3-2)! + 3!/(3-3)! => 6/2 + 6/1 + 6/1 => 3 + 6 + 6 = 15
    int count = 0;
    //함수는 1을 넘기면 1, 12, 13, 123, 132
    public void findCases(int i, String str, String[] numArr) {
    	
    	System.out.println("메소드 몇번 진행? : " + ++count);
    	//12를 가지고 다시 메소드 시작하면 1,2를 걸러야함
    	//12를 시작하면 findCases(0~2, "12", numArr)
    	if(i >= arrLen) {
    		System.out.println("i값 : " + i);
    		return;
    	}
    	String a = "";
		String index = ""+i;
    	for(int j=0; j<arrLen; j++) {
    		
    		//if(i != j) {
    		if(i != j && !index.contains(String.valueOf(j))) {
    			a = str + numArr[j];
    			index += j;
    			System.out.println("a : " + a);
    			System.out.println("index : " + index);
    			if(chkNum(a)) {
        			if(!list.contains(a)) {
        				list.add(a);
        			}
        		}System.out.println("j가" + j + "일 때 : "+index.contains(String.valueOf(j)));
    			//findCases(j, a, numArr);
    		}
    		//findCases(i+1, a, numArr);
    		
    	}
    	//findCases(i+1, a, numArr);
    	//처음에 str이 i=0일 때니까 numArr[0]은 1
    	//i=0, j=0 - x
    	//j = 1일 때 1 + 2 = 12
    		//j=0 a=12 -> 123이 출력되어야함 이때 index에는 01, j=2만 거침 그럼 a는 12 + 3 = 123이 됨
    			//
    	//j = 2일 때 1 + 3 = 13
    	
    	
    	/*
    	if(x >= arrLen) {
    		System.out.println("x : " + x);
    		return;
    	}
    	
    	for(int i=0; i<arrLen; i++) {
    		
    	}
    	
    	if(!list.contains(str)) {
    		list.add(str);
    	}else {
    		
    	}
    	*/
    }
    
    public int pactorial(int n, int m) {
    	
    	int result = 1;
    	int x = 1; int y = 1;
    	
    	for(int i=n; i>0; i--) {
    		x *= i;
    	}
    	
    	for(int j=n-m; j>0; j--) {
    		if(j != 0)
    		y *= j;
    	}
    	result = x/y;
    	
    	System.out.println("result : " + result);
    	
    	return result;
    }
}