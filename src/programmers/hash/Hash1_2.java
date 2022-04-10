package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;

public class Hash1_2{

	//해시>완주하지 못한 선수
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String[] participant = {"mislav", "stanko", "stanko","stanko", "mislav", "ana", "mislav", "mislav"};
		//String[] completion = {"mislav","stanko", "ana", "mislav", "stanko", "mislav", "mislav"};
		
		String[] participant = {"mislav", "stanko","stanko", "stanko","mislav", "ana"};
		String[] completion = {"mislav", "stanko", "ana", "stanko","mislav"};
		
		//String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		//String[] completion = {"josipa", "filipa", "marina", "nikola"};
		
		String answer = "";
		
		//HashMap의 contaninsKey, remove 메소드를 이용
		//participant와 completion은 key-value 쌍으로는 묶을 수 없으므로
		//participant 먼저 key에 대입 후 completion값과 비교해야함
		//대신 key는 중복이 안되므로 동명이인일 경우 추가적으로 처리해줘야함
		
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
		
		//2. 명단
		if(check == 0) {
			//(1) 동명이인이 없는 경우
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			//HashMap에 key값으로 넣어도 중복값이 없기 때문에 괜찮음
			for(int i=0; i<participant.length; i++) {
				if(!map.containsKey(participant[i])) {
					map.put(participant[i], 0);
				}else {
					//동명이인이 있으면 중복 카운트해서 value값으로 대입
					map.replace(participant[i], ((int)map.get(participant[i]))+1);
				}
			}
			//key가 중복되지 않으므로 단순히 key만 비교해서 제거
			for(int i=0; i<completion.length; i++) {
				if(((int)map.get(completion[i])) == 0) {
					map.remove(completion[i]);
				}else {
					System.out.println(map.get(completion[i]));
					map.replace(completion[i], ((int)map.get(completion[i]))-1);
				}
				
			}
			
			System.out.println(map);
			//System.out.println("==========================");
			answer=map.keySet().iterator().next();
			//동명이인이 없을 때는 결국 한 명의 데이터만이 HashMap에 남음
			
			
			//★ 아래 내용은 HashMap을 2개 써서 참가자 명단과 완주자 명단을 각각 해시맵에 넣어서 비교하려고 한 것
			//중복 체크를 카운트해서 카운트가 다른 key값이 완주하지 못한 사람이므로 그렇게 하려고 했으나
			//위에꺼가 더 간단하게 처리할 수 있어서 아래 내용은 주석처리
			
			/*
			if(!map.isEmpty()) {
				System.out.println(map.keySet().iterator().next());
				answer=map.keySet().iterator().next();
			}else {
				//그렇지 않은 경우(제거했을 때 참가자 명단이 완전히 빈 경우)에는 다시 참가자 명단을 생성해서 동명이인 비교
				for(int i=0; i<participant.length; i++) {
					if(!map.containsKey(participant[i])) {
						map.put(participant[i], 0);
					}else {
						map.replace(participant[i], ((int)map.get(participant[i]))+1);
					}
				}
				System.out.println(map);
				//완주자 명단(중복 카운트)을 다른 HashMap에 생성해 두 해시맵의 value값을 비교
				HashMap<String, Integer> map2 = new HashMap<String, Integer>();
				for(int i=0; i<completion.length; i++) {
					if(!map2.containsKey(completion[i])) {
						map2.put(completion[i], 0);
					}else {
						map2.replace(completion[i], ((int)map2.get(completion[i]))+1);
					}
				}
				System.out.println(map2);
				
				Iterator<String> iter = map.keySet().iterator();
				Iterator<String> iter2 = map2.keySet().iterator();
				
				while(iter.hasNext()) {
					String key = iter.next();
					String key2 = iter2.next();

					if(map.get(key) != map2.get(key2)) {
						answer = key;
						break;
					}
				}
				
			}*/
			System.out.println(answer);
		}
		
		
		
		//★ 아래 내용은 HashMap을 이해하기 위한 연습 기록들
		
		/*
		HashMap<String[], String[]> map = new HashMap<String[], String[]>();
		
		
		map.put(completion, participant);
		
		Iterator<Entry<String[], String[]>> iter = map.entrySet().iterator();
		
		while(iter.hasNext()) {
			Map.Entry<String[], String[]> entry = iter.next();
			System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
		}
		System.out.println("========================================");
		
		Iterator<String[]> iter2 = map.keySet().iterator();
		while(iter2.hasNext()) {
			String[] key = iter2.next();
			System.out.println("Key : " + key + ", Value : " + map.get(key));
		}
		*/
		
		/*
		HashMap<String[], String[]> map = new HashMap<String[], String[]>();
		
		map.put(participant, completion);
		
		for(Map.Entry<String[], String[]> e : map.entrySet()) {
			System.out.println(map.c);
			System.out.println("Key : " + e.getKey() + ", Value : " + e.getValue());
			System.out.println(map.containsKey(e.getKey()));
			for(int i=0; i<e.getKey().length; i++) {
				for(int j=0; j<e.getValue().length; j++) {
					//System.out.println("Key : " + e.getKey()[i] + ", Value : " + e.getValue()[j]);
					if(e.getKey()[i].equals(e.getValue()[j])) {
						//System.out.println(e.getKey()[i]);
					}else {
						//System.out.println("##"+e.getKey()[i]);
					}
				}
			}
		}
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		
		for(String e : participant) {

		}
		
		for(int i=0; i<participant.length; i++) {
			//map2.put(participant[i], completion[i]);
		}
		*/
		
	}

}
