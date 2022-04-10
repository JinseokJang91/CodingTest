package programmers.exhausitiveSearch;

import java.util.ArrayList;

public class Search1{

	//완전탐색>모의고사
	public int[] solution(int[] answers) {
		return null;
	}
	
	public static void main(String[] args) {

		//제한 조건
		//1. 시험은 최대 10,000 문제로 구성
		//2. 문제의 정답은 1,2,3,4,5 중 하나
		//3. 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬
		int[] answers = {1,2,3,4,5,3,2,4,5,3,1,2,3,4,5};
		
		int[] answer = {};
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		
		//1번 수포자 = 1,2,3,4,5 반복
		//2번 수포자 = 2,1,2,3,2,4,2,5 반복
		//3번 수포자 = 3,3,1,1,2,2,4,4,5,5 반복
		int[] first = {1,2,3,4,5};
		int[] second = {2,1,2,3,2,4,2,5};
		int[] third = {3,3,1,1,2,2,4,4,5,5};
		
		ArrayList firstAnsw = new ArrayList();
		ArrayList secondAnsw = new ArrayList();
		ArrayList thirdAnsw = new ArrayList();

		if(answers.length <= 10000) {//제한 조건 1
			for(int i=0; i<answers.length; i++) {//제한 조건 2
				if(answers[i] > 5 || answers[i] < 1) {
					System.out.println("조건 탈락");
					return;
					//return null;
				}
			}
			
			//x가 딱 나누어 떨어질때 오류 발생 -> 변수 사용해서 나머지가 0일 때랑 0이 아닐 때로 나눠서 구분
			//int x = 0;//ArrayList에 1,2,3번 수포자의 배열을 반복적으로 넣기위해 사용하는 변수
			//	-->	변수로 주려고 했는데 x가 커질수록 소용이 없어지기 때문에(answers가 15의 길이면 나눈 몫은 3, 거기서 -1을 해도 10이 되기 때문에 틀림)
			//		그냥 나머지로 바로 처리하는 방법이 베스트였다.
			for(int i=0; i<answers.length; i++) {
				
				if(answers.length >= first.length) {
					if(i<first.length) {
						firstAnsw.add(first[i]);
					}else {
						firstAnsw.add(first[i%first.length]);
						/*
						x = answers.length/first.length;
						if(answers.length%first.length ==0) {
							firstAnsw.add(first[i-first.length*(x-1)]);
						}else {
							firstAnsw.add(first[i-first.length*(x)]);
						}*/
					}
					
				}else {
					firstAnsw.add(first[i]);
				}
				
				if(answers.length >= second.length) {
					if(i<second.length) {
						secondAnsw.add(second[i]);
					}else {
						secondAnsw.add(second[i%second.length]);
					}
					
				}else {
					secondAnsw.add(second[i]);
				}
				
				if(answers.length >= third.length) {
					if(i<third.length) {
						thirdAnsw.add(third[i]);
					}else {
						thirdAnsw.add(third[i%third.length]);
					}
					
				}else {
					thirdAnsw.add(third[i]);
				}
			}
			
		}

		System.out.println("firstAnsw : " + firstAnsw);
		System.out.println("secondAnsw : " + secondAnsw);
		System.out.println("thirdAnsw : " + thirdAnsw);
		
		int firstCnt = 0;
		int secondCnt = 0;
		int thirdCnt = 0;
		for(int i=0; i<answers.length; i++) {
			
			if(answers[i] == (int)firstAnsw.get(i)) {
				firstCnt++;
			}
			
			if(answers[i] == (int)secondAnsw.get(i)) {
				secondCnt++;
			}
			
			if(answers[i] == (int)thirdAnsw.get(i)) {
				thirdCnt++;
			}
		}
		
		System.out.println("firstCnt : " + firstCnt);
		System.out.println("secondCnt : " + secondCnt);
		System.out.println("thirdCnt : " + thirdCnt);
		
		//문제를 많이 맞춘 순서대로 나열하기 위한 코드(동수일 경우도 포함)
		if(firstCnt>secondCnt) {
			if(firstCnt>thirdCnt) {
				answerList.add(1);
			}else if(firstCnt == thirdCnt) {
				answerList.add(1);
				answerList.add(3);
			}else {
				answerList.add(3);
			}
		}else if(firstCnt == secondCnt){
			if(firstCnt>thirdCnt) {
				answerList.add(1);
				answerList.add(2);
			}else if(firstCnt == thirdCnt) {
				answerList.add(1);
				answerList.add(2);
				answerList.add(3);
			}else {
				answerList.add(3);
			}
		}else {
			if(secondCnt>thirdCnt) {
				answerList.add(2);
			}else if(secondCnt == thirdCnt) {
				answerList.add(2);
				answerList.add(3);
			}else {
				answerList.add(3);
			}
		}
		
		//System.out.println(answer.length);
		
		answer = answerList.stream().mapToInt(i->i).toArray();
		//stream API 사용 (https://jeanette.tistory.com/155)
		//answerList.stream().mapToInt(i->i).toArray() 또는
		//answerList.stream().mapToInt(Integer::intValue).toArray()
		
		System.out.println("answerList : " + answerList);
		/*
		for(int i=0; i<answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}*/
		
		System.out.println("answer배열 주소값 : "+answer);
		System.out.print("최종 답 : ");
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

}
