package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_2908 {

	public static void main(String[] args) throws Exception {
		
		//���
		//����� �ٸ� ����� �ٸ��� ���� �Ųٷ� ����
		//�� ���� �־����µ�, �� ���� ���� ���� �� �ڸ� ���̸� 0�� ���ԵǾ� ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] inputArr = input.split(" ");
		//String[] inputArr = br.readLine().split(" "); -> �̷��� �� �ٷ� �� ���� ����
		
		int input1 = Integer.parseInt(inputArr[0]);
		int input2 = Integer.parseInt(inputArr[1]);
		
		String sInput1 = String.valueOf(input1);
		String sInput2 = String.valueOf(input2);
		
		String reverse1 = "";
		String reverse2 = "";
		
		for(int i=sInput1.length()-1; i>=0; i--){
			reverse1 += sInput1.charAt(i);
		}
		
		for(int i=sInput2.length()-1; i>=0; i--){
			reverse2 += sInput2.charAt(i);
		}
		//System.out.println("reverse1 : " + reverse1);
		//System.out.println("reverse2 : " + reverse2);
		
		int output1 = Integer.parseInt(reverse1);
		int output2 = Integer.parseInt(reverse2);
		
		if(output1 > output2) {
			System.out.println(output1);
		}else {
			System.out.println(output2);
		}
		
		br.close();
	}
}
