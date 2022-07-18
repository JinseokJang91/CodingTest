package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_15596 {

	public static void main(String[] args) throws Exception{

		//15596번 정수 N개의 합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] arr = input.split(" ");
		
		int[] a = new int[arr.length];
		for(int i=0; i<a.length; i++) {
			a[i] = Integer.parseInt(arr[i]);
		}
		long answer = sum(a);
		System.out.println(answer);
	}
	
	public static long sum(int[] a) {
		long result = 0;
		for(int i=0; i<a.length; i++) {
			result += a[i];
		}
		
		return result;
	}

}
