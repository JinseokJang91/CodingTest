package programmers.sort;

import java.util.ArrayList;
import java.util.List;

public class Sort2 {

	//����>���� ū ��
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�տ� 0 �پ��� �� ��� ��� �Ǵ��� Ȯ��
		//String a = "062";
		//System.out.println(Integer.parseInt(a));
		
		
		//����� ���� ��� List�� �ְ� �����ϴ°� ���� ���� ��� ���ƺ���
		//����� ���� ���ϴ°� ����
		//6, 5, 4, 3 �̸�
		//6543 / 6534 / 6453 / 6435 / 6354 / 6345 ...
		
		//�� ����� �� : numbers.length�� ���丮�� -> ex) 4! = 4*3*2*1
		//�� ��ȣ �� ����� �� : �� ����� �� / ���� ����(numbers.length)
		//���� for�� ���� �׷� i���� 4, j���� (3*2*1) �� �Ǿ�� ��
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
