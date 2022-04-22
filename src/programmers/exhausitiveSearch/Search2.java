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
        //���� Ž�� > �Ҽ� ã��
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

    		System.out.print("��� : ");
    		for(int i=0; i<list.size(); i++){
    			System.out.print(list.get(i) + " ");
    		}
    		System.out.println();
    		*/
    		
    		int totalCases = 0;
        	for(int i=1; i<=arrLen; i++) {
        		totalCases += pactorial(numArr.length, i);
        	}
        	System.out.println("�� ����� �� : " + totalCases);
        	
        	int x = 0;
        	
        	for(int i=0; i<arrLen; i++) {
        		//�� �ڸ� �� �� ��
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
    //1,7 �̸� 1, 7, 17, 71
	//1,2,3 �̸� 1, 2, 3, 12, 13, 21, 23, 31, 32, 123, 132, 213, 231, 312, 321
	//3P1 + 3P2 + 3P3 => 3!/(3-1)! + 3!/(3-2)! + 3!/(3-3)! => 6/2 + 6/1 + 6/1 => 3 + 6 + 6 = 15
    int count = 0;
    //�Լ��� 1�� �ѱ�� 1, 12, 13, 123, 132
    public void findCases(int i, String str, String[] numArr) {
    	
    	System.out.println("�޼ҵ� ��� ����? : " + ++count);
    	//12�� ������ �ٽ� �޼ҵ� �����ϸ� 1,2�� �ɷ�����
    	//12�� �����ϸ� findCases(0~2, "12", numArr)
    	if(i >= arrLen) {
    		System.out.println("i�� : " + i);
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
        		}System.out.println("j��" + j + "�� �� : "+index.contains(String.valueOf(j)));
    			//findCases(j, a, numArr);
    		}
    		//findCases(i+1, a, numArr);
    		
    	}
    	//findCases(i+1, a, numArr);
    	//ó���� str�� i=0�� ���ϱ� numArr[0]�� 1
    	//i=0, j=0 - x
    	//j = 1�� �� 1 + 2 = 12
    		//j=0 a=12 -> 123�� ��µǾ���� �̶� index���� 01, j=2�� ��ħ �׷� a�� 12 + 3 = 123�� ��
    			//
    	//j = 2�� �� 1 + 3 = 13
    	
    	
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