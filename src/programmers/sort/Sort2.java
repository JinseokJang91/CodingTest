package programmers.sort;

import java.util.ArrayList;
import java.util.List;

public class Sort2 {

	//정렬>가장 큰 수
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//앞에 0 붙었을 때 출력 어떻게 되는지 확인
		//String a = "062";
		//System.out.println(Integer.parseInt(a));
		
		
		//경우의 수를 모두 List에 넣고 정렬하는게 제일 좋은 방법 같아보임
		//경우의 수를 구하는게 관건
		//6, 5, 4, 3 이면
		//6543 / 6534 / 6453 / 6435 / 6354 / 6345 ...
		
		//총 경우의 수 : numbers.length의 팩토리얼 -> ex) 4! = 4*3*2*1
		//한 번호 당 경우의 수 : 총 경우의 수 / 원소 개수(numbers.length)
		//이중 for문 쓰면 그럼 i쪽이 4, j쪽이 (3*2*1) 이 되어야 함
		int[] numbers = {6,10,2,3};
		
		String answer = "";
		
		List<String> list = new ArrayList<String>();
		
		int arrayLength = numbers.length;
		int eachCases = 1;
		for(int i=1; i<arrayLength; i++) {
			eachCases *= (arrayLength - i);
			
		}
		System.out.println("arrayLength : " + arrayLength);
		System.out.println("eachCases : " + eachCases);
		System.out.println();
		
		int index = 0;
		String element = "";
		for(int i=0; i<arrayLength; i++) {
			element = ""+numbers[i];
			for(int j=0; j<eachCases; j++) {
				if((i != index) && (index < arrayLength)) {
					 element += numbers[index];
					if(!list.contains(element)) {
						list.add(element);
					}
				}else {
					index++;
				}
			}
		}
		
		System.out.println("list : " + list);
		
	}

}
