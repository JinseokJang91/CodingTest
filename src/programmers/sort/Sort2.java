package programmers.sort;

public class Sort2 {
	//정렬>가장 큰 수
	public static void main(String[] args) {

		SolutionSort2 sol = new SolutionSort2();
		//int[] numbers = {4, 9, 432, 446, 55, 48};
		//int[] numbers = {1, 0, 10, 1000, 999, 101};
		//int[] numbers = {12, 121};
		int[] numbers = {21, 212};
		String result = sol.solution(numbers);
		System.out.println("result : " + result);
	}

}

//문제 풀이 통과한 class(=답)
class SolutionSort2 {
    private String[] sorted = new String[100000];
    
    public String solution(int[] numbers) {
    	
    	//코딩테스트 연습 > 정렬 > 가장 큰 수
        String answer = "";
        
        int check = 0;
        if(numbers.length >= 1 && numbers.length <= 100000) {
        	for(int i=0; i<numbers.length; i++) {
        		if(numbers[i] >= 0 && numbers[i] <= 1000) {
        			check = 1;
        		}else {
        			check = 0;
        			break;
        		}
        	}
        }
        
        if(check == 1) {
        	//첫 째 자리가 높으면 자릿수와 관계없이 높은게 앞으로 와야함
        	//첫 째 자리가 같은 경우에는 그 다음 자릿수 크기를 비교 -> [3, 39, 32] 이면 39 - 3 - 32 순으로 배열해야 함(3               은 33으로 생각하면 될 것 같다.)
        	//원소가 1000까지 있으므로 네 자리까지 비교해야 함
        	
        	String[] result = new String[numbers.length];
        	
        	for(int i=0; i<result.length; i++) {
        		result[i] = String.valueOf(numbers[i]);
        	}
        	
            mergeSort(result, 0, numbers.length-1);
            
            if(result[0].equals("0")) {
                answer = "0";
                return answer;
            }else{
            	/*
                for(int i=0; i<result.length; i++) {
                    answer += result[i];
                }*/
                
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<result.length; i++) {
                	sb.append(result[i]);
                }
                answer = sb.toString();
                
            }
        }

        return answer;
    }
    
    public void mergeSort(String[] result, int m, int n) {
    	if(m < n) {
    		int middle = (m+n) / 2;
    		mergeSort(result, m, middle);
    		mergeSort(result, middle+1, n);
    		merge(result, m, middle, n);
    	}
    }

    public void merge(String[] result, int m, int middle, int n) {
    	
    	int i = m;
    	int j = middle + 1;
    	int k = m;
    	
    	while(i <= middle && j <= n) {
    		if((result[i]+result[j]).compareTo((result[j]+result[i])) > 0) {
    			sorted[k] = result[i];
    			i++;
    		}else {
    			sorted[k] = result[j];
    			j++;
    		}
    		k++;
    	}
    	
    	if(i > middle) {
			for(int t = j; t <= n; t++) {
				sorted[k] = result[t];
				k++;
			}
		}else {
			for(int t = i; t <= middle; t++) {
				sorted[k] = result[t];
				k++;
			}
		}
    	
    	// 정렬된 배열을 삽입
		for(int t = m; t <= n; t++) {
			result[t] = sorted[t];
		}

    }
}


