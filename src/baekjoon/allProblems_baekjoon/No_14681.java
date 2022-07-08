package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_14681 {

	public static void main(String[] args) throws Exception{
		//14681번 사분면 고르기
		//x양수 y양수 : 1사분면
		//x음수 y양수 : 2사분면
		//x음수 y음수 : 3사분면
		//x양수 y음수 : 4사분면
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		String input2 = br.readLine();
		
		int x = Integer.parseInt(input1);
		int y = Integer.parseInt(input2);
		
		//int answer = (x>0 && y>0) ? 1 : ((x<0 && y>0) ? 2 : ((x<0 && y<0) ? 3 : 4));
		//System.out.println(answer);
		
		if(x>0 && y>0) {
			System.out.println(1);
		}else if(x<0 && y>0) {
			System.out.println(2);
		}else if(x<0 && y<0) {
			System.out.println(3);
		}else {
			System.out.println(4);
		}
		
		//삼항연산자나 조건문이나 속도, 메모리 둘 다 비슷
	}
}
