package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_2577 {

	public static void main(String[] args) throws Exception{

		//2577번 숫자의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		String result = String.valueOf(A * B * C);
		
		int[] arr = new int[10];
		
		for(int i=0; i<result.length(); i++) {
			
			int temp = Integer.parseInt(String.valueOf(result.charAt(i)));
			switch(temp) {
			case 0 :
				arr[0]++;
				break;
			case 1 :
				arr[1]++;
				break;
			case 2 :
				arr[2]++;
				break;
			case 3 :
				arr[3]++;
				break;
			case 4 :
				arr[4]++;
				break;
			case 5 :
				arr[5]++;
				break;
			case 6 :
				arr[6]++;
				break;
			case 7 :
				arr[7]++;
				break;
			case 8 :
				arr[8]++;
				break;
			case 9 :
				arr[9]++;
				break;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		br.close();
	}

}
