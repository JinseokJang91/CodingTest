package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_10952 {

	public static void main(String[] args) throws Exception{

		//10952¹ø A+B - 5
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> list = new ArrayList<Integer>();
		while(true) {
			String input = br.readLine();
			
			if(input.equals("0 0")) {
				break;
			}
			
			String[] arr = input.split(" ");
			int A = Integer.parseInt(arr[0]);
			int B = Integer.parseInt(arr[1]);
			list.add(A + B);
		}
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		br.close();
	}

}
