package programmers.sort;

import java.util.Arrays;

public class Sort3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SolutionSort3 sol = new SolutionSort3();
		int[] citations = {3, 0, 6, 1, 5};
		//int[] citations = {10, 3, 4, 8, 5};
		//int[] citations = {25, 8, 5, 3, 3};
		//int[] citations = {2, 1, 6, 9, 7};
		sol.solution(citations);
		
		Solution33 sol2 = new Solution33();
		sol2.solution(citations);
	}

}

class SolutionSort3 {
    public int solution(int[] citations) {
        
    	//코딩 테스트 연습 > 정렬 > H-Index
    	int answer = 0;
        
        //[H-Index는 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상], 나머지 논문이 h번 이하 인용되었을 때
    	//h의 최댓값
    	//[3, 0, 6, 1, 5] 일 때 배열의 length가 발표한 논문의 수임
    	//내림차순 배열했을 때 [6, 5, 3, 1, 0]이고 여기서 H-Index를 찾아보면
    	//6, 5, 3을 살펴보면 3번 이상 인용된 논문이 3편인 것을 알 수 있음. 따라서 h가 3이므로  H-Index는 3
    	int check = 0;
    	if(citations.length >= 1 && citations.length <= 1000) {
    		for(int i=0; i<citations.length; i++) {
    			if(citations[i] >= 0 && citations[i] <= 10000) {
    				check = 1;
    			}else {
    				check = 0;
    				break;
    			}
    		}
    	}
    	
    	if(check == 1) {
    		System.out.println("체크 확인");
    		quickSort(citations, 0, citations.length-1);

    		for(int i=0; i<citations.length; i++) {
    			System.out.print(citations[i] + " ");
    		}
    		System.out.println();
    		
    		/*
    		int index = 0;
    		System.out.println(index >= citations.length);
    		while(index < citations.length) {
    			System.out.println("확인");
    			int count = 0;
    			for(int i=0; i<citations.length; i++) {
    				if(citations[i] >= citations[index]) {
    					System.out.println("count : " + count);
    					count++;
    				}
    			}
    			
    			if(count == citations[index]) {
    				break;
    			}else {
    				index++;
    			}
    		}
    		answer = citations[index];
    		*/
    		
    		//생각해보니 내림차순을 했기 때문에 일일히 비교할 필요가 없음
    		//내림차순 했기 때문에 어떤 i의 인덱스 값의 앞의 인덱스 값들은 무조건 인용한거임
    		//따라서 h번 이상 인용된 논문이 h편 이상, 그리고 나머지 논문이 h번 이하 인용이라는 말은
    		//곧, 이상과 이하의 경계를 찾으면 된다는 뜻이다.
    		//그래서 hIndex로 인용된 논문을 카운트하고, citations[i]가 hIndex보다 작아지는 시점을 찾아서 계산하면 됨
    		int hIndex = 0;
    		for(int i=0; i<citations.length; i++) {
    			hIndex++;
    			System.out.println("citations[i] : " + citations[i]);
    			System.out.println("hIndex : " + hIndex);
    			if(citations[i] < hIndex) {
    				hIndex--;
    				break;
    			}
    		}
    		answer = hIndex;
    		System.out.println("answer : " + answer);
    	}
    	
        return answer;
    }
    
    public void quickSort(int[] data, int start, int end) {
    	
    	if(start >= end) {
    		return;
    	}
    	
    	int pivot = start;
    	int i = start + 1;
    	int j = end;
    	int temp;
    	
    	while(i <= j) {
    		while(i <= end && data[i] >= data[pivot]) {
    			i++;
    		}
    		
    		while(data[j] <= data[pivot] && j > start) {
    			j--;
    		}
    		
    		if(i > j) {
    			temp = data[j];
    			data[j] = data[pivot];
    			data[pivot] = temp;
    		}else {
    			temp = data[j];
    			data[j] = data[i];
    			data[i] = temp;
    		}
    	}
    	
    	quickSort(data, start, j-1);
    	quickSort(data, j+1, end);
    	
    }
	/* 다른 사람의 풀이
	  //sort 사용해서 오름차순 정렬하고
	  //index 역순으로 for문 돌려서 계산함
	  //Math.min(a,b)는 a,b중에 더 작은 값을 반환
	  //따라서 citations[i]와 citations.length - i 중에  더 작은 값을 반환
	  
	  //[0,1,3,5,6]으로 오름차순 정렬되었을 때
	  //6,(5-4) -> 5,(5-3) -> 3,(5-2) -> 1,(5-1) -> 0,(5-0) 이니까
	  //최소값은 1, 2, 3, 1, 0 이 나옴
	  //그럼 순서대로 max < min이면 max에 min값을 삽입하므로
	  //0 < 1 이므로 max = 1
	  //1 < 2 이므로 max = 2
	  //2 < 3 이므로 max = 3
	  //3 < 2 는 false 이므로 여기서 더이상 max값이 변하지 않음. 따라서 max는 3
	  //원리는 내가 한 거랑 비슷한데 좀 더 간단하게 표현한 듯 하다.
	  
	  Arrays.sort(citations);
	
	  int max = 0;
	  for(int i = citations.length-1; i > -1; i--){
	      int min = (int)Math.min(citations[i], citations.length - i);
	      if(max < min) max = min;
	  }
	
	  return max;
	*/
}

class Solution33 {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            System.out.println("변화 확인 : " + (int)Math.min(citations[i], citations.length - i));
            if(max < min) max = min;
        }
        
        System.out.println("max : " + max);
        return max;
    }
}
