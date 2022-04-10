package baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ques_1697 {

	//문제 : https://www.acmicpc.net/workbook/view/9379
	//풀이 : https://smartpro.tistory.com/18
	static int N;
	static int K;
	static int[] visited = new int[100001];
	
	
	public static void main(String[] args) {
		
		//제한 조건
		//1. 0 <= N <= 100,000
		//2. 0 <= K <= 100,000
		//X-1 또는 X+1 또는 2*X

		
		//Scanner 대신 아래와 같이 사용 가능
		/* 
		BufferedReader br = new BufferedReader(New InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] inputs = input.split(" ");
		
		N = Integer.valueOf(inputs[0]);
		K = Integer.valueOf(inputs[1]);
		*/
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		sc.nextLine();

		
		int result = bfs(N);
		System.out.println(result);
		sc.close();
	}
	
	private static int bfs(int node) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//node : 수빈의 처음 위치
		queue.add(node);
		int index = node;
		int n = 0;
		visited[index] = 1;
		
		while(queue.isEmpty() == false){ //!queue.isEmpty() 로도 표시 가능
			
			n = queue.poll();	//queue.remove()로도 사용 가능함.
								//remove()와 poll()의 차이점은 remove()는 Queue가 Empty일 때 Exception을 반환, poll()은 null을 반환함
			
			if(n == K) {
				return visited[n]-1;
			}
			
			if(n-1 >= 0 && visited[n-1] == 0) {
				visited[n-1] = visited[n] + 1;
				queue.add(n-1);
			}
			
			if(n+1 <= 100000 && visited[n+1] == 0) {
				visited[n+1] = visited[n] + 1;
				queue.add(n+1);
			}
			
			if(2*n <= 100000 && visited[2*n] == 0) {
				visited[2*n] = visited[n] + 1;
				queue.add(2*n);
			}
			
		}
		
		return -1;
		
	}

}
