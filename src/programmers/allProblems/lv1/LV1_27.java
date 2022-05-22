package programmers.allProblems.lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LV1_27 {

	public static void main(String[] args) throws Exception{

		//연습문제 > 하샤드 수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		boolean answer = true;
		
		//하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 한다.
		String str = String.valueOf(x);
		int sum = 0;
		for(int i=0; i<str.length(); i++) {
			sum += Integer.parseInt(String.valueOf(str.charAt(i))); //char -> String -> Integer
		}
		System.out.println("sum : " + sum);
		
		if(x % sum == 0) {
			answer = true;
		}else {
			answer = false;
		}
		
		System.out.println("answer : " + answer);
	}

}