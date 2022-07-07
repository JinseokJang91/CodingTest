package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class No_1037 {

	public static void main(String[] args) throws Exception{
		//1037¹ø
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		String[] inputs = new String[N];
		inputs = input.split(" ");
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<inputs.length; i++) {
			list.add(Integer.parseInt(inputs[i]));
		}
		System.out.println("list : " + list);
		
		int answer = 0;
		
		if(inputs.length == 1) {
			answer = list.get(0) * list.get(0);
		}else {
			Collections.sort(list, Comparator.naturalOrder());
			answer = list.get(0) * list.get(list.size()-1);
		}
		System.out.println("answer : " + answer);
		
		boolean chk = false;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) != 1 && answer%list.get(i) == 0) {
				chk = true;
			}else {
				chk = false;
				break;
			}
		}
		
		if(chk == true) {
			System.out.println(answer);
		}
		br.close();
	}
}
