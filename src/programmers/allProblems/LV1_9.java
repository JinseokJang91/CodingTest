package programmers.allProblems;

import java.util.Scanner;

public class LV1_9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        //System.out.println(a + b);
        
        //연습문제 > 직사각형 별찍기

        //가로의 길이가 n, 세로의 길이가 m인 별 (*) 직사각형 형태를 출력
        
        if((a >= 1 && a <= 1000) && (b >= 1 && b <= 1000))
        
        for(int i=0; i<b; i++) {
        	for(int j=0; j<a; j++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
	}

}
