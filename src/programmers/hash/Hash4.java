package programmers.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class Hash4 {

	public static void main(String[] args) {
		SolutionHash4 sol = new SolutionHash4();
		String[] genres = {"classic", "pop", "classic", "classic", "classic", "classic", "pop"};
		int[] plays = {500, 800, 800, 600, 150, 800, 2500};
		int[] answer = sol.solution(genres, plays);
		

	}

}

class SolutionHash4 {
    public int[] solution(String[] genres, int[] plays) {
        
    	// 해시 > 베스트앨범
    	int[] answer = {};
        
    	// 장르 별로 가장 많이 재생된 노래를 두 곡씩 모아 베스트 앨범을 추시한다.
    	// 장르 별로 두 곡씩 모으되 만약 장르에 속한 곡이 하나뿐이면 하나만 선택
    	
        // answer 배열에 노래를 수록하는 기준
    	// 1. 속한 노래가 많이 재생된 장르를 먼저 수록 -> 동일 장르(genres)의 재생 횟수(plays)를 합친 값이 가장 높은 것
        // 2. 장르 내에서 많이 재생된 노래를 먼저 수록 -> 예를 들어 classic이 2개 있고, play 횟수가 각각 500, 1000 이면 1000부터 수록
    	// 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록 -> 예를 들어 classic이 2개, play횟수가 각각 300, 300이면, genres에서 인덱스가 더 낮은 것부터 수록
    	
    	int check = 0;
    	if((genres.length >= 1 && genres.length <= 10000) 
    		&& (plays.length >= 1 && plays.length <= 10000)
    		&& (genres.length == plays.length)) {
    		check = 1;
    	}
    	
    	if(check == 1) {
    		//해시맵에 각 장르마다 재생된 횟수를 더해서 key-value로 넣으면 어떤 장르가 제일 많이 재생되었는지 알 수 있음
    		//각 장르마다 재생횟수가 높은 순서대로 인덱스를 두 개를 알아야 함(재생횟수가 같은 경우에는 인덱스를 비교해야 함)
    		//해시맵 value값에 재생 횟수가 높은 순서대로 인덱스를 넣거나 아니면 재생 횟수 자체를 넣어야 하는데 인덱스를 넣는게 좀 더 나아보임
    		
    		// 1. 우선 totalMap에 각 장르 별로 재생 횟수를 모두 더한 값을 넣는다.
    		HashMap<String, Integer> totalMap = new HashMap<String, Integer>();
    		for(int i=0; i<genres.length; i++) {
    			if(!totalMap.containsKey(genres[i])) {
    				totalMap.put(genres[i], plays[i]);
    			}else {
    				totalMap.put(genres[i], totalMap.get(genres[i]) + plays[i]);
    			}
    		}
    		System.out.println("totalMap : " + totalMap);
    		
    		// 2. indexMap에는 각 장르 별 인덱스 값을 콤마(,)를 사용해 구분해서 넣는다.
    		HashMap<String, String> indexMap = new HashMap<String, String>();
    		for(int i=0; i<genres.length; i++) {
    			if(!indexMap.containsKey(genres[i])) {
    				indexMap.put(genres[i], ""+i);
    			}else {
    				//System.out.println("Integer.valueOf(indexMap.get(genres[i])) : " + Integer.valueOf(indexMap.get(genres[i])));
    				indexMap.put(genres[i], indexMap.get(genres[i])+ "," + i);
    			}
    		}
    		System.out.println("indexMap : " + indexMap);
    		
    		// 3. 콤마로 구분한 인덱스 값을 이용해 plays에서 재생횟수가 높은 순서대로 구하되, 같은 경우는 인덱스가 더 작은 값을 구한다.
    		Iterator<Entry<String, String>> iter = indexMap.entrySet().iterator();
    		while(iter.hasNext()) {
    			
    			String[] indexTemp = iter.next().getValue().split(",");
    			for(int i=0; i<indexTemp.length; i++) {
    				System.out.print(indexTemp[i] + " - ");
    				System.out.print(plays[Integer.valueOf(indexTemp[i])] + " ");
    			}
    			System.out.println();
    			List<Integer> list = new ArrayList<Integer>();
    			//System.out.println("Math.max : "  + Math.max(2, 2));
    			int maxPlay = 0;
    			int maxIndex = 0;
    			for(int i=0; i<indexTemp.length; i++) {
    				if(maxPlay < plays[Integer.valueOf(indexTemp[i])]) {
    					maxPlay = plays[Integer.valueOf(indexTemp[i])];
    					maxIndex = Integer.valueOf(indexTemp[i]);
    				}
    				
    				if(maxPlay == plays[Integer.valueOf(indexTemp[i])]) {
    					if(maxIndex > Integer.valueOf(indexTemp[i])) {
    						maxIndex = Integer.valueOf(indexTemp[i]);
    					}
    				}
    			}
    			System.out.println("maxPlay : " + maxPlay);
    			System.out.println("maxIndex : " + maxIndex);
    			
    			
    			/*
    			List<Integer> list = new ArrayList<Integer>();
    			String s = iter.next().getKey();
    			for(int i=0; i<genres.length; i++) {
    				if(s.equals(genres[i])) {
    					
    					list.add(plays[i]);
    				}
    			}
    			*/
    			
    			/*
    			Collections.sort(list, Comparator.reverseOrder());
    			System.out.println("list : " + list);
    			if(list.size() > 1) {
    				// 두 번째 while문에서 list가 만약 [800, 800, 500, 400]으로 정렬됐다고 하고 각각 인덱스가 1,4,3,2라고 가정하면
    				// 1,4를 선택해야함
    				// 만약 [800, 800, 800, 800, 400]이고 인덱스는 3,1,2,0,4라고 하면
    				// 0,1를 선택해야함
    				// 만약 [800, 500, 500, 500, 400]이고 인덱스는 1,3,2,0,5라고 하면
    				// 0,1를 선택해야함
    				int a = list.get(0);
    				int b = list.get(1);
    				int index1 = 0;
    				int index2 = 0;
    				int compare = 0;
    				for(int i=0; i<plays.length; i++) {
    					//a가 b보다 큰 경우 -> [800, 500, 500, 400]
    					//b가 동일 값이 있는지 확인하고, 있다면 인덱스를 비교해야함
    					if(a != b) {
    						for(int j=2; j<list.size(); j++) {
    							//0,1 뒤 값이 재생 횟수가 같다면 인덱스를 비교
    							if(list.get(j) == b) {
    								
    							}
    						}
    					}else {
    						
    					}
    					
    					
    					
    					
    					if(b == plays[i]) {
    						//a, b가 같은 재생 횟수(index1에 들어간 i값이 b 조건에 일치하는 i일 때)일 경우 b는 그 다음 인덱스 선택
    						if(index1 != i) {
    							//b 재생 횟수와 같은 인덱스가 한 개가 아닐 경우 작은 인덱스 값 선택
    							compare = i;
    							if()
    						}
    					}
    					
    				}
    			}
    			*/
    		}
    		
    	}
    	
    	
        return answer;
    }
}