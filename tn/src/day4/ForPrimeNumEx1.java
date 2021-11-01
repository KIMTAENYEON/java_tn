package day4;

import java.util.Scanner;

public class ForPrimeNumEx1 {
	//for문 소수판별
	public static void main(String[] args) {
		/* 입력받은 정수가 소수인지 아닌지 판별하는 코드를 for문을 이용하여 작성하세요.
		 * 소수이면 소수, 소수가 아니면 소수가 아님이라고 출력.
		 * 소수는 약수가 2개인 수
		 * 4는 약수가 1,2,4로 3개이므로 소수가 아님
		 * 2는 약수가 1,2,로 2개이므로 소수
		 * 1은 약수가 1로 1개이므로 소수가 아님
		 * Scanner를 이용하여 num에 정수를 입력
		 * 반복횟수 : i는 1부터 num까지 1씩 증가
		 * 규칙성 : i가 num의 약수이면 count(약수의 갯수)를 1증가
		 * 반복문 종료후 : count가 2이면 소수라고 출력, 아니면 소수가 아님이라고 출력
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		
		int i;
		int count = 0;
		for(i = 1; i <= num; i++)
		{
			if(num % i == 0)
			{
				count++;
			}
		}
		if (count == 2)
		{
			System.out.println("소수입니다.");
		}
		else
		{
			System.out.println("소수가 아닙니다.");
		}
		switch(count)
		{
		case 2: 
			System.out.println("소수입니다.");
			break;
		default:
			System.out.println("소수가 아닙니다.");
		}
		String str = count == 2 ? "소수" : "소수가 아님";
		System.out.println(str);
		
		scan.close();

	}

}
