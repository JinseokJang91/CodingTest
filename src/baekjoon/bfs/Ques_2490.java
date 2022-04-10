package baekjoon.bfs;

import java.util.Scanner;

public class Ques_2490 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] inputs = new int[3][4];
		
		for(int i=0; i<inputs.length; i++) {
			for(int j=0; j<inputs[i].length; j++) {
				inputs[i][j] = sc.nextInt();
			}
		}
		sc.nextLine();
		
		for(int i=0; i<inputs.length; i++) {
			for(int j=0; j<inputs[i].length; j++) {
				System.out.print(inputs[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i=0; i<inputs.length; i++) {
			int count = 0;
			for(int j=0; j<inputs[i].length; j++) {
				if(inputs[i][j] == 0 || inputs[i][j] == 1) {
					switch(inputs[i][j]) {
					case 0 :
						count++;
						break;
					case 1 :
						break;
					}
				}
			}
			switch(count) {
			case 0 :
				System.out.println("E");
				break;
			case 1 :
				System.out.println("A");
				break;
			case 2 :
				System.out.println("B");
				break;
			case 3 :
				System.out.println("C");
				break;
			case 4 :
				System.out.println("D");
				break;
			}
		}
		
		sc.close();

	}

}
