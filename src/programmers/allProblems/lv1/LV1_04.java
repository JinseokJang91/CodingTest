package programmers.allProblems.lv1;

public class LV1_04 {

	public static void main(String[] args) {

		Solution4 sol = new Solution4();
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		int answer = sol.solution(a, b);
		System.out.println("answer : " + answer);

	}

}

class Solution4 {
    public int solution(int[] a, int[] b) {
    	
    	//월간 코드 챌린지 시즌1 > 내적
        int answer = 1234567890;
        
        int check = 0;
        if((a.length>=1 && a.length<=1000) && (b.length>=1 && b.length<=1000)){
            for(int i=0; i<a.length; i++){
                //a,b의 length는 같음
                if((a[i] >= (-1000) && a[i] <= 1000) && (b[i] >= (-1000) && b[i] <= 1000)){
                    check = 1;
                }else{
                    check = 0;
                    break;
                }
            }
        }
        //System.out.println("check : " + check);
        if(check == 1){
            
            int sum = 0;
            for(int i=0; i<a.length; i++){
                sum += ((a[i])*(b[i]));
            }
            answer = sum;
        }
        
        return answer;
    }
}
