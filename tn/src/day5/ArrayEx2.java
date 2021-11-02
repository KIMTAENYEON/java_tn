package day5;

public class ArrayEx2 {
	//배열에 값 저장
	public static void main(String[] args) {
		/* 
		 * */
		int arr[] = new int[5];
		//배열 arr의 0번지에 1을 저장
		arr[0] = 1;
		System.out.println("0번지의 값 : " + arr[0]);
		arr[1] = 2;
		System.out.println("1번지의 값 : " + arr[1]);
		arr[2] = 3;
		System.out.println("2번지의 값 : " + arr[2]);
		arr[3] = 4;
		System.out.println("3번지의 값 : " + arr[3]);
		arr[4] = 5;
		System.out.println("4번지의 값 : " + arr[4]);
		
		System.out.println("----------------");
		int i;
		for(i = 0; i < 5; i++)
		{
			arr[i] = i + 1;
			System.out.println(i + "번지의 값 : " + arr[i]);
		}
		System.out.println("----------------");
		int num1, num2, num3, num4, num5;
		num1 = arr[0];
		System.out.println("num1의 값 : " + num1);
		num2 = arr[1];
		System.out.println("num1의 값 : " + num2);
		num3 = arr[2];
		System.out.println("num1의 값 : " + num3);
		num4 = arr[3];
		System.out.println("num1의 값 : " + num4);
		num5 = arr[4];
		System.out.println("num1의 값 : " + num5);
	}

}
