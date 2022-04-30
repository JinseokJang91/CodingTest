package programmers.heap;

import java.util.PriorityQueue;

public class Heap1 {

	public static void main(String[] args) {
		
		SolutionHeap1 sol = new SolutionHeap1();
		//int[] scoville = {1, 2, 3, 9, 10, 12};
		//int[] scoville = {1, 1, 1, 1, 2, 2};
		int[] scoville = {2, 1, 4};
		//int[] scoville = {1, 1};
		int K = 7;
		int answer = sol.solution(scoville, K);
		System.out.println("answer : " + answer);
	}

}

class SolutionHeap1 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        //음식을 섞어서 스코빌 지수를 높이기
        //섞은 음식의 스코빌 지수 = 가잘 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        //모든 음식의 스코빌 지수를 K이상으로 만들기 위해 섞어야 하는 최소 횟수를 return
        
        int check = 0;
        if((scoville.length >= 2 && scoville.length <= 1000000) && (K >= 0 && K <= 1000000000)) {
        	for(int i=0; i<scoville.length; i++) {
        		if(scoville[i] >= 0 && scoville[i] <= 1000000) {
        			check = 1;
        		}else {
        			check = 0;
        			break;
        		}
        	}
        }
        
        if(check == 1) {
        	//가장 맵지 않은 음식과 두 번째로 맵지 않은 음식을 구분해야 하니
        	//scoville 배열을 오름차순 정렬하고 일단 앞에꺼 두 개만 계속 섞어보자 -> 반례가 존재할 수 있음
        	
        	/*
        	Arrays.sort(scoville);
        	List<Integer> list = new ArrayList<Integer>();

        	for(int i=0; i<scoville.length; i++) {
        		list.add(scoville[i]);
        	}*/
        	
        	//System.out.println("list : " + list);
        	
        	//ArrayList 정렬 방법
        	//1. list.sort()
        	//	오름차순 : list.sort(Comparator.naturalOrder());
        	//	내림차순 : list.sort(Comparator.reverseOrder());
        	//2. Collections.sort()
        	//	오름차순 : Collections.sort(list);
        	//  내림차순 : Collections.sort(list, Collections.reverseOrder());
        	
        	// 예를 들어 int[] scoville = {1, 1, 1, 1, 2, 2}; 이면
        	// 앞에꺼 두개만 계속 섞고 오름차순 정렬하면
        	// 1, 1, 2, 2, 3
        	// 2, 2, 3, 3
        	// 3, 3, 6
        	// 6, 9 이 돼서 결국 -1을 반환해야 한다.
        	
        	// 근데 앞에꺼 두개가 아니라(섞은 직후 좌측 - 오름차순 우측)
        	// 5, 1, 1, 1, 2 - 1, 1, 1, 2, 5	-> 1, 2를 섞음
        	// 7, 1, 1, 2 - 1, 1, 2, 7			-> 1, 5를 섞음
        	// 5, 1, 7 - 1, 5, 7				-> 1, 2를 섞음
        	// 11, 7 - 7, 11					-> 1, 5를 섞음
        	
        	// 두 번째로 맵지 않은 음식에 곱하기 2를 하기 때문에 최소한으로 횟수를 구하려면
        	// 최대한 큰 수에 2를 곱하고 제일 작은 수와 합치는게 이상적이지 않을까
        	// 원소 중에 7 미만인 수 중 제일 큰 수와 제일 작은 수를 합쳐보자
        	
        	PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        	for(Integer rate : scoville) {
        		heap.add(rate);
        		System.out.println("rate : " + rate);
        	}
        	System.out.println("최초 heap : " + heap);
        	/*
        	System.out.println("heap : " + heap);
        	System.out.println("peek : " + heap.peek());
        	System.out.println("poll : " + heap.poll());
        	System.out.println("poll : " + heap.poll());
        	System.out.println("poll : " + heap.poll());
        	System.out.println("poll : " + heap.poll());
        	System.out.println("heap : " + heap);
        	*/

        	//ArrayList로 구하려고 해보니까 효율성이 문제가 생김
        	//PriorityQueue를 사용해서 풀어야 함
        	
        	//우선 PriorityQueue객체에 배열의 각 값을 넣어주면 최소값부터 자동으로 정렬이 됨
        	//heap이라는 변수로 선언했다고 가정하면
        	//heap.poll()메소드는 최소값부터 차례대로 하나씩 꺼내는 메소드. 그 값은 heap에서 remove됨
        	//heap.peek()메소드는 루트값(최소값)을 가져오는 메소드. 그 값은 단순 조회만 해오는 것. remove안됨
        	
        	//문제에서 가장 맵지 않은 음식과 두 번째로 맵지 않은 음식을 계산해야 하기 때문에
        	//heap에서 poll() 메소드를 사용해 차례대로 두 개 값을 꺼내와 계산한 뒤에 다시 넣어주는 과정을 반복하면 된다.
        	
        	//스코빌 지수를 K이상으로 만드려면 최소 한 가지 음식이 남아야 하므로 heap.size()가 1이 되는 시점을 조건으로 설정한다.
        	
        	// ★★★★★주의할 점
        	// heap.peek()이 K이상이 되는 시점 = 모든 음식의 스코빌 지수가 K이상이 되는 시점 이기 때문에
        	// else문에서 break를 넣어서 반복문을 빠져나오도록 한다.
        	
        	// -->	break를 안 넣어도 답이 출력이 되기는 한다. (while문이 종료는 되는데 뭔가 다른 느낌이다. 정확한 이유는 모르겠다. )
        	// 		근데 이클립스에서 심각한 렉이 걸리고
        	// 		프로그래머스에서 단순 코드 실행을 돌려도 시간 초과가 뜨는걸 보니 어디선가 시간을 잡아먹는다는 건데
        	// 		아마도 heap.size()가 2라고 치면 whle문에 들어가고 heap.peek()가 K이상이면 작업을 따로 안하기 때문에
        	// 		다시 while문이 무한으로 돌아가는 거? 때문에 조건문(else문)을 써서 꼭 반복문을 빠져나오게 해야 하는 것 같다!!!
        	
        	int count = 0;
        	int min1 = 0;
        	int min2 = 0;
        	int scovilleRate = 0;
        	while(heap.size() > 1) { //!heap.isEmpty()도 쓸 수는 있음. 단 size가 1일 때를 고려해서 코드를 추가해야함
        		if(heap.peek() < K) {
        			min1 = heap.poll();
        			min2 = heap.poll();
    				scovilleRate = calRate(min1, min2);
            		heap.add(scovilleRate);
            		count++;
            		System.out.println("heap : " + heap);
        		}else {
        			break;
        		}
        	}
        	System.out.println("count : " + count);
        	if(heap.peek() < K) {
        		answer = -1;
        	}else {
        		answer = count;
        	}
        }
        
        return answer;
    }
    
    //스코빌 지수 계산하는 메소드
    public int calRate(int min1, int min2) {
    	
    	int calResult = min1 + (min2 * 2);
    	
    	return calResult;
    }
    
}