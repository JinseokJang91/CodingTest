package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_2741 {

	public static void main(String[] args) throws Exception{
		
		//2741¹ø NÂï±â
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			System.out.println(i);
		}
		
		br.close();
	}
}
