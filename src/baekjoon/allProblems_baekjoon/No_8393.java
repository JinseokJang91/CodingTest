package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_8393 {

	public static void main(String[] args) throws Exception{
		
		//8393
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int num = Integer.parseInt(input);
		int sum = 0;
		for(int i=1; i<=num; i++) {
			sum += i;
		}
		System.out.println(sum);
	
		br.close();
	}

}
