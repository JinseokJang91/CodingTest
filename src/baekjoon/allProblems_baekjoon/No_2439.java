package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_2439 {

	public static void main(String[] args) throws Exception{
		
		//2439¹ø º°Âï±â-2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int x = N;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(j>=x-1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			x--;
			System.out.println();
		}
	}
}
