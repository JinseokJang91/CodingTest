package baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class No_10818 {

	public static void main(String[] args) throws Exception{
		//10818번 최소,최대
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		String[] arr = input.split(" ");
		
		if(arr.length == N) {
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<arr.length; i++) {
				list.add(Integer.parseInt(arr[i]));
			}
			
			/*
			Collections.sort(list, Comparator.naturalOrder());
			//System.out.println("list : " + list);
			System.out.print(list.get(0) + " ");
			Collections.sort(list, Comparator.reverseOrder());
			//System.out.println("list : " + list);
			System.out.println(list.get(0));
			
			
			//Stack, Queue 사용해서 다시 풀어보자!
			//Stack<Integer> st = new Stack<Integer>();
			Queue<Integer> que = new PriorityQueue<Integer>();
			Queue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
			
			for(int i=0; i<list.size(); i++) {
				//list가 아니라 배열에서 바로 add해도 될 것 같긴 함
				que.add(list.get(i));
				que2.add(list.get(i));
			}
			System.out.print(que.peek() + " ");
			System.out.print(que2.peek());
			*/
			
			//Math.min(), Math.max() 사용?
			int minTmp = 0;
			int maxTmp = 0;
			int min = list.get(0);
			int max = list.get(0);
			for(int i=0; i<list.size(); i++) {
				if(i+1 < list.size()) {
					minTmp = Math.min(list.get(i), list.get(i+1));
					maxTmp = Math.max(list.get(i), list.get(i+1));
					
					if(minTmp < min) {
						min = minTmp;
					}
					if(maxTmp > max) {
						max = maxTmp;
					}
				}
			}
			System.out.print(min + " " + max);
			
			//결과 : Math 사용하는게 성능이 제일 좋았음
			
			//성능 순서
			//속도 : Math(568ms) > Queue(708ms) > Collections(1520ms)
			//메모리 : Math(135516KB) > Collections(149776KB) > Queue(162116KB)
			
			br.close();
		}
	}
}
