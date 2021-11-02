package day5;

public class StarEx4 {
	//별 피라미드출력(공백)
	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 코드를 작성하세요.
		 * 		* 
		 *     *** 
		 *    *****    
		 *   *******
		 *  *********  
		 * */	
		int i, j;
		//방법1
		for(i = 1; i <= 5; i++)
		{
			for(j = 1; j <= 5-i; j++)
			{
				System.out.print(" ");
			}
			for(j = 1; j <= (i*2-1); j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		//방법2
		 for(i = 1; i <= 5; i++)
		 {
			 for(j = 1; j <= (5-i); j++)
			 {
				 System.out.print(" ");
			 }
			 for(j = 1; j <= i; j++)
			 {
				 System.out.print("*");
			 }
			 for(j = 1; j <= (i-1); j++)
			 {
				 System.out.print("*");
			 }
			 System.out.println();
		 }
	}

}
