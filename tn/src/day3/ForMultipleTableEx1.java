package day3;

public class ForMultipleTableEx1 {
	//for문 구구단
	public static void main(String[] args) {
		/* 구구단 7단을 출력하는 코드를 작성하세요.
		 * 출력예시
		 * 7 x 1 = 7
		 * 7 x 2 = 14
		 * ...
		 * 7 x 9 = 63
		 * */
		int i;
		int num = 7;
		for(i = 1; i <= 9; i++)
		{
			System.out.println(num + " x " + i + " = " + (num * i));
		}

	}

}
