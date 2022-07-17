package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No_10869 {

	public static void main(String[] args) throws Exception{

		//10869 사칙연산
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		
		String[] arr = input.split(" ");
		
		/*
		if(arr.length == 2) {
			int A = Integer.parseInt(arr[0]);
			int B = Integer.parseInt(arr[1]);
			
			bw.write(String.valueOf(A + B) + "\n");
			bw.write(String.valueOf(A - B) + "\n");
			bw.write(String.valueOf(A * B) + "\n");
			bw.write(String.valueOf(A / B) + "\n");
			bw.write(String.valueOf(A % B));
		}
		
		bw.flush();
		br.close();
		*/
		
		if(arr.length == 2) {
			int A = Integer.parseInt(arr[0]);
			int B = Integer.parseInt(arr[1]);
			
			System.out.println(A + B);
			System.out.println(A - B);
			System.out.println(A * B);
			System.out.println(A / B);
			System.out.println(A % B);
		}
		
		br.close();
	}

}
