package programmers.allProblems.lv1;

public class LV1_39 {

	public static void main(String[] args) {
		SolutionLV1_39 sol = new SolutionLV1_39();
		long n = 12345;
		int[] answer = sol.solution(n);
		for(int i=0; i<answer.length; i++) {
			System.out.printf("%d ", answer[i]);
		}System.out.println();
		
	}
}

class SolutionLV1_39 {
    public int[] solution(long n) {
        //�������� > �ڿ��� ������ �迭�� �����
    	int[] answer = {};
    	
    	//n�� 12345�̸� [5,4,3,2,1]�� ����
    	String s = String.valueOf(n);
    	answer = new int[s.length()];
    	int index = 0;
    	for(int i=s.length()-1; i>=0; i--) {
    		int x = Integer.parseInt(String.valueOf(s.charAt(i)));
    		answer[index++] = x;
    	}
    	
        return answer;
    }
}