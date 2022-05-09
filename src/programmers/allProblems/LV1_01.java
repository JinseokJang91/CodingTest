package programmers.allProblems;

public class LV1_01 {

	public static void main(String[] args) {
		
		Solution1 sol = new Solution1();
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		
		int[] answer = sol.solution(lottos, win_nums);
		
		for(int i=0; i<answer.length; i++){
            System.out.print(answer[i] + " ");
        }
	}

}

class Solution1 {
    public int[] solution(int[] lottos, int[] win_nums) {
    	
    	//2021 Dev-Matching: 웹 백엔드 개발 > 로또의 최고 순위와 최저 순위
        int[] answer = {};
        
        int check = 0;
        if(lottos.length == 6 && win_nums.length == 6){
            for(int i=0; i<lottos.length; i++){
                if(lottos[i] >= 0 && lottos[i] <= 45){
                    check = 1;
                }else{
                    check = 0;
                    //System.out.println("lotto break : " + i);
                    break;
                }
                //중복체크
                for(int j=i+1; j<lottos.length; j++){
                    if(lottos[i] != 0 && (lottos[i] == lottos[j])){
                        //System.out.println("lotto j break : " + i + " , " + j);
                        check = 0;
                        break;
                    }
                }
            }
            for(int i=0; i<win_nums.length; i++){
                if(win_nums[i] >= 1 && win_nums[i] <= 45){
                    check = 1;
                }else{
                    check = 0;
                    //System.out.println("win_num break : " + i);
                    break;
                }
                //중복체크
                for(int j=i+1; j<win_nums.length; j++){
                    if(win_nums[i] != 0 && (win_nums[i] == win_nums[j])){
                        //System.out.println("win_num j break : " + i + " , " + j);
                        check = 0;
                        break;
                    }
                }
            }
        }
        //System.out.println("check : " + check);
        if(check == 1){
            int maxRank = 0;
            int minRank = 0;
            
            for(int i=0; i<lottos.length; i++){
                if(lottos[i] == 0){
                    maxRank++;
                }
                for(int j=0; j<win_nums.length; j++){
                    if(lottos[i] != 0 && (lottos[i] == win_nums[j])){
                        maxRank++;
                        minRank++;
                    }
                }
            }
            
            //System.out.println("maxRank : " + maxRank);
            //System.out.println("minRank : " + minRank);
            
            //순위는 6위(그 외)를 제외하고 (6-맞춘개수+1)이 등수
            //0개 맞추는 경우 6 - 0 + 1이 되므로 6이하라는 조건으로 구분
            answer = new int[2];
            
            if((6 - maxRank + 1) <= 6){
                answer[0] = 6 - maxRank + 1;
            }else{
                answer[0] = 6 - maxRank;
            }
            
            if((6 - minRank + 1) <= 6){
                answer[1] = 6 - minRank + 1;
            }else{
                answer[1] = 6 - minRank;
            }
            /*
            for(int i=0; i<answer.length; i++){
                System.out.print(answer[i] + " ");
            }*/
        }
    
        return answer;
    }
}
