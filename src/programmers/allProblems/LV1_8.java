package programmers.allProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class LV1_8 {

	public static void main(String[] args) {
		SolutionLV1_8 sol = new SolutionLV1_8();
		//int[] nums = {3,1,2,3};
		//int[] nums = {3,3,3,2,2,2};
		int[] nums = {3,3,3,2,2,4};
		int answer = sol.solution(nums);
		System.out.println("answer : " + answer);

	}

}

class SolutionLV1_8 {
    public int solution(int[] nums) {
        
    	//코딩테스트 연습 > 찾아라 프로그래밍 마에스터 > 폰켓몬
    	int answer = 0;
        
        int check = 0;
        if(nums.length >= 1 && nums.length <= 10000 && nums.length%2 == 0) {
        	for(int i=0; i<nums.length; i++) {
        		if(nums[i] >= 1 && nums[i] <= 200000) {
        			check = 1;
        		}else {
        			check = 0;
        			break;
        		}
        	}
        }
        
        if(check == 1) {
        	// N마리의 폰켓몬 중에서 N/2마리 까지 가져갈 수 있다.
        	// 최대한 다양한 종류의 폰켓몬을 고르려 한다.
        	// N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 성택하는 방법을 찾아, 그때의 폰켓몬 종류 번호의 개수를 return
        	
        	int N = nums.length / 2;
        	
        	//1. HashMap을 사용해서 배열에 있는 폰켓몬 번호와 각 번호의 개수를 넣어보자
        	// 처음에는 HashMap을 써서 중복되는 수만큼 value값에 추가해서 하나씩 빼보려고 했는데
        	// 생각해보니 그럴 필요가 없었다. 종류 수만 어떻게든 구하면 해결 되는 문제임
        	// 참고로 while문에서 iter.next()를 안 쓰고 돌리면 while문이 4번 돌아갔다. 왜 그런지는 정확히 모르겠음
        	// 아마도 hasNext가 true일 때 보통 그 next()값을 가져올 수 있으니까 iter.next()를 쓰면 그 값을 가져오는 것 같음
        	// 무슨 말이냐면 while문에서 한 번 돌 때 그 안에서 iter.next()를 두 번 쓰면 값을 동일한 값을 두 개 가져오는게 아니라 그 다음 값을 가져옴
        	// 그래서 iter.next()는 웬만하면 hasNext()에 맞게 한 번만 사용해야 하고 한 번은 사용해야 하는 것 같다.
        	HashMap<Integer, Integer> pocketmon = new HashMap<Integer, Integer>();
        	for(int i=0; i<nums.length; i++) {
        		if(!pocketmon.containsKey(nums[i])) {
        			pocketmon.put(nums[i], 1);
        		}else {
        			pocketmon.put(nums[i], pocketmon.get(nums[i]) + 1);
        		}
        	}
        	System.out.println("pocketmon : " + pocketmon);
        	
        	Iterator<Entry<Integer, Integer>> iter = pocketmon.entrySet().iterator();
        	
        	int count = 0;
        	
        	while(iter.hasNext()) {
        		System.out.println("while문");
        		
        		//아래 if문 주석처리 하고 iter.next()를 두 번씩 쓰면 NoSuchElementException 발생함
        		//System.out.println(iter.next());
        		//System.out.println(iter.next());
        		
        		if(iter.next() != null) {
        			if(count < N) {
            			count++;
            		}else {
            			break;
            		}
        		}
        	}
        	System.out.println("count : " + count);
        	answer = count;
        	
        	//2. List에 폰켓몬 종류 수만 넣는다(중복 제거)
        	//(1)->	종류 수가 N보다 작으면 최대 종류수는 list의 크기가 됨.
        	//		그리고 남는 N은 같은 종류 폰켓몬 있는 것 중에 아무거나 넣으면 됨
        	//(2)->	종류 수가 N보다 크거나 같으면 최대 종류수는 N이 됨.
        	//		종류 수가 N보다 많으면 어차피 최대 고를 수 있는 수가 N이기 때문에 서로 다른 어떤 종류를 고른다고 하더라도 N이 넘을 수 없음
        	List<Integer> list = new ArrayList<Integer>();
        	for(int i=0; i<nums.length; i++) {
        		if(!list.contains(nums[i])) {
        			list.add(nums[i]);
        		}
        	}
        	System.out.println("list : " + list);
        	
        	if(list.size() < N) {
        		answer = list.size();
        	}else {
        		answer = N;
        	}
        	
        	//3. 배열만 가지고 구하기 -> 이게 좀 더 성능이 좋았음(프로그래머스로 돌렸을 때)
        	int cnt = 1; //최소 한 가지 종류의 폰켓몬으로 이루어져 있으므로
        	Arrays.sort(nums);
        	for(int i=0; i<nums.length; i++) {
        		if(i+1 < nums.length) {
        			if(nums[i] != nums[i+1]) {
        				System.out.println(nums[i] + "와 " + nums[i+1]);
        				cnt++;
        			}
        		}
        	}
        	System.out.println("cnt : " + cnt);
        	
        	if(cnt < N) {
        		answer = cnt;
        	}else {
        		answer = N;
        	}
        	
        	//4. Set 이용해보기 -> 이게 제일 성능이 좋음
        	Set<Integer> set = new HashSet<Integer>();
        	for(int i=0; i<nums.length; i++) {
        		set.add(nums[i]);
        	}
        	System.out.println("set : " + set);
        	int setSize = set.size();
        	if(setSize < N) {
        		answer = setSize;
        	}else {
        		answer = N;
        	}
        	
        }
        
        return answer;
    }
}