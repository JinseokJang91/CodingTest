package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_10809 {

	public static void main(String[] main) throws Exception{
		
		//10809¹ø ¾ËÆÄºª Ã£±â
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		//ÃÑ ¾ËÆÄºª °³¼ö ±¸ÇÏ±â
		char alpha = 'a';
		int cnt = 0;
		while(true) {
			alpha++;
			cnt++;
			
			if(alpha == 'z') {
				cnt++;
				break;
			}
		}
		//System.out.println("cnt : " + cnt);
		
		char start = 'a';
		for(int i=0; i<cnt; i++) {
			System.out.print(input.indexOf(String.valueOf((char)(start + i))) + " ");
		}
		
		br.close();
	}
}
