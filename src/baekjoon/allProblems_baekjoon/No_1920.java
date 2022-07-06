package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_1920 {

	public static void main(String[] args) throws Exception{
		
		//1920 수 찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		String nums = br.readLine();
		String M = br.readLine();
		String inputs = br.readLine();
		
		int numLen = Integer.parseInt(N);
		int inputLen = Integer.parseInt(M);
		String[] numArr = new String[numLen];
		numArr = nums.split(" ");
		String[] inputArr = new String[inputLen];
		inputArr = inputs.split(" ");
		List<Integer> numList = new ArrayList<Integer>();
		List<Integer> inputList = new ArrayList<Integer>();
		
		for(int i=0; i<numArr.length; i++) {
			numList.add(Integer.parseInt(numArr[i]));
		}
		
		for(int i=0; i<inputArr.length; i++) {
			inputList.add(Integer.parseInt(inputArr[i]));
		}
		
		//System.out.println("numList : " + numList);
		//System.out.println("inputList : " + inputList);
		
		for(int i=0; i<inputList.size(); i++) {
			if(numList.contains(inputList.get(i))) {
				System.out.println("1");
			}else {
				System.out.println("0");
			}
		}
		
		//시간초과 났음
		//https://st-lab.tistory.com/261 참조(이분탐색으로 풀어야 할듯)
	}
}
