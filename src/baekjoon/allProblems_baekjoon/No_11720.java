package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_11720 {

	public static void main(String[] args) throws Exception{
		
		//11720 숫자의합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		String[] inputs = input.split("");
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<inputs.length; i++) {
			list.add(Integer.parseInt(inputs[i]));
		}
		//System.out.println("list : " + list);
		
		int sum = 0;
		for(int i=0; i<list.size(); i++) {
			sum += list.get(i);
		}
		System.out.println(sum);
		
		br.close();
	}
}
