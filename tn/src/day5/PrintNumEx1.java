package day5;

public class PrintNumEx1 {
	//숫자판출력
	public static void main(String[] args) {
		/* 다음과 같이 출력하도록 코드를 작성하세요.
		 * 1 2 3
		 * 4 5 6
		 * 7 8 9
		 * */
		int i, j;
		//방법1
		for(i = 1; i <= 9; i++)
		{
			System.out.print(i + " ");
			if(i % 3 == 0)
			{
				System.out.println();
			}
		}
		System.out.println();
		//방법2
		for(i = 1; i <= 3; i++)
		{
			for(j = (3 * i - 2); j <= (3 * i); j++)
			{
				System.out.print(j + " ");
			}
			System.out.println();
		}

	}

}
