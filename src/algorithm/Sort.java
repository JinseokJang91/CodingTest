package algorithm;

public class Sort {

	//병합 정렬을 위한 전역 변수
	private static int[] sorted = new int[8];
	
	public static void main(String[] args) {
		
		//int temp; 정렬 시 스와핑을 위해 사용하는 일시적 변수
				
		int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		
		//선택 정렬 출력 결과 확인
		System.out.print("선택 정렬 : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(selectionSort(arr)[i] + " ");
		}
		System.out.println();
		
		//버블 정렬 출력 결과 확인
		System.out.print("버블 정렬 : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(bubbleSort(arr)[i] + " ");
		}
		System.out.println();
		
		//삽입 정렬 출력 결과 확인
		System.out.print("삽입 정렬 : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(insertionSort(arr)[i] + " ");
		}
		System.out.println();
		
		//퀵 정렬 출력 결과 확인
		int[] data = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		int number = data.length;
		quickSort(data, 0, number - 1);
		System.out.print("퀵 정렬 : ");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
		
		//병합 정렬 출력 결과 확인
		int[] a = {7, 6, 5, 8, 3, 5, 9, 1};
		int num = 8;
		//int[] a = {7, 6, 5, 8};
		//int num = 4;
		mergeSort(a, 0, num - 1);
		System.out.print("병합 정렬 : ");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

	}
	
