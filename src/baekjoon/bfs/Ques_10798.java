package baekjoon.bfs;

import java.util.Scanner;

public class Ques_10798 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//String[] inputs = new String[5];
		char[][] inputs = new char[5][];
		
		for(int i=0; i<inputs.length; i++) {
			inputs[i] = sc.nextLine().toCharArray();
		}
		
		char[][] arr = new char[5][15];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = 32;
			}
		}

		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<inputs[i].length; j++) {
				arr[i][j] = inputs[i][j];
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i=0; i<arr[0].length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[j][i] != 32) {
					System.out.print(arr[j][i]);
				}
			}
		}
		
		sc.close();
		
		//char 정리
		//32는 공백
		//소문자  : 97~122
		//대문자 : 65~90
		//숫자 : '0'으로
		
	}

}
