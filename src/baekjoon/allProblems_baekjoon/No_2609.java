package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_2609 {

	public static void main(String[] args) throws Exception{
		//2609번 최대공약수와 최소공배수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] inputs = input.split(" ");
		int num1 = Integer.parseInt(inputs[0]);
		int num2 = Integer.parseInt(inputs[1]);
		
		//최소공배수는 두 수의 곱을 최대공약수로 나누 값
		
		//1. 최대공약수 구하기
		//최대공약수는 두 수 중 작은 수를 범위 기준으로 잡고 1부터 나눠보며 나머지가 0이 되는 수중 가장 큰 수
		
		int share = 1; //나눌 몫을 담을 변수
		int maxShare = 0; //최대공약수를 담을 변수
		while(true) {
			if((num1 % share == 0) && (num2 % share == 0)) {
				maxShare = share;
			}
			
			share++; //몫을 두 수 중 작은 수랑 같아질 때까지 +1
			//두 수 중 작은 수보다 몫 값이 커지면 반복문 빠져나감
			if(share > Math.min(num1, num2)) {
				break;
			}
		}
		//System.out.println("최대공약수 : " + maxShare);
		
		//2. 최소공배수 구하기
		//최소공배수 = 두 수의 곱 / 최대공약수
		//두 수의 곱은 무조건 최대공약수로 나누어 떨어지므로 소수점은 신경 안 써도 됨
		int minTimes = (num1 * num2) / maxShare;
		//System.out.println("최소공배수 : " + minTimes);
		
		System.out.println(maxShare + "\n" + minTimes);
		
		br.close();
	}

}
