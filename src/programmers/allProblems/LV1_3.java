package programmers.allProblems;

public class LV1_3 {

	public static void main(String[] args) {
		
		Solution3 sol = new Solution3();
		int[] numbers = {1,2,3,4,6,7,8,0};
		int answer = sol.solution(numbers);
		
		System.out.println("answer : " + answer);

	}

}

class Solution3 {
    public int solution(int[] numbers) {
    	
    	//���� �ڵ� ç���� ����3 > ���� ���� ���ϱ�
        int answer = -1;
        
        int check = 0;
        if(numbers.length>=1 && numbers.length<=9){
            for(int i=0; i<numbers.length; i++){
                if(numbers[i]>=0 && numbers[i]<=9){
                    check = 1;
                }else{
                    check = 0;
                    break;
                }
            }
        }
        
        if(check == 1){
            //0~9���� ��� ���� ���� 45
            int sum = 0;
            for(int i=0; i<numbers.length; i++){
                sum += numbers[i];
            }
            
            answer = 45 - sum;
        }
        
        /* ��ų üũ �׽�Ʈ���� Ǭ ����
        Arrays.sort(numbers);
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<numbers.length; i++){
            //System.out.print(numbers[i] + " ");
            list.add(numbers[i]);
        }

        answer = 0;
        for(int i=0; i<10; i++){
            if(!list.contains(i)){
                answer += i;
            }
        }        
        */
        return answer;
    }
}
