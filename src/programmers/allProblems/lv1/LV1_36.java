package programmers.allProblems.lv1;

public class LV1_36 {

	public static void main(String[] args) {
		SolutionLV1_36 sol = new SolutionLV1_36();
		String s = "+1234";
		int answer = sol.solution(s);
		System.out.println("answer : " + answer);
	}

}

class SolutionLV1_36 {
    public int solution(String s) {
        
    	//�������� > ���ڿ��� ������ �ٲٱ�
    	int answer = 0;
        
    	//�տ� ��ȣ(+,-)�� �پ substring�̳� indexOf�� String �޼ҵ�� ó������� �Ѵٰ� ������ �� ������
    	//+,- ��ȣ�� �پ��־ �ٷ� parse�� �Ǵ� ���� Ȯ���� �� �ִ� ����
    	answer = Integer.parseInt(s);
        
        return answer;
    }
}