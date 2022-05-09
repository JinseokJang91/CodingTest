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
    	
    	//2021 Dev-Matching: �� �鿣�� ���� > �ζ��� �ְ� ������ ���� ����
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
                //�ߺ�üũ
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
                //�ߺ�üũ
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
            
            //������ 6��(�� ��)�� �����ϰ� (6-���ᰳ��+1)�� ���
            //0�� ���ߴ� ��� 6 - 0 + 1�� �ǹǷ� 6���϶�� �������� ����
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
