package programmers.allProblems.lv1;

public class LV1_24 {

	public static void main(String[] args) {
		SolutionLV1_24 sol = new SolutionLV1_24();
		int[][] arr1 = {{1, 2}, {2, 3}};
		int[][] arr2 = {{3, 4}, {5, 6}};
		int[][] answer = sol.solution(arr1, arr2);
		for(int i=0; i<answer.length; i++) {
			for(int j=0; j<answer[i].length; j++) {
				System.out.printf("%d ", answer[i][j]);
			}
			System.out.println();
		}
		
	}

}

class SolutionLV1_24 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
    	
    	//¿¬½À¹®Á¦ > Çà·ÄÀÇ µ¡¼À
        int[][] answer = {};
        
        answer = new int[arr1.length][arr1[0].length];
        for(int i=0; i<arr1.length; i++) {
        	for(int j=0; j<arr1[i].length; j++) {
        		answer[i][j] = arr1[i][j] + arr2[i][j];
        	}
        }
        
        return answer;
    }
}