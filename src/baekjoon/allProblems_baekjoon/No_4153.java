package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class No_4153 {

	public static void main(String[] args) throws Exception{
		
		//4153�� �����ﰢ��
		//�־��� ������ ���̷� �ﰢ���� �������� �ƴ��� ����
		//�����̷��� c^2 = a^2 + b^2 (c > a,b)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> answ = new ArrayList<String>();
		
		while(true) {
			String input = br.readLine();
			
			if(input.equals("0 0 0")) {
				break;
			}
			
			String[] arr = input.split(" ");
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<arr.length; i++) {
				list.add(Integer.parseInt(arr[i]));
			}
			
			Collections.sort(list, Comparator.reverseOrder()); //��������
			
			int c = list.get(0);
			int b = list.get(1);
			int a = list.get(2);
			
			if(c*c == (b*b + a*a)) {
				answ.add("right");
			}else {
				answ.add("wrong");
			}
		}
		
		for(int i=0; i<answ.size(); i++) {
			System.out.println(answ.get(i));
		}
		
		br.close();
		
	}

}