//고민해본 내용이 담긴 class
class SolutionSort3 {
    public String solution(int[] numbers) {
    	
    	//코딩테스트 연습 > 정렬 > 가장 큰 수
        String answer = "";
        
        int check = 0;
        if(numbers.length >= 1 && numbers.length <= 100000) {
        	for(int i=0; i<numbers.length; i++) {
        		if(numbers[i] >= 0 && numbers[i] <= 1000) {
        			check = 1;
        		}else {
        			check = 0;
        			break;
        		}
        	}
        }
        if(check == 1) {
        	//첫 째 자리가 높으면 자릿수와 관계없이 높은게 앞으로 와야함
        	//첫 째 자리가 같은 경우에는 그 다음 자릿수 크기를 비교 -> [3, 39, 32] 이면 39 - 3 - 32 순으로 배열해야 함(3은 33으로 생각하면 될 것 같다.)
        	//원소가 1000까지 있으므로 네 자리까지 비교해야 함
        	
        	String[] result = new String[numbers.length];
        	String[] result2 = new String[numbers.length];
        	//List<String> list = new ArrayList<String>();
        	
        	for(int i=0; i<result.length; i++) {
        		result[i] = String.valueOf(numbers[i]);
        	}

        	for(int i=0; i<result.length; i++) {
        		result2[i] = String.valueOf(numbers[i]);
        		for(int j=0; j<3; j++) {
        			if(result2[i].length() < 4) {
        				result2[i] += result[i].charAt(0);
        			}
        		}
        	}
        	
        	System.out.print("result : ");
        	for(int i=0; i<result.length; i++) {
        		System.out.print(result[i] + ' ');
        	}
        	System.out.println();
        	
        	System.out.print("result2 : ");
        	for(int i=0; i<result2.length; i++) {
        		System.out.print(result2[i] + ' ');
        	}
        	System.out.println();
        	
        	/*
        	Arrays.sort(result, Comparator.reverseOrder());
        	
        	for(int i=0; i<result.length; i++) {
        		for(int j=i+1; j<result.length; j++) {
        			if((result[i]+result[j]).compareTo((result[j]+result[i])) < 0){
        				String temp = result[i];
        				result[i] = result[j];
        				result[j] = temp;
        			}
        		}
        	}
        	*/
        	//String[] arr = new String[numbers.length];
        	result = mergeSort(result, 0, numbers.length-1);
        	System.out.print("ppp : ");
        	for(int i=0; i<result.length; i++) {
        		System.out.print(result[i] + ' ');
        	}
        	System.out.println();
        	
        	
        	if(result[0].equals("0")) {
        		return "0";
        	}
        	
        	/*
        	for(int i=0; i<result2.length; i++) {
        		for(int j=i+1; j<result2.length; j++) {
        			if(result2[i].compareTo(result2[j]) < 0) {
        				String temp = result2[i];
        				result2[i] = result2[j];
        				result2[j] = temp;
        				
        				String temp2 = result[i];
        				result[i] = result[j];
        				result[j] = temp2;
        			}
        			if(result2[i].compareTo(result2[j]) == 0) {
        				if((result[i]+result[j]).compareTo((result[j]+result[i])) < 0) {
        					String temp = result2[i];
            				result2[i] = result2[j];
            				result2[j] = temp;
            				
            				String temp2 = result[i];
            				result[i] = result[j];
            				result[j] = temp2;
        				}
        			}
        		}
        	}*/
        	
        	System.out.print("result : ");
        	for(int i=0; i<result.length; i++) {
        		System.out.print(result[i] + ' ');
        	}
        	System.out.println();
        	
        	System.out.print("result2 : ");
        	for(int i=0; i<result2.length; i++) {
        		System.out.print(result2[i] + ' ');
        	}
        	System.out.println();
        	
        	
        	
        	
        	/*
        	//1. 먼저 배열을 String화
        	String[] compare = new String[numbers.length];	//비교할 String배열
        	String[] result = new String[numbers.length];	//결과값을 정렬할 String배열
        	
        	//2. compare과 result배열에 값을 String화해서 삽입
        	for(int i=0; i<numbers.length; i++) {
        		compare[i] = String.valueOf(numbers[i]);
        		result[i] = String.valueOf(numbers[i]);
        	}
        	System.out.print("compare : ");
        	for(int i=0; i<compare.length; i++) {
        		System.out.print(compare[i] + ' ');
        	}
        	System.out.println();
        	//3. compare에 값들을 네 자리로 동일하게 맞춰줌
        	for(int i=0; i<compare.length; i++) {
        		if(!compare[i].equals("0")) {
        			for(int j=0; j<4; j++) {
            			if(compare[i].length() < 4) {
            				compare[i] += compare[i].charAt(0);
                		}
            		}
        		}
        	}
        	System.out.print("compare : ");
        	for(int i=0; i<compare.length; i++) {
        		System.out.print(compare[i] + ' ');
        	}
        	System.out.println();
        	//4. 정렬하기 위한 수 비교를 위해 String값을 compare2에 int값으로 다시 삽입
        	int[] compare2 = new int[compare.length];
        	for(int i=0; i<compare2.length; i++) {
        		compare2[i] = Integer.valueOf(compare[i]);
        	}
        	
        	//5. 내림차순 정렬과 동시에 result의 동일한 인덱스도 동일하게 위치를 바꿔줌
        	
        	for(int i=0; i<compare2.length; i++) {
        		for(int j=i+1; j<compare2.length; j++) {
        			if(compare2[i] < compare2[j]) {
        				int temp = compare2[i];
        				compare2[i] = compare2[j];
        				compare2[j] = temp;
        				
        				String temp2 = result[i];
        				result[i] = result[j];
        				result[j] = temp2;
        			}
        			
        			if(compare2[i] == compare2[j]) {
        				if(Integer.valueOf(result[i]+result[j]) < Integer.valueOf(result[j]+result[i])) {
        					String temp2 = result[i];
            				result[i] = result[j];
            				result[j] = temp2;
        				}
        			}
        		}
        	}
        	*/
        	//quickSort(result, compare2, 0, result.length-1);
        	
        	for(int i=0; i<result.length; i++) {
        		System.out.print(result[i] + ' ');
        		answer += result[i];
        	}
        	System.out.println();
        	
        	
        	
        	
        	/*
        	for(int i=0; i<arr.length; i++) {
        		for(int j=i+1; j<arr.length; j++) {
        			if(arr[i].charAt(0) < arr[j].charAt(0)) {
        				
        				System.out.println("1 : "+arr[i]);
        				System.out.println("2 : "+arr[j]);
        				String temp = arr[i];
        				arr[i] = arr[j];
        				arr[j] = temp;
        			}
        			if(arr[i].charAt(0) == arr[j].charAt(0)) {
        				int index = 1;
        				
        				int size = 0;
        				if(arr[i].length() > arr[j].length()) {
        					size = arr[i].length();
        				}else {
        					size = arr[j].length();
        				}
        				
        				for(int x=0; x<size; x++) {
            				System.out.println("index : " + index);
            				if(arr[i].length() >= index+1 && arr[j].length() >= index+1) {
            					System.out.println("3 : "+arr[i]);
                				System.out.println("4 : "+arr[j]);
            					
                				if(arr[i].charAt(index) < arr[j].charAt(index)) {
                					String temp = arr[i];
                    				arr[i] = arr[j];
                    				arr[j] = temp;
                    				break;
                				}
                				
                				if(arr[i].charAt(index) < arr[j].charAt(index)) {
                					index++;
                				}
                				
            				}else {
            					System.out.println("5 : "+arr[i]);
                				System.out.println("6 : "+arr[j]);
                				
                				if(arr[i].length() <= index) {
                					String str = arr[i];
                					for(int n=0; n<index; n++) {
                						str += arr[i];
                					}
                					System.out.println("7 : "+str);
                					
                					if(str.charAt(index) < arr[j].charAt(index)) {
                						System.out.println("확인");
                						String temp = arr[i];
                        				arr[i] = arr[j];
                        				arr[j] = temp;
                        				break;
                					}
                					if(str.charAt(index) == arr[j].charAt(index)) {
                    					index++;
                    				}
                					
                				}
                				
                				if(arr[j].length() <= index) {
                					String str = arr[j];
                					for(int n=0; n<index; n++) {
                						str += arr[j];
                					}
                					System.out.println("8 : "+str);
                					
                					if(arr[i].charAt(index) < str.charAt(index)) {
                						String temp = arr[i];
                        				arr[i] = arr[j];
                        				arr[j] = temp;
                        				break;
                					}
                					
                					if(arr[i].charAt(index) == str.charAt(index)) {
                    					index++;
                    				}
                				}
                				
            				}
        				

        				}

        				
        			}
        		}
        	}
        	*/

        }
        return answer;
    }
    
