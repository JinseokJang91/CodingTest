package programmers.allProblems;

public class LV1_12 {

	public static void main(String[] args) {
		SolutionLV1_12 sol = new SolutionLV1_12();
		
		//String new_id = "...!@BaT#*..y.abcdefgh.jklm.asdasd";
		String new_id = "abcdefghijklmn.p";
		
		String answer = sol.solution(new_id);
		System.out.println("answer : " + answer);
		
	}

}

class SolutionLV1_12 {
    public String solution(String new_id) {
    	
    	//2021 KAKAO BLIND RECRUITMENT > 신규 아이디 추천
        String answer = "";
        
        //아이디 길이 : 3자 이상 15자 이하
        
        // 새로운 아이디를 추천해주는 단계
        // 1. 모든 대문자를 대응되는 소문자로 치환
        // 2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거
        // 3. 마침표(.)가 2번 이상 연속된 부분은 하나의 마침표(.)로 치환
        // 4. 마침표(.)가 처음이나 끝에 위치 한다면 제거
        // 5. 빈 문자열이라면 a를 대입
        // 6. 길이가 16자 이상이면 첫 15개 문자를 제외한 나머지 문자들 모두 제거, 제거 후 마침표(.)가 끝에 위치한다면 끝에 위치한 마침표 제거
        // 7. 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복
        String id = "";
        id = firstStep(new_id);
        id = secondStep(id);
        id = thirdStep(id);
        id = fourthStep(id);
        id = fifthStep(id);
        id = sixthStep(id);
        id = seventhStep(id);
        answer = id;
        
        return answer;
    }
    
    public String firstStep(String id) {
    	id = id.toLowerCase();
    	System.out.println("1단계 : " + id);
    	return id;
    }
    
    public String secondStep(String id) {
    	//알파벳 소문자 : 97 ~ 122
    	String temp = "";
    	for(int i=0; i<id.length(); i++) {
    		char ch = id.charAt(i);
    		if((ch >= 97 && ch <= 122) || (ch >= '0' && ch <= '9')
    			|| (ch == '-') || (ch == '_') || (ch == '.')) {
    			temp += ch;
    		}
    	}
    	System.out.println("2단계 : " + temp);
    	return temp;
    }
    
    public String thirdStep(String id) {

    	while(true) {
    		if(id.contains("..")) {
    			//System.out.println(".. 포함하고있음");
    			id = id.replace("..", ".");
    			//System.out.println("id : " + id);
    		}else {
    			//System.out.println(".. 포함 안 함");
    			break;
    		}
    	}
    	System.out.println("3단계 : " + id);
    	
    	return id;
    }
    
    public String fourthStep(String id) {
    	
    	//substring(시작 인덱스, 끝 인덱스) : 시작 인덱스부터 끝 인덱스 이전까지 자름
    	//indexOf(".") : 마침표(.)가 처음 나타나는 인덱스 반환
    	if(id.startsWith(".")) {
    		id = id.substring(id.indexOf(".")+1);
    	}
    	
    	if(id.endsWith(".")) {
    		id = id.substring(0, id.length()-1);
    		//System.out.println("id : " + id);
    	}
    	System.out.println("4단계 : " + id);
    	
    	return id;
    }
    
    public String fifthStep(String id) {
    	
    	if(id.isEmpty()) {
    		id = "a";
    	}
    	System.out.println("5단계 : " + id);
    	return id;
    }
    
    public String sixthStep(String id) {
    	//15개 문자만 남기려면 0~14 인덱스를 남기면 됨
    	if(id.length() >= 16) {
    		//System.out.println("확인");
    		id = id.substring(0, 15);
    		//System.out.println("id1 : " + id);
    		if(id.endsWith(".")) {
    			id = id.substring(0, id.length()-1);
    			//System.out.println("id2 : " + id);
    		}
    	}
    	System.out.println("6단계 : " + id);
    	
    	return id;
    }
    
    public String seventhStep(String id) {
    	while(id.length() <= 2) {
    		id += id.charAt(id.length()-1);
    		//System.out.println("id : " + id);
    		
    		if(id.length() > 2) {
    			//System.out.println("3이상 완성");
    			break;
    		}
    	}
    	System.out.println("7단계 : " + id);
    	return id;
    }
}