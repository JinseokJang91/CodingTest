package programmers.allProblems;

public class LV1_13 {

	public static void main(String[] args) {
		SolutionLV1_13 sol = new SolutionLV1_13();
		//int left = 13;
		//int right = 17;
		int left = 24;
		int right = 27;
		int answer = sol.solution(left, right);
		System.out.println("answer : " + answer);

	}

}

class SolutionLV1_13 {
    public int solution(int left, int right) {
    	
    	// ¿ù°£ ÄÚµå Ã§¸°Áö ½ÃÁð2 > ¾à¼öÀÇ °³¼ö¿Í µ¡¼À
        int answer = 0;
        
        if(left >= 1 && left <= right && right <= 1000) {
        	int aliquotCnt = 0;
        	int result = 0;
        	for(int i=left; i<=right; i++) {
        		aliquotCnt = findAliquot(i);
        		System.out.println("aliquotCnt : " + aliquotCnt);
        		if(aliquotCnt % 2 == 0) {
        			result += i;
        		}else {
        			result -= i;
        		}
        	}
        	answer = result;
        }
        
        
        return answer;
    }
    
    public int findAliquot(int num) {
    	int count = 0;
    	for(int i=1; i<=num; i++) {
    		if(num % i == 0) {
    			count++;
    		}
    	}
    	
    	return count;
    }
}