	private static int[] selectionSort(int[] arr) {
		
		//선택 정렬(Selection Sort)
		//오름차순 정렬 시 가장 작은 것을 선택해서 제일 앞으로 보내는 방식
		//시간복잡도 : O(N^2)
		
		int temp;
		int min;
		int index = 0; //아래에서 초기화되지 않고 바로 사용이 되기 때문에 위에서 초기화
		
		for(int i=0; i<arr.length; i++) {
			//적당히 큰 크기의 범위 설정
			min = 9999;
			for(int j=i; j<arr.length; j++) {
				if(min > arr[j]) {
					//j의 값을 활용하기 위해 min, index에 각각 필요한 값을 넣어줌
					min = arr[j];
					index = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		
		return arr;
	}
	
	private static int[] bubbleSort(int[] arr) {
		
		//버블 정렬(Bubble Sort)
		//오름차순 정렬 시 옆에 있는 값과 비교해서 더 작은 값을 앞으로 보내는 방식
		//시간복잡도 : O(N^2)
		
		int temp;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<(arr.length-1)-i; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return arr;
	}
	
private static int[] insertionSort(int[] arr) {
		
		//삽입 정렬(Bubble Sort)
		//오름차순 정렬 시 각 숫자를 적절한 위치에 삽입하는 방식(각 i의 이전 인덱스는 정렬이 완료되었다고 판단)
		//시간복잡도 : O(N^2)
		//시간복잡도는 N^2이지만 선택 정렬, 버블 정렬보다 효과적인 알고리즘이다.
		//데이터가 이미 거의 정렬된 상태에 한해서는 어떤 알고리즘보다도 빠르다는 특징이 있다.
		
		int temp;
		int j = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			j=i; //j에 i를 넣기 때문에 j+1이 ArrayOutOfIndex 되지 않도록 범위를 arr.length-1로 설정
			while(arr[j+1] < arr[j]) {
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				j--;
			}
		}
		
		return arr;
	}
	
	private static void quickSort(int[] data, int start, int end) {
		
		//퀵 정렬(Bubble Sort) = 분할과 정복
		//오름차순 정렬 시 특정한 값을 기준으로 큰 숫자와 작은 숫자를 나누는 방식
		//평균 시간복잡도 : O(N*logN) -> logN 은 log2의 N을 의미
		//최악의 경우에는 O(N^2)이 나오기도 한다. -> 대부분 정렬되어있는 경우(분할과 정복의 이점을 활용하지 못하기 때문)
		//퀵정렬은 시간복잡도 면에서 정렬 알고리즘 중 가장 효과적인 알고리즘이라고 할 수 있다.
		//일반적으로 기준값(Pivot값)이 있다.(보통 가장 앞의 값을 설정)
		
		//예시 [ (X) = 기준값 ]
		//(3) 7 8 1 5 9 6 10 2 4 -> 3을 기준으로 오른쪽에서 3보다 첫 번째로 큰 값은 7 / 왼쪽에서 3보다 작은 값은 2
		//(3) 2 8 1 5 9 6 10 7 4 -> 3을 기준으로 오른쪽에서 3보다 첫 번째로 큰 값은 8 / 왼쪽에서 3보다 작은 값은 1
		//(3) 2 1 8 5 9 6 10 7 4 -> 3을 기준으로 오른쪽에서 3보다 첫 번째로 큰 값은 8 / 왼쪽에서 3보다 작은 값은 1
		//							-> 8, 1이 엇갈리게 되었을 때 작은 값과 3의 위치를 바꿔준다.
		//1 2 [3] 8 5 9 6 10 7 4 -> 3의 위치가 고정된다. (3 왼쪽 값은 모두 3보다 작고, 3 오른쪽 값은 모두 3보다 큰 값들이 위치한다.)
		
		//(1) 2 [3] 8 5 9 6 10 7 4 -> 1을 기준으로 오른쪽에서 1보다 첫 번째로 큰 값은 2 / 왼쪽에서 1보다 작은 값은 없으므로 자기 자신을 선택
		//[1] 2 [3] 8 5 9 6 10 7 4 -> 결과적으로 1과 자기 자신을 바꿔주게 됨(위에서 기준값과 기준값보다 작은 값을 바꿔주는 과정과 동일)
		
		//[1] (2) [3] 8 5 9 6 10 7 4 -> 위 과정과 동일하게 수행
		//...
		
		if(start >= end) {	// 원소가 1개인 경우
			return;
		}
		
		int pivot = start;	// 첫 번째 원소
		int i = start + 1;	// 왼쪽 출발 지점(L->R)
		int j = end;		// 오른쪽 출발 지점(R->L)
		int temp;
		
		while(i <= j) {	// 엇갈릴 때까지 반복
			while(i <= end && data[i] <= data[pivot]) {	// 키 값보다 큰 값을 만날 때까지 반복
				i++;
			}
			while(data[j] >= data[pivot] && j > start) { // 키 값보다 작은 값을 만날 때까지 반복
				j--;
			}
			/*
				내림차순의 경우에는 기준값 기준으로 좌우만 바꾸면 되기 때문에
				
				data[i] <= data[pivot] -> data[i] >= data[pivot]
				
				data[j] >= data[pivot] -> data[j] <= data[pivot]
				
				와 같이 부등호만 바꿔주면 된다.
			*/
			if(i > j) {	// 현재 엇갈린 상태라면 키 값과 교체
				temp = data[j];
				data[j] = data[pivot];
				data[pivot] = temp;
			}else {		// 엇갈린 상태가 아니라면 i, j 값을 서로 교체
				temp = data[j];
				data[j] = data[i];
				data[i] = temp;
			}
		}
		
		//결과적으로 데이터가 엇갈려서 while문을 빠져나오면 키 값을 기준으로
		//왼쪽
		quickSort(data, start, j - 1);
		//오른쪽
		quickSort(data, j + 1, end);
		//에서 각각 퀵 정렬을 다시 수행한다.
		
	}
	
	private static void merge(int a[], int m, int middle, int n) {
		
		//병합 정렬(Merge Sort)
		//일단 반으로 나누고 나중에 합쳐서 정렬하는 방식 (합치는 순간에 정렬)
		//시간복잡도 : O(N*logN)
		
		//배열이 7,6,5,8,... 일 때
		//7,6 / 5,8 로 나누어진 단계에서
		//i에는 7에 해당하는 인덱스를 의미하므로 m을 삽입, middle은 6과 5 사이를 의미하므로 j에는 middle + 1을 삽입
		//k는 i 인덱스부터 채워넣으므로 i값과 동일
		
		int i = m;
		int j = middle + 1;
		int k = m;
		
		//정렬 배열(sorted 배열)은 반드시 전역 변수로 선언!

		// 작은 순서대로 배열에 삽입
		while(i <= middle && j <= n) {
			if(a[i] <= a[j]) {
				sorted[k] = a[i];
				i++;
			}else {
				sorted[k] = a[j];
				j++;
			}
			k++;
		}

		// 남은 데이터도 삽입
		if(i > middle) {
			for(int t = j; t <= n; t++) {
				sorted[k] = a[t];
				k++;
			}
		}else {
			for(int t = i; t <= middle; t++) {
				sorted[k] = a[t];
				k++;
			}
		}

		// 정렬된 배열을 삽입
		for(int t = m; t <= n; t++) {
			a[t] = sorted[t];
		}
	}
	
	private static void mergeSort(int a[], int m, int n) {
		// 크기가 1보다 큰 경우
		if(m < n) {
			int middle = (m + n) / 2;
			mergeSort(a, m, middle);		// left는 왼쪽으로 나눌게 없어질때까지 실행된다 -> 첫 단계(a,0,3)
			mergeSort(a, middle + 1, n);	// right는 left가 끝나면 실행된다 -> 첫 단계(a,4,7)
			merge(a, m, middle, n);			// right가 끝나면 병합이 실행된다
		}
	}

}