    public String[] mergeSort(String[] result, int m, int n) {
    	String[] sorted = new String[result.length];
    	if(m < n) {
    		int middle = (m+n) / 2;
    		mergeSort(result, m, middle);
    		mergeSort(result, middle+1, n);
    		sorted = merge(result, m, middle, n);
    	}
    	
    	return sorted;
    }

    public String[] merge(String[] result, int m, int middle, int n) {
    	
    	String[] sorted = new String[result.length];
    	
    	int i = m;
    	int j = middle + 1;
    	int k = m;
    	
    	while(i <= middle && j <= n) {
    		if((result[i]+result[j]).compareTo((result[j]+result[i])) > 0) {
    			sorted[k] = result[i];
    			i++;
    		}else {
    			sorted[k] = result[j];
    			j++;
    		}
    		k++;
    	}
    	
    	if(i > middle) {
			for(int t = j; t <= n; t++) {
				sorted[k] = result[t];
				k++;
			}
		}else {
			for(int t = i; t <= middle; t++) {
				sorted[k] = result[t];
				k++;
			}
		}
    	
    	// 정렬된 배열을 삽입
		for(int t = m; t <= n; t++) {
			result[t] = sorted[t];
		}
    	
    	
    	return sorted;
    }
    
    public void quickSort(String[] result, int[] data, int start, int end) {
    	
    	if(start >= end) {
    		return;
    	}
    	
    	int pivot = start;
    	int i = start + 1;
    	int j = end;
    	int temp;
    	String temp2;
    	
    	while(i <= j) {
    		while(i <= end && data[i] >= data[pivot]) {
    			i++;
    		}
    		while(data[j] <= data[pivot] && j > start) {
    			j--;
    		}
    		
    		if(i > j) {
    			temp = data[j];
    			data[j] = data[pivot];
    			data[pivot] = temp;
    			
    			temp2 = result[j];
    			result[j] = result[pivot];
    			result[pivot] = temp2;
    		}else {
    			temp = data[j];
    			data[j] = data[i];
    			data[i] = temp;
    			
    			temp2 = result[j];
    			result[j] = result[i];
    			result[i] = temp2;
    		}
    		
    		quickSort(result, data, start, j-1);
    		quickSort(result, data, j+1, end);
    	}
    	
    }
}