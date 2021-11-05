package day8;

import java.util.Arrays;

public class MrthodRandomArrayEx1 {
	//메소드 1~45랜덤수6개출력
	public static void main(String[] args) {
		/* 1에서 45사이의 랜덤한 수를 6개 생성하여 배열에 저장하고, 출력하는 코드를 작성하세요.
		 * 메소드 생성하고 호출할 것. 단, 중복 가능
		 * */
		int size = 6, min = 1, max = 45;
		int [] arr = new int [size];
		randomArr1(min,max,arr);
		System.out.println(Arrays.toString(arr));
		
		int arr2[] = randomArr2(min,max,size);
		System.out.println(Arrays.toString(arr2));

	}
	/* 기능 :배열이 주어지면 주어진 배열에 min에서 max사이의 랜덤한 수를 생성하여 저장한 후 만들어진 배열을 알려주는 메소드
	 * 매개변수 : 배열,범위 => int min, int max , int [] arr
	 * 리턴타입 : void
	 * 메소드명 : randomArr1
	 * */
	public static void randomArr1(int min, int max, int [] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = (int)(Math.random()*(max-min+1)+min);
		}
	}

	/* 기능 :배열의 크기가 주어지면 주어진 배열의 크기만큼 min에서 max사이의 랜덤한 수를 생성하여 저장한 후 만들어진 배열을 알려주는 메소드
	 * 매개변수 : 크기,범위 => int min, int max , int size
	 * 리턴타입 : 배열 => int[]
	 * 메소드명 : randomArr2
	 * */
	public static int[] randomArr2(int min, int max, int size)
	{
		int []arr = new int[size];
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = (int)(Math.random()*(max-min+1)+min);
		}
		return arr;
	}

}
