package programmers.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sort1{

	//정렬>K번째 수
	public static void main(String[] args) {
		
		/* 동적 계획법>N으로 표현
		//주어지는 값 N, number
		int N = 5;
		int number = 12;
		
		//제한 조건
		//1. N은 1 이상 9 이하 => 1 <= N <= 9
		//2. number은 1 이상 32,000 이하 => 1 <= number <= 32000
		//3. 수식에는 괄호와 사칙연산만 가능, 나누기 연산에서 나머지는 무시 => (55+(5/5)+(5/5))/5하면 57/5는 11하고 나머지 2인데 나머지를 무시 => 나머지가 나오는 연산은 애초에 필요하지 않을듯
		//4. 최솟값(사용횟수)이 8보다 크면 -1을 return
		
		int answer = 0;
		
		String a = "" + N + N;
		System.out.println(a);
		Integer.parseInt(a);
		System.out.println(a);
		
		//마지막 String화해서 index로 개수?
		//N으로 나누는게 2개 이상이면 괄호로 묶을 수 있음
		//곱하기는 number가 N으로 나누어 떨어질 때 유용할듯
		*/
		
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		
		int[] answer = {};
		
		//제한 조건
		//1. 1 <= array의 length <= 100
		//2. 1 <= array[i] <= 100
		//3. 1 <= commmands의 length <= 50
		//4. commands[i].length = 3
		
		List<Integer> list = new ArrayList<Integer>();
		
		List<Integer> answList = new ArrayList<Integer>();
		
		int check = 0;
		
		if((array.length>=1 && array.length<=100) && (commands.length>=1 && commands.length<=50)) {
			for(int i=0; i<array.length; i++) {
				if(array[i]>=1 && array[i]<=100) {
					check = 1;
					list.add(array[i]);
				}
			}
			
			System.out.println("list : " + list);
			System.out.println();
			
			if(check == 1) {
				for(int j=0; j<commands.length; j++) {
					if(commands[j].length == 3) {
						
						//list.subList(commands[j][0]-1, commands[j][1]);
						System.out.println("## : " + list.subList(commands[j][0]-1, commands[j][1]));
						List<Integer> subList = new ArrayList<Integer>(list.subList(commands[j][0]-1, commands[j][1]));
						System.out.println("subList : " + subList);
						subList.sort(Comparator.naturalOrder());
						System.out.println("정렬 : " + subList);
						System.out.println("해당 인덱스의 숫자 : " + subList.get(commands[j][2]-1));
						
						answList.add(subList.get(commands[j][2]-1));
						System.out.println();
					}
				}
				
			}
			
			System.out.println("answList : " + answList);
		}
		
		answer = answList.stream().mapToInt(i->i).toArray();
		
		//기타 방법으로 List 안쓰고 배열만쓰고, Arrays.copyOfRange도 활용 가능(배열 복사)
		
	}

}
