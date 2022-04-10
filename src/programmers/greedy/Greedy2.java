package programmers.greedy;

import java.util.ArrayList;
import java.util.List;

public class Greedy2 {

	public static void main(String[] args) {
		// 탐욕법>조이스틱
		//▲ - 다음 알파벳
		//▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
		//◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
		//▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
		
		//알파벳은 총 26개(A~Z : 65~90 , a~z : 97~122)
		String name = "BAAAABB";

		GreedyTest gt = new GreedyTest();
		int result = gt.solution(name);
		System.out.println("result : " + result);
		
	}

}
