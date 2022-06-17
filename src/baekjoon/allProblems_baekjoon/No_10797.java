package baekjoon.allProblems_baekjoon;

import java.util.Scanner;

//public class Main {
public class No_10797 {

	public static void main(String[] args){
		// 10∫Œ¡¶
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[5];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		/*
		System.out.println("n : " + n);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		*/
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == n) {
				count++;
			}
		}
		System.out.println(count);
	}

}
