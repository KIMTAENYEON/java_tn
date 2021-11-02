package day5;

public class MultipleTableEx1 {
	//2~9단 출력
	public static void main(String[] args) {
		/* 2단에서 9단까지 구구단을 출력하는 코드를 작성하세요.
		 * */
		//for
		int i, j;
		for(i = 2; i <= 9; i++)
		{
			for(j = 1; j <= 9; j++)
			{
				System.out.print(i + " x " + j + " = " + (i * j) + " ");
			}
			System.out.println();
		}
		System.out.println();
		//while
		i = 2;
		while(i <= 9) 
		{
			j = 1;
			while(j <= 9) 
			{
				System.out.print(i + " x " + j + " = " + (i * j) + " ");
				j++;
			}
			System.out.println();
			i++;
		}
		
	}

}
