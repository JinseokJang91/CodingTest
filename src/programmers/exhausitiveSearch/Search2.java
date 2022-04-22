package programmers.exhausitiveSearch;

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
	
	private List<Integer> list = new ArrayList<Integer>();

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
    		/*
    		String[] numArr = numbers.split("");

    		int totalCases = 0;
        	for(int i=1; i<=numArr.length; i++) {
        		totalCases += pactorial(numArr.length, i);
        	}
        	System.out.println("총 경우의 수 : " + totalCases);
        	*/
        	
        	findCase("", numbers);
        	
        	int count = 0;
        	for(int i=0; i<list.size(); i++) {
        		if(chkNum(list.get(i))) {
        			count++;
        		}
        	}
        	
        	//answer = list.size();
        	answer = count;

        	System.out.println("list : " + list);
        	
        	String a = "abc";
        	System.out.println("a : " + a);
        	a.substring(1, 2);
        	System.out.println("a : " + a);
    	}

        return answer;
    }
    
    public void findCase(String str, String numbers) {
    	
    	//소수 판별은 solution 메소드에서 진행해주면 속도가 좀 더 빨라짐("011"일 때 01까지 검사하게 돼서? 정확히는 모르겠다.)
    	System.out.println("메소드 실행!");
    	//System.out.println("str값 : " + str);
    	if(!str.equals("")) {
    		if(!list.contains(Integer.valueOf(str))) {
   				list.add(Integer.valueOf(str));
    		}
    	}
    	
    	for(int i=0; i<numbers.length(); i++) {
    		System.out.println("체크i : " + i);
    		System.out.println("체크str : " + str);
    		System.out.println("체크 numbers.charAt(i) : " + numbers.charAt(i));
    		System.out.println("리스트 삽입 - str + numbers.charAt(i) : " + str + numbers.charAt(i));
    		System.out.println("numbers.substring(0, i) : " + numbers.substring(0, i));
    		System.out.println("numbers.substring(i+1) : " + numbers.substring(i+1));
    		findCase(str + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i+1));
    		
    	}
    	//substring(a, b)는 문자열의 a인덱스부터 b이전 인덱스까지 자르는것
    	//substring(c)는 문자열의 c인덱스부터 마지막까지 가져오는 것
    	/*
    	메소드 실행!
			체크i : 0
			체크str : 
			체크 numbers.charAt(i) : 1
			리스트 삽입 - str + numbers.charAt(i) : 1
			numbers.substring(0, i) : 
			numbers.substring(i+1) : 23
			
		메소드 실행!
			체크i : 0
			체크str : 1
			체크 numbers.charAt(i) : 2 -> 여기서 numbers.charAt(i)가 2가 되는 이유는 
										 앞에서 numbers.substring(0, i) + numbers.substring(i+1)를 통해 numbers값이 바뀌었기 때문
										 findCase(str, numbers)에서 str값은 "1"이 들어가고, numbers는 "23"이 들어가서 
										 다시 메소드를 실행하는 것이기 때문에 numbers.charAt(i), 즉 numbers.charAt(0) 값은 2가 되는 것이다.
			리스트 삽입 - str + numbers.charAt(i) : 12 -> 
			numbers.substring(0, i) : 
			numbers.substring(i+1) : 3
    	 * */
    }
    
    public boolean chkNum(int num) {
    	
    	//소수 구하는 방법에 에라토스테네스의 체 라는 것이 있다.
    	
    	//int num = Integer.parseInt(str);
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
    
    //함수는 1을 넘기면 1, 12, 13, 123, 132
    /*
    public void findCases(int i, String index, String str, String[] numArr) {
    	
    	System.out.println("메소드 몇번 진행? : " + ++count);
    	System.out.println("메소드 시작할 때 index : " + index);
    	//12를 가지고 다시 메소드 시작하면 1,2를 걸러야함
    	//12를 시작하면 findCases(0~2, "12", numArr)
    	if(i >= arrLen) {
    		System.out.println("i값 : " + i);
    		return;
    	}
    	String a = "";
    	//index = "" + i;
    	for(int j=0; j<arrLen; j++) {
    		System.out.println("j값 : " + j);
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
        		}//System.out.println("j가" + j + "일 때 : "+index.contains(String.valueOf(j)));
    			
    		}
    		//findCases(i+1, a, numArr);
    		
    	}
    	if(index.length() == arrLen) {
    		System.out.println("메소드 다시 호출!!!");
    		System.out.println(index.substring(0, index.length()-1));
    		index = index.substring(0, index.length()-1);
    		findCases(i, index, a, numArr);
    	}
    	
    	//
    	//처음에 str이 i=0일 때니까 numArr[0]은 1
    	//i=0, j=0 - x
    	//j = 1일 때 1 + 2 = 12
    		//j=0 a=12 -> 123이 출력되어야함 이때 index에는 01, j=2만 거침 그럼 a는 12 + 3 = 123이 됨
    			//
    	//j = 2일 때 1 + 3 = 13
 
    }
    */
    
    //팩토리얼구하기
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