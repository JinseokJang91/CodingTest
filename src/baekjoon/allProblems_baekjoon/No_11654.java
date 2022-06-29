package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_11654 {

	public static void main(String[] args) throws Exception{
		
		//11654 아스키 코드
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char result = input.charAt(0);
		
		if(result >= 0 && result <= 9) {
			System.out.println((char)result);
		}else {
			System.out.println((int)result);
		}
		
		br.close();
		
	}
}
