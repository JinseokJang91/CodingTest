package programmers.allProblems.lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LV1_27 {

	public static void main(String[] args) throws Exception{

		//�������� > �ϻ��� ��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		boolean answer = true;
		
		//�ϻ��� ���̷��� x�� �ڸ����� ������ x�� ���������� �Ѵ�.
		String str = String.valueOf(x);
		int sum = 0;
		for(int i=0; i<str.length(); i++) {
			sum += Integer.parseInt(String.valueOf(str.charAt(i))); //char -> String -> Integer
		}
		System.out.println("sum : " + sum);
		
		if(x % sum == 0) {
			answer = true;
		}else {
			answer = false;
		}
		
		//System.out.println("answer : " + answer);
	}

}