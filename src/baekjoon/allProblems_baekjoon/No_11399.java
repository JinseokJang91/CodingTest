package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class No_11399 {

	public static void main(String[] args) throws Exception{
		
		//11399 ATM
		//각 사람이 돈을 인출하는데 필요한 시간의 합이 최소이려면
		//인출하는데 걸리는 시간이 작은 순서대로 돈을 뽑으면 됨
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String input = br.readLine();
		String[] inputs = input.split(" ");
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<inputs.length; i++) {
			list.add(Integer.parseInt(inputs[i]));
		}
		
		Collections.sort(list, Comparator.naturalOrder());
		
		int times = 0;
		int sum = 0;
		for(int i=0; i<list.size(); i++) {
			times += list.get(i);
			System.out.println("times : " + times);
			sum += times;
		}
		System.out.println("sum : " + sum);
	}
}
