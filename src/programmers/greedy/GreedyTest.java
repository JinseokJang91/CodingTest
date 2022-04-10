package programmers.greedy;

import java.util.ArrayList;
import java.util.List;

public class GreedyTest {
	public int solution(String name) {
		// 탐욕법>조이스틱
		//▲ - 다음 알파벳
		//▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
		//◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
		//▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
		
		//알파벳은 총 26개(A~Z : 65~90 , a~z : 97~122)

		int answer = 0;
		
		int check = 0;
		if(name.length()>=1 && name.length()<=20) {
			for(int i=0; i<name.length(); i++) {
				if(name.charAt(i)>='A' && name.charAt(i)<='Z') {
					check = 1;
				}else {
					check = 0;
					break;
				}
			}
		}
		
		// 문자를 맞출 수 있는 방법은 아래,위
		// 원하는 위치로 이동할 수 있는 방법은 좌,우
		
		//▲ - name.charAt(i) - base.charAt(i)
		//▼ - base.charAt(i) - name.charAt(i) + 26
		//위에 두 개 값 비교해서 작은 거로 진행

		//◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
		//▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서) -> 마지막 위치에서 오른쪽으로 이동해서 첫 번째로 돌아가는 경우는 없을듯?
		//첫 번째 위치에서만 비교하면 될 것 같음
		//만약 ZANAAEB 이면 N 인덱스에서 좌로 움직이는게 더 횟수가 적으므로 A가 아닌 문자 각 인덱스에서 비교가 필욘
		
		//J - A 는 9, 만약 Z, A이면 Z - A = 25인데 A에서 하나만 내려가도 Z니까 +26?
		
		
		//총 청리
		//1. 각 인덱스의 문자를 결정하는 것은 조이스틱을 아래위로 움직이는 것
		//2. 다음 A가 아닌 인덱스를 찾는 것은 조이스틱을 좌우로 움직이는 것
		// 따라서, 아래위/좌우 두 가지 경우로 나누어 계산
		// 1. 아래위 : A가 아닌 인덱스만 고려해서 아래위 움직임 여부를 결정
		// 2. 좌우 : A가 아닌 인덱스에서 다음 인덱스까지 좌우 움직임 비교해서 최솟값 추출
		// 예시 : ZANAAAB이면
		//		Z에서 N으로 이동 : 우 2, 좌 5 이므로 우 2 선택
		//		N에서 B으로 이동 : 우 4, 좌 3 이므로 좌 3 선택
		//		공식 정리하면 0, 2, 6 인덱스에서 각각 A가 아닌 문자임
		//		전체 길이가 7일 때
		//		우로 이동하는 횟수를 구하려면 2 - 0 / 6 - 2
		//		좌로 이동하는 횟수를 구하려면 (7-2) + (0-0) = 7-(2-0) / (7-6) + (2-0) = 7-(6-2)
		if(check == 1) {
			char base = 'A';
			int sum = 0;
			name = "BBBAAAAB";
			List<String> notAList = new ArrayList<String>();
			for(int i=0; i<name.length(); i++) {
				if(name.charAt(i) != 'A') {
					notAList.add(String.valueOf(i));
				}
			}
			System.out.println("notAList: " + notAList);
			//System.out.println("gap: " + (Integer.valueOf(notAList.get(2))-Integer.valueOf(notAList.get(0))));
			/*
			for(int i=0; i<notAList.size(); i++) {
				if(i+1<notAList.size()) {
					int moveRight = notAList.get(i+1) - notAList.get(i);
					int moveLeft = (name.length() - (notAList.get(i+1) - notAList.get(i)));
					System.out.println(moveRight + " / " + moveLeft);
					if(moveRight > moveLeft) {
						sum += moveLeft;
					}else {
						sum += moveRight;
					}
				}
			}
			System.out.println("sum : " + sum);*/
			//위 식은 BAAAABB의 경우 세 개의 B로 이동할 때
			//0번째 인덱스에서 5번째 인덱스 B로 이동(좌로 2번) -> 5번째 인덱스에서 6번째 인덱스 B동 이동(우로 1번)
			//를 고려한 식이고
			//0번째 인덱스에서 6번째 인덱스 B로 이동(좌로 1번) -> 6번째 인덱스에서 5번째 인덱스 B로 이동(좌로 1번)
			//라는 더 최소 횟수를 구하는 방법이 있으므로 틀린 식이라고 할 수 있다.
			//(BBBAAAAB의 예시도 있음 -> 최소 8번으로 이동 가능) => 좌측 1번, 우측 2번, 우측 1번
			System.out.println("======================");

			//문자열 내에서 좌우로 움직일 때 A가 아닌 문자를 만나는 경우, 그때까지의 횟수를 구해보자
			//시작 인덱스에서 시작해 각 단계마다 좌우 고려 -> 시작 인덱스에서만 다음 인덱스로 이동할 때 횟수가 같은 경우가 나옴, 그 다음부터는 같은 경우가 존재할 수없음(시작 인덱스 +1되므로)
			//각 단계의 인덱스는 다음 단계에서 제외해야함
			//notAList: [0, 1, 2, 7]일 때
			List<Integer> cases = new ArrayList<Integer>();
			int totalCases = (int)Math.pow(2, notAList.size()-1);
			System.out.println("totalCases : "+totalCases);
			int firstMoveRight = Integer.parseInt(notAList.get(1)) - Integer.parseInt(notAList.get(0));
			int cursorMove = Integer.parseInt(notAList.get(0)) - Integer.parseInt(notAList.get(notAList.size()-1));
			int firstMoveLeft = (cursorMove < 0) ? (cursorMove+name.length()) : (cursorMove);
			System.out.println("첫 우측 이동 : " + firstMoveRight);
			System.out.println("첫 좌측 이동 : " + firstMoveLeft);
			System.out.println("cursor : " + cursorMove);
			if(firstMoveRight == firstMoveLeft) {
				System.out.println("!!!!" + notAList);
				List<String> list1 = new ArrayList<String>();
				list1 = notAList.subList(0, notAList.size());
				List<String> list2 = new ArrayList<String>();
				list2 = notAList.subList(0, notAList.size());
				System.out.println("list1 : " + list1);
				System.out.println("list2 : " + list2);
				
				int rightResult = calRight(1, list2);
				System.out.println("!!!!" + notAList);
				int leftResult = calLeft(notAList.size()-1, list1);
			}
			
			
			int moveRight = 0;
			int moveLeft = 0;
			int index = 0;
			while(cases.size() == totalCases) {
				
				
				break;
				
			}
			/*
			System.out.println("======================");			
			
			
			for(int i=0; i<name.length(); i++) {
				if(name.charAt(i) != base) {
					int moveUpper = name.charAt(i) - base;
					int moveLower = 26 - (name.charAt(i) - base);
					System.out.println((name.charAt(i) - base) + " / " + (base - name.charAt(i) + 26));
					if(moveUpper > moveLower) {
						sum += moveLower;
						System.out.println("## : " + sum);
					}else{
						sum += moveUpper;
						System.out.println("## : " + sum);
					}
				}
			}
			System.out.println("sum : " + sum);
			*/
		}
		return answer;
	}
	
