package day7;

public class MethodArrayEx1 {
	//메소드 매개변수가 배열인 경우
	public static void main(String[] args) {
		int [] arr = {1, 2, 3};
		printArray(arr);
		intArray(arr);
		printArray(arr);
		arr = new int[]{3, 1, 2};
		sortArray(arr);
		printArray(arr);
		
	}
	/* 기능 : 정수형 배열이 주어지면 해당 배열의 모든 값을 한줄로 콘솔에 출력하는 메소드
	 * 매개변수 : 정수형 배열 => int [] arr
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printArray
	 * */
	public static void printArray(int [] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		//arr[0] = 10;//이 코드를 활성화하면 원본 배열의 값이 변경됨
		
	}
	/* 기능 : 정수형 배열이 주어지면 주어진 배열의 모든 값을 0으로 초기화 하는 메소드
	 * 매개변수 : 정수형 배열 => int []arr
	 * 리턴타입 : 없음 => void
	 * 메소드명 : intArray
	 * */
	public static void intArray(int [] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = 0;
		}
	}
	/* 메소드 안에 있는 부분은 구형하지 않아도됨.
	 * 기능 : 정수형 배열이 주어지면 주어진 배열을 정렬하는 메소드
	 * 매개변수 : 정수형 배열 => int [] arr
	 * 리턴타입 : 없음 => void
	 * 메소드명 : sortArray
	 * */
	public static void sortArray(int [] arr)
	{
		for(int i = 0; i < arr.length-1; i++)
		{
			for(int j = 0; j < arr.length-i-1; j++)
			{
				if(arr[j] > arr[j+1])
				{
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}

}
