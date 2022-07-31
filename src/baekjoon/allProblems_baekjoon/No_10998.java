package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_10998 {

	public static void main(String[] args) throws Exception{

		//10998¹ø AXB
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String[] inputs = input.split(" ");
		int A = Integer.parseInt(inputs[0]);
		int B = Integer.parseInt(inputs[1]);
		
		System.out.println(A * B);
		br.close();
	}

}
