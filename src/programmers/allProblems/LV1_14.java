package programmers.allProblems;

public class LV1_14 {

	public static void main(String[] args) {
		SolutionLV1_14 sol = new SolutionLV1_14();
		//int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		//int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String hand = "right";
		//String hand = "left";
		String answer = sol.solution(numbers, hand);
		System.out.println("answer : " + answer);

	}

}

class SolutionLV1_14 {
    public String solution(int[] numbers, String hand) {
    	
    	//2020 카카오 인턴십 > 키패드 누르기
        String answer = "";
        
        int check = 0;
        if(numbers.length >= 1 && numbers.length <= 1000) {
        	for(int i=0; i<numbers.length; i++) {
        		if(numbers[i] >= 0 && numbers[i] <= 9) {
        			check = 1;
        		}else {
        			check = 0;
        			break;
        		}
        	}
        }
        
        if(check == 1) {
        	//  1	2	3
            //	4	5	6
            //	7	8	9
            //	*	0	#
            
            // 1,4,7은 왼손 엄지
            // 3,6,9는 오른손 엄지
            // 2,5,8,0은 각 엄지손가락 중 더 가까운 위치에 있는 것.
            // 단, 거리가 같으면 오른손잡이, 왼손잡이 여부에 따라 판별
        	
        	// 이차원 배열 이용해서 좌표값을 구하면 거리를 알 수 있음
        	// 1,4,7은 무조건 왼손이고, 3,6,9는 무조건 오른손
        	// 따라서 2,5,8,0의 경우만 고려하면 됨
        	// 각 손의 위치를 담을 변수 필요
        	//int[][] numArr = {{1,2,3},{4,5,6},{7,8,9},{0,0,0}};
        	int lx = 3;
        	int ly = 0;
        	int rx = 3;
        	int ry = 2;
        	int mx = 0;
        	int my = 0;
        	int lGap = 0;
        	int rGap = 0;
        	
        	for(int i=0; i<numbers.length; i++) {
        		//왼손 엄지
        		if(numbers[i] == 1) {
        			//System.out.println("1일 때");
        			lx = 0;
        			ly = 0;
        			answer += "L";
        			System.out.println("answer : " + answer);
        		}
				if(numbers[i] == 4) {
					//System.out.println("4일 때");
					lx = 1;
        			ly = 0;
        			answer += "L";
        			System.out.println("answer : " + answer);
				}
				if(numbers[i] == 7) {
					System.out.println("7일 때");
					lx = 2;
        			ly = 0;
        			answer += "L";
        			System.out.println("answer : " + answer);
				}
				//오른손 엄지
				if(numbers[i] == 3) {
        			//System.out.println("3일 때");
        			rx = 0;
        			ry = 2;
        			answer += "R";
        			System.out.println("answer : " + answer);
        		}
				if(numbers[i] == 6) {
					//System.out.println("6일 때");
					rx = 1;
        			ry = 2;
        			answer += "R";
        			System.out.println("answer : " + answer);
				}
				if(numbers[i] == 9) {
					//System.out.println("9일 때");
					rx = 2;
        			ry = 2;
        			answer += "R";
        			System.out.println("answer : " + answer);
				}
				
				//중간 번호
				if(numbers[i] == 2) {
					System.out.println("2일 때");
					mx = 0;
					my = 1;
					lGap = Math.abs(mx-lx) + Math.abs(my-ly);
					rGap = Math.abs(mx-rx) + Math.abs(my-ry);
					System.out.println("lGap : " + lGap);
					System.out.println("rGap : " + rGap);
					if(lGap < rGap) {
						lx = mx;
						ly = my;
						answer += "L";
						//System.out.println("왼손이 더 가까울 때 : " + answer);
					}else if(rGap < lGap){
						rx = mx;
						ry = my;
						answer += "R";
						//System.out.println("오른손이 더 가까울 때 : " + answer);
					}else {
						if(hand.equals("left")) {
							//System.out.println("거리 같고 왼손잡이일 때");
							lx = mx;
							ly = my;
							answer += "L";
						}else {
							//System.out.println("거리 같고 오른손잡이일 때");
							rx = mx;
							ry = my;
							answer += "R";
						}
					}
					System.out.println("answer : " + answer);
				}
				
				if(numbers[i] == 5) {
					//System.out.println("2일 때");
					mx = 1;
					my = 1;
					lGap = Math.abs(mx-lx) + Math.abs(my-ly);
					rGap = Math.abs(mx-rx) + Math.abs(my-ry);
					System.out.println("lGap : " + lGap);
					System.out.println("rGap : " + rGap);
					if(lGap < rGap) {
						lx = mx;
						ly = my;
						answer += "L";
						//System.out.println("왼손이 더 가까울 때 : " + answer);
					}else if(rGap < lGap){
						rx = mx;
						ry = my;
						answer += "R";
						//System.out.println("오른손이 더 가까울 때 : " + answer);
					}else {
						if(hand.equals("left")) {
							//System.out.println("거리 같고 왼손잡이일 때");
							lx = mx;
							ly = my;
							answer += "L";
						}else {
							//System.out.println("거리 같고 오른손잡이일 때");
							rx = mx;
							ry = my;
							answer += "R";
						}
					}
					System.out.println("answer : " + answer);
				}
				
				if(numbers[i] == 8) {
					System.out.println("8일 때");
					mx = 2;
					my = 1;
					lGap = Math.abs(mx-lx) + Math.abs(my-ly);
					rGap = Math.abs(mx-rx) + Math.abs(my-ry);
					System.out.println("lGap : " + lGap);
					System.out.println("rGap : " + rGap);
					if(lGap < rGap) {
						lx = mx;
						ly = my;
						answer += "L";
						//System.out.println("왼손이 더 가까울 때 : " + answer);
					}else if(rGap < lGap){
						rx = mx;
						ry = my;
						answer += "R";
						//System.out.println("오른손이 더 가까울 때 : " + answer);
					}else {
						if(hand.equals("left")) {
							//System.out.println("거리 같고 왼손잡이일 때");
							lx = mx;
							ly = my;
							answer += "L";
						}else {
							//System.out.println("거리 같고 오른손잡이일 때");
							rx = mx;
							ry = my;
							answer += "R";
						}
					}
					System.out.println("answer : " + answer);
				}
				
				if(numbers[i] == 0) {
					System.out.println("0일 때");
					mx = 3;
					my = 1;
					lGap = Math.abs(mx-lx) + Math.abs(my-ly);
					rGap = Math.abs(mx-rx) + Math.abs(my-ry);
					System.out.println("lGap : " + lGap);
					System.out.println("rGap : " + rGap);
					if(lGap < rGap) {
						lx = mx;
						ly = my;
						answer += "L";
						//System.out.println("왼손이 더 가까울 때 : " + answer);
					}else if(rGap < lGap){
						rx = mx;
						ry = my;
						answer += "R";
						//System.out.println("오른손이 더 가까울 때 : " + answer);
					}else {
						if(hand.equals("left")) {
							//System.out.println("거리 같고 왼손잡이일 때");
							lx = mx;
							ly = my;
							answer += "L";
						}else {
							//System.out.println("거리 같고 오른손잡이일 때");
							rx = mx;
							ry = my;
							answer += "R";
						}
					}
					System.out.println("answer : " + answer);
				}
        	}	
        }

        return answer;
    }
}
