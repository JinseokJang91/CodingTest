package programmers.allProblems.lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LV2_01 {

	public static void main(String[] args) throws Exception{

		//연습문제 > 124 나라의 숫자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		System.out.println("n : " + n);
		
		//124나라에서 10진법 표기 방법
		//10진법 - 124나라
		//1 - 1
		//2 - 2
		//3 - 4
		//4 - 11
		//5 - 12
		//6 - 14
		//7 - 21
		//8 - 22
		//9 - 24
		//10 - 41
		//11 - 42
		//12 - 44
		//13 - 111
		//14 - 112
		//15 - 114
		//16 - 121
		//...
		
		//1, 2, 4를 번갈아가면서 규칙적으로 사용
		//3진법 문제이기 때문에 몫이 3보다 작아질 때까지 나누고, 몫과 나머지 값을 이용해 자릿수 값을 구한다.
		//단, 3진법에서 0,1,2가 아닌 1,2,4 를 이용해야 하기 때문에 나누어 떨어지는 경우 나머지를 0이 아닌 몫에서 하나를 빼와 3으로 치환한다.
		
		//1 - 1		-> 3으로 나누면 몫 0, 나머지 1
		//2 - 2		-> 3으로 나누면 몫 0, 나머지 2
		//3 - 4		-> 3으로 나누면 몫 1, 나머지 0가 아닌 몫 0, 나머지 3으로 생각
		
		
		//4 - 11	-> 3으로 나누면 몫 1, 나머지 1
		//5 - 12	-> 3으로 나누면 몫 1, 나머지 2
		//6 - 14	-> 3으로 나누면 몫 1, 나머지 3 으로 생각
		//7 - 21	-> 3으로 나누면 몫 2, 나머지 1
		//8 - 22	-> 3으로 나누면 몫 2, 나머지 2
		//9 - 24	-> 3으로 나누면 몫 2, 나머지 3 으로 생각
		//10 - 41	-> 3으로 나누면 몫 3, 나머지 1
		//11 - 42	-> 3으로 나누면 몫 3, 나머지 2
		//12 - 44	-> 3으로 나누면 몫 3, 나머지 3 으로 생각
		
		
		//13 - 111	-> 3으로 나누면 몫 4, 나머지 1 -> 몫을 3으로 나누면 몫 1, 나머지 1 -> 몫 나머지 나머지 -> 1 1 1
		//14 - 112	-> 3으로 나누면 몫 4, 나머지 2 -> 몫을 3으로 나누면 몫 1, 나머지 1
		//15 - 114	-> 3으로 나누면 몫 4, 나머지 3 -> 몫을 3으로 나누면 몫 1, 나머지 1
		//16 - 121	-> 3으로 나누면 몫 5, 나머지 1 -> 몫을 3으로 나누면 몫 1, 나머지 2
		//17 - 122	-> 3으로 나누면 몫 5, 나머지 2 -> 몫을 3으로 나누면 몫 1, 나머지 2
		//18 - 124	-> 3으로 나누면 몫 5, 나머지 3 -> 몫을 3으로 나누면 몫 1, 나머지 2
		//19 - 141	-> 3으로 나누면 몫 6, 나머지 1 -> 몫을 3으로 나누면 몫 2, 나머지 0
		//20 - 142	-> 3으로 나누면 몫 6, 나머지 2 -> 몫을 3으로 나누면 몫 2, 나머지 0
		//21 - 144	-> 3으로 나누면 몫 6, 나머지 3 -> 몫을 3으로 나누면 몫 1, 나머지 3
		
		//22 - 211
		//23 - 212
		//24 - 214
		//25 - 221
		//26 - 222
		//27 - 224	-> 3으로 나누면 몫 8, 나머지 3 -> 몫을 3으로 나누면 몫 2, 나머지 2
		//28 - 241	-> 3으로 나누면 몫 9, 나머지 1 -> 몫을 3으로 나누면 몫 2, 나머지 3
		//29 - 242
		//30 - 244
		
		//31 - 411
		//32 - 412
		//33 - 414
		//34 - 421
		//35 - 422
		//36 - 424	-> 3으로 나누면 몫 11, 나머지 3 -> 몫을 3으로 나누면 몫 3, 나머지 2 -> 몫을 3으로 나누면 몫 0, 나머지 3
		//37 - 441
		//38 - 442
		//39 - 444	-> 3으로 나누면 몫 12, 나머지 3 -> 몫을 3으로 나누면 몫 3, 나머지 3 -> 몫을 3으로 나누면 몫 0, 나머지 3
		
		//...
		
		List<Integer> list = new ArrayList<Integer>();
		
		int rest = 0;
		int share = n;
		
		while(true) {
			
			rest = share % 3;
			share = share / 3;
			
			//System.out.println("초기 share : " + share);
			//System.out.println("초기 rest : " + rest);
			if(rest == 0) {
				System.out.println("나머지가 0일때");
				share--;
				rest += 3;
			}
			System.out.println("최종 share : " + share);
			System.out.println("최종 rest : " + rest);
			list.add(rest);
			if(share < 3) {
				break;
			}
		}
		
		if(share > 0) {
			list.add(share);
		}
		
		System.out.println("list : " + list);
		
		String answer = "";
		for(int i=list.size()-1; i>=0; i--) {
			answer += list.get(i);
		}
		
		System.out.println("answer : " + answer);
		
		answer = answer.replace('3', '4');
		//answer = answer.replaceAll("3", "4");
		
		System.out.println("answer : " + answer);
	}

}
