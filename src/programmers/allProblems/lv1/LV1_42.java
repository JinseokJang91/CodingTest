package programmers.allProblems.lv1;

import java.util.ArrayList;
import java.util.List;

public class LV1_42 {

	public static void main(String[] args) {
		SolutionLV1_42 sol = new SolutionLV1_42();
		String s ="  TRY   HELLO  WORLD ";
		String answer = sol.solution(s);
	}
	
}

class SolutionLV1_42 {
    public String solution(String s) {
        String answer = "";
        
        int frontBlank = 0;
        int backBlank = 0;
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i) == ' ') {
        		frontBlank++;
        	}else {
        		break;
        	}
        }
        
        for(int i=s.length()-1; i>=0; i--) {
        	if(s.charAt(i) == ' ') {
        		backBlank++;
        	}else {
        		break;
        	}
        }
        System.out.println("frontBlank : " + frontBlank);
        System.out.println("backBlank : " + backBlank);
        
        s = s.trim();
        String[] sArr = s.split(" ");
        List<String> list = new ArrayList<String>();
        for(int i=0; i<sArr.length; i++) {
        	list.add(sArr[i]);
        }
        
        for(int i=0; i<list.size(); i++) {
        	for(int j=0; j<list.get(i).length(); j++){
            	//System.out.println("sArr[i] : " + sArr[i]);
                String s1 = sArr[i].toUpperCase();
                String s2 = sArr[i].toLowerCase();
                if(j % 2 == 0){
                    answer += s1.charAt(j);
                }else{
                    answer += s2.charAt(j);
                }
            }
            answer += " ";
        }
        /*
        for(int i=0; i<sArr.length; i++){
            for(int j=0; j<sArr[i].length(); j++){
            	//System.out.println("sArr[i] : " + sArr[i]);
                String s1 = sArr[i].toUpperCase();
                String s2 = sArr[i].toLowerCase();
                if(j % 2 == 0){
                    answer += s1.charAt(j);
                }else{
                    answer += s2.charAt(j);
                }
            }
            answer += " ";
        }
        */
        answer = answer.trim();
        for(int i=0; i<frontBlank; i++) {
        	answer = " " + answer;
        }
        
        for(int i=0; i<backBlank; i++) {
        	answer = answer + " ";
        }
        System.out.println("answer : " + answer);
        
        //split(s, -1) 로 사용하면 양쪽 공백이 사라지지 않는다고 함
        
        return answer;
    }
}
