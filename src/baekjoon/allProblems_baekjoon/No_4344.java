package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_4344 {

	public static void main(String[] args) throws Exception{

		//4344번 평균은 넘겠지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		String[] inputs = new String[C];
		
		for(int i=0; i<C; i++) {
			inputs[i] = br.readLine();
		}
	
		String[] temp = null;
		for(int i=0; i<inputs.length; i++) {
			temp = inputs[i].split(" ");
			int len = Integer.parseInt(temp[0]);
			double[] arr = new double[len];
			for(int j=1; j<temp.length; j++) {
				arr[j-1] = Double.parseDouble(temp[j]);
				//System.out.println("arr[j-1] : " + arr[j-1]);
			}
			
			double avg = 0;
			double sum = 0;
			for(int j=0; j<arr.length; j++) {
				sum += arr[j];
			}
			avg = sum / (double)arr.length;
			//System.out.println("sum : " + sum);
			//System.out.println("avg : " + avg);
			
			double smartCnt = 0;
			for(int j=0; j<arr.length; j++) {
				if(arr[j] > avg) {
					smartCnt++;
				}
			}
			
			String answer = String.format("%.3f", (smartCnt / (double)len * 100)) + "%";
			System.out.println(answer);
			
			br.close();
			
			//☆☆☆여기서 기억해야 할 부분
			//String.format()
		}
	}

}
