package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Hash3 {

	public static void main(String[] args) {
		
		//String[][] clothes = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}};
		//String[][] clothes = {{"crow_mask","face"},{"blue_sunglasses","face"},{"smoky_makeup","face"}};
		String[][] clothes = {{"a","face"},{"aa","face"},{"b","upper"}, {"c","bottom"}};
		
		//제한조건
		//1. 의상의 수 = clothes.length는 1이상 30 이하
		//2. 같은 이름을 가진 의상은 존재하지 않음
		//3. clothes의 모든 원소는 문자열로 이루어짐
		//4. 모든 문자열의 길이는 1 이상 20 이하의 자연수, 알파벳 소문자 또는 '_'
		//5. 하루에 최소 한 개의 의상을 입음

		SolutionHash3 sol = new SolutionHash3();
		
		int answer = sol.solution(clothes);

	}

}

class SolutionHash3 {
    public int solution(String[][] clothes) {
        
    	//해시 > 위장
    	int answer = 0;
        
    	int check = 0;
    	if(clothes.length >= 1 && clothes.length <= 30) {
    		for(int i=0; i<clothes.length; i++) {
    			if((clothes[i][0].length() >= 1 && clothes[i][0].length() <= 20)
    				&&(clothes[i][1].length() >= 1 && clothes[i][1].length() <= 20)) {
    				for(int j=0; j<clothes[i][0].length(); j++) {
    					if((clothes[i][0].charAt(j) < 97 || clothes[i][0].charAt(j) > 122) && (clothes[i][0].charAt(j) != '_')) {
    						System.out.println("체크 확인1");
    						check = 1;
    					}
    				}
    				for(int j=0; j<clothes[i][1].length(); j++) {
    					if((clothes[i][1].charAt(j) < 97 || clothes[i][1].charAt(j) > 122) && (clothes[i][1].charAt(j) != '_')) {
    						System.out.println("체크 확인2");
    						check = 1;
    					}
    				}
    			}
    		}
    	}
    	System.out.println("check : " + check);
    	if(check == 0) {
    		// clothes는 의상의 이름, 의상의 종류로 이루어져 있으므로 HashMap을 사용한다면
        	// key값에 의상의 종류, value값에 의상의 이름을 넣어서 해결하는 것이 좋아보임
        	// 기본적으로 clothes의 길이만큼 경우의 수는 깔고 시작함
        	// clothes = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}} 의 경우 5가지
        	// 기본적으로 3가지의 경우의 수를 깔고 들어가며
        	// 그렇기때문에 추가적인 경우의 수는 무조건 1보다 큼
        	// clothes = {{"crow_mask","face"},{"blue_sunglasses","face"},{"smoky_makeup","face"}} 의 경우 3가지
        	// 모두 종류가 같기 때문에 기본적인 경우의 수인 3가지만 남아야 함
        	// 그러려면 기본 경우의 수를 구한 다음, HashMap에 차례대로 put할 때 Map의 size가 +1 될 때만 체크하면 됨
        	
        	// 정리하면,
        	// 1. clothes의 길이 = 기본 경우의 수를 구한다.
        	// 2. 추가적인 경우의 수는 map의 크기가 무조건 1보다 클 때이다.
        	// 3. HashMap에 순서대로 put하며 (1) map의 크기가 +1 되거나 (2) value값이 바뀌면 경우의 수를 +1 한다.
    		// 4. 정리하면
    				//(1) map의 크기가 +1 된다 -> containsKey(key)가 false이다. -> 경우의 수 증가
    				//(2) value값이 바뀐다 -> containsKey(key)가 true이고 containsValue(value)가 false다. -> 경우의 수 증가
    		
    		// 반례,
    		// clothes = {{"a","face"},{"aa","face"},{"b","upper"}, {"c","bottom"}} 의 경우
    		// 총 11가지의 경우의 수가 나온다.
    		// 위에 예시와 비교해서 생각해보면 (x -> 안입는 경우)
    		// (1) clothes = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}}
    		// headgear -> x , yellow_hat , green_turban 3가지 경우의 수
    		// eyewear -> x , blue_sunglasses 2가지 경우의 수
    		// (2) clothes = {{"crow_mask","face"},{"blue_sunglasses","face"},{"smoky_makeup","face"}}
    		// face -> x, crow_mask, blue_sunglasses, smoky_makeup -> 4가지 경우의 수
    		// (3) clothes = {{"a","face"},{"aa","face"},{"b","upper"}, {"c","bottom"}}
    		// face -> x, a, aa
    		// upper -> x, b
    		// bottom -> x, c
    		
    		// 정리해보면 문제에서 최소 한 개의 의상은 입는다고 했으니 조합의 수는 각 경우의 수를 곱한 것에서 -1을 해준 것이다.
    		// (1) (3 * 2) - 1 = 5
    		// (2) 4 - 1 = 3
    		// (3) (3 * 2 * 2) - 1 = 11
    		
    		// 이것을 HashMap으로 각 key값의 경우의 수를 계산해서 곱하면 될 듯하다.
    		// 정리하면, HashMap을 두 개를 선언해서 하나는 경우의 수(int)를 담아준다.
    		// 1. HashMap에 put을 할 때 containsKey를 이용해서 새로운 종류면 다른 HashMap에 기본 경우의 수 2가지 추가(입는, 안입는)
    		// 2. containsValue를 이용해서 새로운 이름이면 해당 key값을 이용해서 value값에 +1을 해준다.
            // 3. HashMap value값들을 모두 곱해주고 마지막에 -1을 해준다.
    		
    		HashMap<String, String> map = new HashMap<String, String>();
    		HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
    		for(int i=0; i<clothes.length; i++) {
    			// key가 존재하지 않는 경우 - 새로운 종류
    			if((!map.containsKey(clothes[i][1]))) {
    				map.put(clothes[i][1], clothes[i][0]);
    				resultMap.put(clothes[i][1], 2); // 새로운 key가 추가될 때 기본적으로 안입는 경우, 입는 경우 두 가지 경우의 수가 존재
    				
    			}
    			// key가 존재하고 value값이 다른 경우 - 새로운 이름
    			if(map.containsKey(clothes[i][1]) && !map.containsValue(clothes[i][0])) {
    				map.put(clothes[i][1], clothes[i][0]);
    				resultMap.put(clothes[i][1], resultMap.get(clothes[i][1]) + 1);
    			}
    		}
    		
    		//HashMap 출력 방법(key, value값 구하기)
    		//1. Entry 객체 사용
    		int result = 1; // 총 경우의 수
    		for(Entry<String, Integer> entry : resultMap.entrySet()) {
    			result *= entry.getValue();
    		}
    		
    		//2. Iterator 객체 사용
    		int result2 = 1;
    		//int result3 = 1;
    		Iterator<Entry<String, Integer>> iter = resultMap.entrySet().iterator();
    		while(iter.hasNext()) {
    			result2 *= iter.next().getValue();
    			//또는 아래와 같이 사용
    			//Map.Entry<String, Integer> ent = iter.next();
    			//result3 *= ent.getValue();
    		}
    		
    		System.out.println("map : " + map);
    		System.out.println("resultMap : " + resultMap);
    		System.out.println("result : " + result);
    		System.out.println("result2 : " + result2);
    		//System.out.println("result3 : " + result3);
    		
    		answer = result - 1; // 아무것도 안입는 경우 한 가지를 제외시켜야 함
    		System.out.println("정답 : " + answer);
    	}
    	
        
    	
        
        return answer;
    }
}