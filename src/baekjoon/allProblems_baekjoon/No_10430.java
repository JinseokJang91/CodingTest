package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_10430 {

	public static void main(String[] args) throws Exception{
		
		//10430 ³ª¸ÓÁö
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		String[] arr = input.split(" ");
		int A = Integer.parseInt(arr[0]);
		int B = Integer.parseInt(arr[1]);
		int C = Integer.parseInt(arr[2]);
		
		System.out.println((A+B)%C);
		System.out.println(((A%C) + (B%C))%C);
		System.out.println((A*B)%C);
		System.out.println(((A%C) * (B%C))%C);
		
		br.close();
	}
}
