package day5;

public class StarEx3 {
	//별 1~5출력(공백)
	public static void main(String[] args) {
		/* 		*
		 * 	   **	
		 * 	  ***
		 *   ****
		 *  *****
		 *  		공백 = 5-i
		 *  위와 같이 출력되도록 코드를 작성하세요.
		 *  반복횟수 : i는 1부터 5까지 1씩 증가
		 *  규칙성 : 공백을 5-i개 출력하고, *을 i개 출력하고, 엔터를 출력
		 *  		반복횟수 : j는 1부터 5-i까지 1씩 증가 " "을 출력
		 *  		실행문 : 공백을 출력
		 *  		반복횟수 : j는 1부터 i까지 1씩 증가
		 *  		실행문 : *을 출력 
		 *  		엔터를 출력
		 * */
		int i, j;
		int num = 5;
		for(i = 1; i <= 5; i++)
		{
			for(j = 1; j <= 5-i; j++)
			{
				System.out.print(" ");
			}
			for(j = 1; j <= i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		for(i = 5; i >= 1; i--)
		{
			for(j = 1; j <= 5; j++)
			{
				if(j < i)
				{
					System.out.print(" ");
				}
				else 
				{
					System.out.print("*");
				}			
			}
			System.out.println();
		}	
	}

}
