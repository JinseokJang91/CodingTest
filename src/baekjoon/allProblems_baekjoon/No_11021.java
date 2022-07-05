package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_11021 {

	public static void main(String[] args) throws Exception{
		
		//11021 A+B-7
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<Integer>();
		String[] inputs = new String[T];
		for(int i=0; i<inputs.length; i++) {
			inputs[i] = br.readLine();
		}
		
		String[] temp = new String[2];
		for(int i=0; i<inputs.length; i++) {
			temp = inputs[i].split(" ");
			list.add(Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]));
		}
		//System.out.println("list : " + list);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("Case #" + (i+1) + ": " + list.get(i));
		}
	}
}
