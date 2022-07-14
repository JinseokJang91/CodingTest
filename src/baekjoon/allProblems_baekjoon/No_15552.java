package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No_15552 {

	public static void main(String[] args) throws Exception{
		
		//15552 ºü¸¥ A+B
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		String input = "";
		String[] arr = new String[2];
		for(int i=0; i<T; i++) {
			input = br.readLine();
			arr = input.split(" ");
			String result = String.valueOf((Integer.parseInt(arr[0]) + Integer.parseInt(arr[1])));
			bw.write(result + "\n");
		}
		
		bw.flush();
		br.close();
	}

}
