package programmers.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Greedy1 {

	//탐욕법>체육복
	public static void main(String[] args) {
		
		//바로 앞번호의 학생이나, 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있다.
		//전체 학생의 수 n, 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve
		//체육수업을 들을 수 있는 학생의 최댓값을 return
		
		//제한 사항
		//1. n은 2 이상 30 이하
		//2. lost의 length는 1 이상 n 이하, 중복되는 번호 없음
		//3. reserve의 length는 1 이상 n 이하, 중복되는 번호 없음
		//4. reserve에 담겨있는 학생만 다른 학생에게 체육복을 빌려줄 수 있음
		//5. reserve에 담겨있는 학생이 lost에 담겨있을 수 있음, 이럴 경우 다른 학생에게 체육복을 빌려줄 수 없음
		
		//테스트 케이스 1
		int n = 20;
		int[] lost = {6,4,5,2,1,10};
		int[] reserve = {5,8,12,4,2,6};
		/*
		if((n>=2 && n<=30) && (lost.length>=1 && lost.length<=n) && (reserve.length>=1 && reserve.length<=n)) {
			System.out.println("---제한 사항 1,2,3 충족");
			
			List<Integer> lostList = new ArrayList<Integer>();
			List<Integer> reserveList = new ArrayList<Integer>();
			
			//removeAll을 사용하기 위해 비교할 대상군 리스트
			List<Integer> lostList2 = new ArrayList<Integer>();
			List<Integer> reserveList2 = new ArrayList<Integer>();
			
			for(int i=0; i<lost.length; i++) {
				lostList.add(lost[i]);
				lostList2.add(lost[i]);
			}
			for(int i=0; i<reserve.length; i++) {
				reserveList.add(reserve[i]);
				reserveList2.add(reserve[i]);
			}
			System.out.println("lostList : " + lostList);
			System.out.println("reserveList : " + reserveList);
			
			//체육복을 빌려줄 수 있는 조건이 lost에 있는 번호의 앞 또는 뒷번호가 reserve에 있는 경우
			//lost에 있는 변호를 reserve로 옮긴 후 n - lost.length
			//즉, n - 체육복을 못빌린 학생 수 이다.			
			//단, lost와 reserve 둘 다에 해당되는 학생일 경우를 생각
			//마찬가지로 reserve로 옮기고 HashSet을 사용해서 중복 제거하자 --> n에서 lost를 빼야해서 중복 제거가 의미 없어짐(나중에 다른 문제에 사용해보기)
			
			//removeAll을 사용해서 lost와 reserve 둘 다에 해당되는 학생을 리스트에서 제거
			lostList.removeAll(reserveList2);
			reserveList.removeAll(lostList2);
			//비교군 리스트 내부를 비우고
			lostList2.clear();
			reserveList2.clear();
			//중복 제거된 리스트를 다시 삽입
			if(!lostList.isEmpty() && !reserveList.isEmpty()) {
				lostList2.addAll(lostList);
				reserveList2.addAll(reserveList);
				
				for(int i=0; i<lostList.size(); i++) {
					System.out.println("포함 여부 확인 : " + reserveList.contains(lostList.get(i)));
					if(!lostList2.isEmpty() && !reserveList.isEmpty()) {
						if((reserveList.contains(lostList.get(i)-1))) {
							System.out.println("있다1");
							System.out.println(lostList.get(i));
							lostList2.remove(lostList.get(i));
							reserveList.remove(Integer.valueOf(lostList.get(i)-1));//remove(Object O)이기 때문에 Integer 객체화 시켜줌
						}else if((reserveList.contains(lostList.get(i)+1))) {
							System.out.println("있다2");
							System.out.println(lostList.get(i));
							lostList2.remove(lostList.get(i));
							reserveList.remove(Integer.valueOf(lostList.get(i)+1));
						}
					}
					
					
					//for(int j=0; j<reserveList.size(); j++) {
					//	if(!lostList.isEmpty() && !reserveList.isEmpty()) {
					//		//앞 뒷 번호와 비교해서 빌릴 수 있는지 확인
					//		if((lostList.get(i)-1 == reserveList.get(j)) || (lostList.get(i)+1 == reserveList.get(j))) {
					//			System.out.println(lostList.get(i) + "번 학생이 " + reserveList.get(j) + "번 학생에게 빌릴 수 있다");
					//			lostList.remove(i);
					//			reserveList.remove(j);
					//		}
					//	}
					//}
				}
			}
			
			System.out.println("lostList : " + lostList);
			System.out.println("reserveList : " + reserveList);
			System.out.println("lostList2 : " + lostList2);
			System.out.println("reserveList2 : " + reserveList2);
			
			
			
			//HashSet 이용해서 중복 제거하기(https://hianna.tistory.com/582)
			//Set<Integer> reserveSet = new HashSet<Integer>(reserveList);
			//List<Integer> finalList = new ArrayList<Integer>(reserveSet);
			
			System.out.println("lostList : " + lostList);
			System.out.println("lostList2 : " + lostList2);
			System.out.println("reserveList : " + reserveList);
			System.out.println("reserveList2 : " + reserveList2);
			//System.out.println("reserveSet : " + reserveSet);
			//System.out.println("finalList : " + finalList);
			
			System.out.println("return값 : " + n + " - " + lostList2.size() + " = " + (n-lostList2.size()));
			
			//핵심 정리
			//1. 중복 제거는 HashSet 이용해서 할 수 있음
			// - ArrayList를 Set으로 옮겼다가 다시 ArrayList로 옮기면 됨(77번줄)
			//2. removeAll 메소드
			// - https://ddolcat.tistory.com/513
			
		}*/
		
        if((n>=2 && n<=30) && (lost.length>=1 && lost.length<=n) && (reserve.length>=1 && reserve.length<=n)) {
			
			List<Integer> lostList = new ArrayList<Integer>();
			List<Integer> reserveList = new ArrayList<Integer>();
			
			//removeAll을 사용하기 위해 비교할 대상군 리스트
			List<Integer> lostList2 = new ArrayList<Integer>();
			List<Integer> reserveList2 = new ArrayList<Integer>();
			
			Arrays.sort(lost);
			Arrays.sort(reserve);
			
			for(int i=0; i<lost.length; i++) {
				lostList.add(lost[i]);
				lostList2.add(lost[i]);
			}
			for(int i=0; i<reserve.length; i++) {
				reserveList.add(reserve[i]);
				reserveList2.add(reserve[i]);
			}
			
			System.out.println("lostList : " + lostList);
			System.out.println("reserveList : " + reserveList);
			System.out.println("lostList2 : " + lostList2);
			System.out.println("reserveList2 : " + reserveList2);
			System.out.println("=========================================");
			
			//removeAll을 사용해서 lost와 reserve 둘 다에 해당되는 학생(여벌 체육복을 가지고 있고, 도난도 당한 학생, 즉 자기꺼만 있는 학생)을 리스트에서 제거
			lostList.removeAll(reserveList2);
			reserveList.removeAll(lostList2);
			System.out.println("lostList : " + lostList);
			System.out.println("reserveList : " + reserveList);
			System.out.println("lostList2 : " + lostList2);
			System.out.println("reserveList2 : " + reserveList2);
			System.out.println("=========================================");
			
			
			//비교군 리스트 내부를 비우고
			lostList2.clear();
			reserveList2.clear();
			System.out.println("lostList : " + lostList);
			System.out.println("reserveList : " + reserveList);
			System.out.println("lostList2 : " + lostList2);
			System.out.println("reserveList2 : " + reserveList2);
			System.out.println("=========================================");
			
			//중복 제거된 리스트를 다시 삽입
            lostList2.addAll(lostList);
            reserveList2.addAll(reserveList);
            System.out.println("lostList : " + lostList);
			System.out.println("reserveList : " + reserveList);
			System.out.println("lostList2 : " + lostList2);
			System.out.println("reserveList2 : " + reserveList2);
			System.out.println("=========================================");

			//앞번호 또는 뒷번호에 해당하는 학생이 있어서 체육복을 빌릴 수 있으면 빌린 학생의 번호와 빌려준 학생의 번호를 제거
            for(int i=0; i<lostList.size(); i++) {
                if(!lostList2.isEmpty() && !reserveList2.isEmpty()) {
                    if((reserveList2.contains(lostList.get(i)-1))) {
                        lostList2.remove(lostList.get(i));
                        reserveList2.remove(Integer.valueOf(lostList.get(i)-1));
                    }else if((reserveList2.contains(lostList.get(i)+1))) {
                        lostList2.remove(lostList.get(i));
                        reserveList2.remove(Integer.valueOf(lostList.get(i)+1));
                    }
                }
		    }
            
			

			int answer = n - lostList2.size();
			System.out.println("lostList : " + lostList);
			System.out.println("reserveList : " + reserveList);
			System.out.println("lostList2 : " + lostList2);
			System.out.println("reserveList2 : " + reserveList2);
			System.out.println("answer : " + answer);
			
		}
	}

}
