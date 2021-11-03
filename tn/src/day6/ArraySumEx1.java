package day6;

public class ArraySumEx1 {
	//2~10사이 짝수배열합출력
	public static void main(String[] args) {
		/* 2부터 10사이의 짝수들을 배열에 저장하고, 배열에 저장된 값의 합을 출력하는 코드를 작성하세요.
		 * 정수형 5개짜리 배열 선언
		 * 배열에 2부터 10까지 저장
		 * 배열에 있는 값을 꺼내서 합
		 * */
		//방법1
		int []arr = new int[5];
		int i;
		int sum = 0;
		arr[0] = 2;
		arr[1] = 4;
		arr[2] = 6;
		arr[3] = 8;
		arr[4] = 10;
		sum = arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
		System.out.println("2부터 10까지 합 : " + sum);
		
		System.out.println();
		
		//방법2
		int []arr2 = new int[5];
		sum = 0;
		for(i = 0; i < 5; i++)
		{
			arr2[i] = i * 2 + 2;
			sum += arr2[i]; 
		}
		System.out.println("2부터 10까지 합 : " + sum);
		

	}

}
