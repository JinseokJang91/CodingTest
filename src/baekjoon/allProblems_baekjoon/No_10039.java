package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_10039 {

	public static void main(String[] args) throws Exception{

		//10039번 평균점수
		//40점 미만인 점수는 40점으로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] inputs = new int[5];
		for(int i=0; i<inputs.length; i++) {
			inputs[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = 0;
		for(int i=0; i<inputs.length; i++) {
			if(inputs[i] < 40) {
				inputs[i] = 40;
			}
			sum += inputs[i];
		}
		
		//double avg = (double)sum / 5; //평군점수는 항상 정수임
		int avg = sum / 5;
		System.out.println(avg);
		
		br.close();
	}

}
