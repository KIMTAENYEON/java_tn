package day5;

public class PrimeNumEx1 {
	//이중반복문 2~100모든소수
	public static void main(String[] args) {
		/* 2부터 100이하의 모든 소수를 출력하는 예제
		 * 소수 판별 예제 참고.
		 * */
		//for
		int i, j;
		int count = 0;
		for(i = 2; i <= 100; i++)
		{
			count = 0;
			for(j = 1; j <= i; j++)
			{
				if(i % j == 0)
				{
					count++;
				}
			}
			if(count == 2)
			{
				System.out.print(i + " ");
			}
		}
		System.out.println();
		//while
		int num = 2;
		i = 1; count = 0;
		while(num <= 100)
		{
			i=1;//약수는 1부터 num까지 확인
			count = 0;
			while(i<=num)
			{
				if(num % i == 0)
				{
					count++;
				}
				i++;
			}
			if(count == 2)
			{
				System.out.print(num + " ");
			}
			num++;
		}
		

	}

}
