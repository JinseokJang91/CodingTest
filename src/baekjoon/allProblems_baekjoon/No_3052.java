package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class No_3052 {

	public static void main(String[] args) throws Exception{

		//3052번 나머지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] inputs = new int[10];
		for(int i=0; i<inputs.length; i++) {
			inputs[i] = Integer.parseInt(br.readLine());
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<inputs.length; i++) {
			int rest = inputs[i] % 42;
			set.add(rest);
		}
		//System.out.println("set : " + set);
		
		System.out.println(set.size());
		br.close();
	}

}
