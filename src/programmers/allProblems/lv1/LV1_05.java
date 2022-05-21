package programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.List;

public class LV1_05 {

	public static void main(String[] args) {
		
		Solution5 sol = new Solution5();
		
		//int[] nums = {1,2,3,4};
		int[] nums = {1,2,7,6,4,8,9};
		int answer = sol.solution(nums);
		System.out.println("answer : " + answer);
	}

}

class Solution5 {
    public int solution(int[] nums) {
    	
    	//Summer/Winter COding(~2018) > 소수 만들기
        int answer = -1;
        
        int check = 0;
        if(nums.length >= 3 && nums.length <= 50) {
        	for(int n=0; n<nums.length; n++) {
        		if(nums[n] >= 1 && nums[n] <= 1000) {
        			check = 1;
        		}else {
        			check = 0;
        			break;
        		}
        	}
        }
        
        if(check == 1) {
            int i=0;
        	int j=i+1;
        	int k=j+1;
        	int sum = 0;
        	
        	List<Integer> list = new ArrayList<Integer>();
        	List<Integer> result = new ArrayList<Integer>();
        	
            while(true) {
            	
            	System.out.println("i : " + i + ", j : " + j + ", k : " + k);
            	if(k < nums.length) {
            		//System.out.println("###1 i : " + i + ", j : " + j + ", k : " + k);
            		sum = nums[i]+nums[j]+nums[k];
            		k++;
            		//System.out.println("k값 변화 : " + k);
            	}
            	
            	if(k == nums.length) {
            		j++;
        			k=j+1;
        			//System.out.println("###2 : " + i + ", j : " + j + ", k : " + k);
        			//if(k < nums.length && j < nums.length-1)
        			//sum = nums[i]+nums[j]+nums[k];
        		}
            	
            	if(j == nums.length-1) {
    				i++;
    				j=i+1;
    				k=j+1;
    				//System.out.println("###3 : " + i + ", j : " + j + ", k : " + k);
    				//if(i < nums.length-2 && k < nums.length && j < nums.length-1)
    				//sum = nums[i]+nums[j]+nums[k];
    			}
            	
            	System.out.println("sum : " + sum);
            	
            	if(!list.isEmpty()) {
            		int dupCheck = 0;
            		for(int index=0; index<list.size(); index++) {
            			if(list.get(index) == sum) {
            				dupCheck = 1;
            				break;
            			}
            		}
            		if(dupCheck != 1) {
            			list.add(sum);
            		}
            	}else {
            		list.add(sum);
            	}
            	
            	if(i == nums.length-2) {
            		break;
            	}
            }
            
            System.out.println("list : " + list);
            
            //소수 : 약수가 1과 자신밖에 없는 수. 2, 3, 5, 7, 11, 13, ...
            for(int x=0; x<list.size(); x++) {
            	int count = 0;
            	for(int y=1; y<=list.get(x); y++) {
            		int aliquot = list.get(x)%y;

            		if(aliquot == 0) {
            			System.out.println(list.get(x) + "의 약수 : " + y);
            			count++;
            		}
            	}
            	if(count == 2) {
    				System.out.println("###소수 : " + list.get(x));
    				result.add(list.get(x));
    			}
            }
            
            System.out.println("result : " + result);
            
            answer = result.size();
        }

        return answer;
    }
}