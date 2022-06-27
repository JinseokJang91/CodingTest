package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class No_10818 {

	public static void main(String[] args) throws Exception{
		//10818번 최소,최대
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		String[] arr = input.split(" ");
		
		if(arr.length == N) {
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<arr.length; i++) {
				list.add(Integer.parseInt(arr[i]));
			}
			
			Collections.sort(list, Comparator.naturalOrder());
			//System.out.println("list : " + list);
			System.out.print(list.get(0) + " ");
			Collections.sort(list, Comparator.reverseOrder());
			//System.out.println("list : " + list);
			System.out.println(list.get(0));
			
			//Stack, Queue 사용해서 다시 풀어보자!
		}
	}
}
