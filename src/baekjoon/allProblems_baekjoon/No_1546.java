package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class No_1546 {

	public static void main(String[] args) throws Exception{
		//1546 평균
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		String input = br.readLine();
		
		int len = Integer.parseInt(n);
		String[] arr = new String[len];
		arr = input.split(" ");
		
		List<Double> before = new ArrayList<Double>();
		List<Double> after = new ArrayList<Double>();
		for(int i=0; i<arr.length; i++) {
			before.add(Double.parseDouble(arr[i]));
		}
		Collections.sort(before, Comparator.reverseOrder());
		
		//가장 높은 점수
		double max = before.get(0);
		for(int i=0; i<before.size(); i++) {
			after.add((before.get(i)/max)*100);
		}
		System.out.println("after : " + after);
		
		double sum = 0;
		double avg = 0;
		for(int i=0; i<after.size(); i++) {
			sum += after.get(i);
		}
		avg = sum/len;
		System.out.println(avg);
	}
}
