package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ques_2884 {

	public static void main(String[] args) throws IOException{
		
		int H = 0;
		int M = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] inputs = input.split(" ");
		
		H = Integer.valueOf(inputs[0]);
		M = Integer.valueOf(inputs[1]);

		if((H>=0 && H<=23) && (M>=0 && M<=59)) {
			
			if(M - 45 >= 0) {
				System.out.println(H + " " + (M - 45));
			}else {
				if(H != 0) {
					System.out.println((H - 1) + " " + (M - 45 + 60)); // 시간이 한 시간 빠지면 분은 15분 플러스 됨 -> M + 15
				}else {
					System.out.println((H - 1 + 24) + " " + (M - 45 + 60)); // 시간이 0시이면 1시간 빠졌을 때 23시로 되므로 + 24
				}
			}
			
		}
		
		br.close();
	}

}
