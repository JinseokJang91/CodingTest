package baekjoon.allProblems_baekjoon;

import java.util.Scanner;

public class No_2839 {

	public static void main(String[] args) {
		
		//설탕 배달
		//3킬로, 5킬로 봉지 두 종류
		//N킬로그램 최소 봉지 수로 딱 떨어지게 구하기
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		*/
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//5x + 3y = N 일 때
		//x + y 가 최소가 되는 수를 구하기
		
		//N = 18
		//5x + 3y = 18
		
		int x_size = N/5;	//N을 5로 나눈 최대몫
		int yCases = N;		//n을 3으로 나눈 몫과 비교하기 위한 초기값
		int xCases = 0;
		
		boolean yn = false;	//3으로 나눠떨어지는지 여부 판단할 값
		
		if(N % 5 == 0) {
			System.out.println("#1 :  " + N / 5);
			return;
		}
		
		if(N % 3 == 0) {
			//System.out.println("#2 :  " + N / 3);
			//return;
			yCases = N/3;
		}		
		
		
		for(int i=0; i<=x_size; i++) {
			int n = N - 5 * i;	//최대몫 범위만큼 N에서 5*i만큼 빼준 값
			//n이 3으로 나눠떨어지면 경우의수 계산
			//x=1 -> 18-5*1 = 13 -> 13%3 != 0
			//x=2 -> 18-5*2 = 8 -> 8%3 != 0
			//x=3 -> 18-5*3 = 3 -> 3%3 == 0
			if(n % 3 == 0) {
				if(n / 3 <= yCases) {
					xCases = i;
					yCases = n / 3;
					yn = true;
				}
			}
		}
		System.out.println("xCases : " + xCases);
		System.out.println("yCases : " + yCases);
		
		if(yn == true) {
			System.out.println("#3 :  " + (xCases + yCases));
			return;
		}
		
		if(yn == false) {
			System.out.println("#4 :  " + -1);
			return;
		}
		
		sc.close();
	
		//다른 사람 풀이를 보니
		//5로 나누는게 우선 최소 경우의 수이기 때문에
		//5로 먼저 나눈 다음 나누어 떨어지지 않으면 -3씩 차례대로 하면서 
		//5로 나누어 떨어질 때까지 횟수를 카운트해주는 식으로 한듯 싶다.(while문)
		//예시) N이 21일 때
		//21, cnt(0) -> 안나누어 떨어지므로 -3 -> 18, cnt(1) -> 안나누어 떨어지므로 15, cnt(2)
		//15/5 = 3이므로 3 + cnt = 5
	}
}
