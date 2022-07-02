package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_1152 {

	public static void main(String[] args) throws Exception{
		
		//1152 단어의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String[] inputs = input.split(" ");
		System.out.println(inputs.length);
	}
}
