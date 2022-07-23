package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_1934 {

	public static void main(String[] args) throws Exception{

		//1934번 최소공배수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String[] inputs = new String[T];
		for(int i=0; i<T; i++) {
			inputs[i] = br.readLine();
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<inputs.length; i++) {
			String[] temp = inputs[i].split(" ");
			int A = Integer.parseInt(temp[0]);
			int B = Integer.parseInt(temp[1]);
			
			//최소공배수 구하기
			//최소공배수 : 두 수의 약수들 중 중복을 제거한 수들의 곱.. -> 두 수를 곱하고 공통된 약수로 나누면 됨(약수는 2가 여러개면 갯수만큼 체크)
			//16, 20이면 -> 16 : 1,2,2,2,2 / 20 : 1,2,2,5 -> 1,2,2가 공통이므로 16*20의 결과임 320을 1*2*2로 나누면 됨
			//-> 즉, 최소공배수는 두 수의 곱을 두 수의 최대공약수로 나눈 값을 의미
			
			//최대공약수 구하기
			int share = 1;
			int maxComm = 0;
			while(true) {
				//두 수 중 작은 수를 기준으로 1부터 해당 수까지 증가시키면서 나눠보면 최대 공약수 알 수 있음
				if(A % share == 0 && B % share == 0) {
					maxComm = share;
				}
				
				share++;
				if(share > Math.min(A, B)) {
					break;
				}
			}
			//System.out.println("최대공약수 : " + maxComm);
			//System.out.println("최소공배수 : " + (A*B) / maxComm);
			System.out.println((A*B) / maxComm);
		}
		
		br.close();
	}

}
