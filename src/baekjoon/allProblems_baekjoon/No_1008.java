package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_1008 {

	public static void main(String[] args) throws Exception{

		//1008번 A/B
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] inputs = input.split(" ");
		
		double A = Double.parseDouble(inputs[0]);
		double B = Double.parseDouble(inputs[1]);
		//String ans = String.format("%.24f", A/B); //문제처럼 자릿수를 꼭 맞출 필요는 없는 것 같음. 그리고 출력하면 0.333333333333333000~이런식으로 나옴
		System.out.println(A/B);
	}

}