	public int calLeft(int after1, List<String> list1) {
		while(true) {
			System.out.println("**************좌 계산*****************");
			System.out.println("after : " + after1);
			System.out.println("list : " + list1);
			list1.set(0, "#");
			int moveLeft = 0;
			
			while(true) {
				int sharp = 0;
				for(int i=0; i<list1.size(); i++) {
					if(list1.get(i).equals("#")) {
						sharp++;
					}
				}
				if(sharp == list1.size() - 1) {
					break;
				}
				
				int left = after1;
				if(left-1 > 0) { //좌로 이동 시 좌로 갈 경우
					if(!list1.get(left-1).equals("#")) {
						moveLeft = Integer.parseInt(list1.get(left));
						list1.set(left, "#");
						break;
					}else {
						left--;
					}
				}else {						//좌로 이동 시 우 마지막으로 갈 경우
					left = list1.size()-1;
					if(!list1.get(left-1).equals("#")) {
						moveLeft = Integer.parseInt(list1.get(left));
						list1.set(left, "#");
						break;
					}else {
						left--;
					}
				}
			}

			System.out.println("좌 : " + moveLeft);
			break;
			
		}
		return 0;
	}
	
	public int calRight(int after2, List<String> list2) {
		while(true) {
			System.out.println("**************우 계산*****************");
			System.out.println("after : " + after2);
			System.out.println("list : " + list2);
			list2.set(0, "#");
			int moveRight = 0;
			
			while(true) {
				int sharp = 0;
				for(int i=0; i<list2.size(); i++) {
					if(list2.get(i).equals("#")) {
						sharp++;
					}
				}
				if(sharp == list2.size() - 1) {
					break;
				}
				int right = after2;
				
				if(right+1 < list2.size()) { //우로 이동 시 우로 갈 경우
					if(!list2.get(right+1).equals("#")) {
						moveRight = Integer.parseInt(list2.get(right));
						System.out.println("확인 : " + moveRight);
						list2.set(right, "#");
						System.out.println("확인 : " + right);
						break;
					}else {
						right++;
					}
				}else {						//우로 이동 시 좌 첫 번쨰로 갈 경우
					right = 0;
					if(!list2.get(right+1).equals("#")) {
						moveRight = Integer.parseInt(list2.get(right));
						list2.set(right, "#");
						break;
					}else {
						right++;
					}
				}
			}

			System.out.println("우 : " + moveRight);
			break;
			
		}
		return 0;
	}
}
