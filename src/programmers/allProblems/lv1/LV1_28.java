package programmers.allProblems.lv1;

public class LV1_28 {

	public static void main(String[] args) {

		//¿¬½À¹®Á¦ > Â¦¼ö¿Í È¦¼ö
		String answer = "";
        int num = 3;
        
        //0Àº Â¦¼ö·Î Ãë±Þ
        if(num % 2 == 0){
            answer = "Even";
        }else{
            answer = "Odd";
        }
        
        System.out.println("answer : " + answer);

	}

}
