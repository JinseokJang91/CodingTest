package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class No_2750 {

	public static void main(String[] args) throws Exception{
		
		//2750번 수 정렬하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		int input = 0;
		
		/*
		for(int i=0; i<N; i++) {
			input = Integer.parseInt(br.readLine());
			list.add(input);
		}*/
		
		int cnt = 0;
		while(cnt < N) {
			input = Integer.parseInt(br.readLine());
			list.add(input);
			
			cnt++;
		}
		System.out.println("list : " + list);
		
		Collections.sort(list, Comparator.naturalOrder());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		br.close();
	}
}
