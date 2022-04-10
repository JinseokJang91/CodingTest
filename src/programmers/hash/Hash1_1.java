package programmers.hash;

public class Hash1_1 {

	//해시>완주하지 못한 선수
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//소문자는 97~122
		char test1 = 122;
		//System.out.println(test1);
		
		
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};

		String answer = "";
		
		
		//1. 제한사항 체크
		int check = 0;
		
		//1-1. 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하
		if(participant.length >= 1 && participant.length <= 100000) {
			//1-2. completion의 길이 = participant의 길이 - 1
			if(completion.length + 1 == participant.length) {				
				for(int i=0; i<participant.length; i++) {
					//1-3-1. 참가자의 이름은 1개 이상 20개 이하
					if((participant[i].length() >= 1 && participant[i].length() <= 20)) {						
						for(int j=0; j<participant[i].length(); j++) {
							//1-3-2. 참가자의 이름은 알파벳 소문자
							if(participant[i].charAt(j) >= 97 && participant[i].charAt(j) <= 122) {
								check = 0;
							}else {
								check = 1;
							}
						}
					}
				}
				
			}
		}
		
		//2. 명단을 지워가기(for문 사용)
		if(check == 0) {			
			for(int i=0; i<participant.length; i++) {
				
				for(int k=0; k<completion.length; k++) {
					if(participant[i].equals(completion[k])) {
						participant[i] = "";
						completion[k] = "";
					}
				}
				if(!(participant[i].equals(""))) {
					answer = participant[i];
					break;
				}
			}
		}
		
		//2. 제한사항 만족 후 동명이인 체크
		// --> ★ 아래 내용은 동명이인이 있는 경우와 없는 경우를 나눠본 것인데
		// --> 해보니 위에꺼 만으로도 모든 조건 만족하는 듯해서 나머지는 주석처리함
		
		/*
		if(check == 0) {
			
			int sameCheck = 0;
			//2-1. 동명이인 체크
			
			for(int i=0; i<participant.length; i++) {
				for(int j=1; j<participant.length; j++) {
					if(participant[i].equals(participant[j])) {
						sameCheck = 0;
					}else {
						sameCheck = 1;
					}
				}
			}
			
			//2-2. 동명이인이 있는 경우 -> 명단을 지워가기
			if(sameCheck == 0) {
				for(int i=0; i<participant.length; i++) {
					
					for(int k=0; k<completion.length; k++) {
						if(participant[i].equals(completion[k])) {
							participant[i] = "";
							completion[k] = "";
						}
					}
					if(!(participant[i].equals(""))) {
						answer = participant[i];
						break;
					}
				}
			//2-3. 동명이인이 없는 경우 -> count변수 이용
			}else {
				for(int i=0; i<participant.length; i++) {
					int count = 0;
					
					for(int k=0; k<completion.length; k++) {
						if(!(participant[i].equals(completion[k]))) {
							count++;
							if(count == completion.length) {
								answer = participant[i];
							}
						}
					}
				}
			}
		}*/
		
		System.out.println(answer);
	}

}
