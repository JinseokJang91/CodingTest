package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_1929 {

	public static void main(String[] args) throws Exception{
		
		//1929번 소수 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] inputs = input.split(" ");
		int M = Integer.parseInt(inputs[0]);
		int N = Integer.parseInt(inputs[1]);
		
		/*
		for(int i=M; i<=N; i++) {
			int cnt = 0;
			for(int j=1; j<=i; j++) {
				//System.out.println(i + " % " + j + " = " + (i%j));
				if(i % j == 0) {
					cnt++;
				}
				if(cnt > 2) {
					break;
				}
			}
			//System.out.println("cnt : " + cnt);
			if(cnt == 2) {
				//System.out.println("소수 : " + i);
				System.out.println(i);
			}
		}
		*/ //이 방법은 시간을 너무 많이 소요하는 방법(시간초과)
		
		//소수를 구할 때는 에라토스테네스의 체를 사용한다.
		//에라토스테네스의 체
		//"소수가 되는 수의 배수를 지우면 남은건 소수가 된다" 라고 생각하는 알고리즘
		//쉽게 이해하면 결론적으로 2, 3, 5, 7의 배수를 지우고 남은 수가 소수이다
		
		
		//어쨌든 코드로 구현하면
		boolean[] prime = new boolean[N+1]; //i(인덱스)값을 소수로 출력할 것이므로 +1을 해줘야 함
		
		//소수인 값 : false
		//i값이 소수인지 판별할 값이므로 0은 제외, 1은 소수가 아니므로 제외
		prime[0] = true;
		prime[1] = true;
		
		//소수 처리
		for(int i=2; i*i<=N; i++) {
			//System.out.println("(1)prime[" + i + "] : " + prime[i]);
			if(!prime[i]) {
				for(int j=i*i; j<=N; j+=i) {
					prime[j] = true;
					//System.out.println("(2)prime[" + j + "] : " + prime[j]);
				}
			}
		}
		
		//소수 출력
		for(int i=M; i<=N; i++) {
			if(!prime[i]) {
				//System.out.println("소수 : " + i);
				System.out.println(i);
			}
		}
		
		
		
		br.close();
	}

}
