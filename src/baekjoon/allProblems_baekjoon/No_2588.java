package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_2588 {

	public static void main(String[] args) throws Exception{
		
		//2588¹ø °ö¼À
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		String input2 = br.readLine();
		
		int num1 = Integer.parseInt(input1);
		int num2 = Integer.parseInt(input2);
		String[] arr = input2.split("");
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			list.add(Integer.parseInt(arr[i]));
		}
		
		for(int i=list.size()-1; i>=0; i--) {
			System.out.println(num1 * list.get(i));
		}
		System.out.println(num1 * num2);
		
		
		
		br.close();
	}

}
