package day3;

import java.util.Scanner;

public class SwitchMonthEx1 {
	//switch문 월의 마지막일
	public static void main(String[] args) {
		/* 월의 마지막일을 출력하는 코드를 switch문으로 작성하세요.
		 * 31 : 1 3 5 7 8 10 12
		 * 30 : 4 6 9 11
		 * 28 : 2
		 * */
		Scanner scan = new Scanner(System.in);
		
		System.out.print("월을 입력하세요 : ");
		int month = scan.nextInt();
		
		switch(month)
		{
		case 1,3,5,7,8,10,12:
			System.out.println(month + "월의 마지막일은 31일입니다.");
			break;
		case 4,6,9,11:
			System.out.println(month + "월의 마지막일은 30일입니다.");
			break;
		case 2:
			System.out.println(month + "월의 마지막일은 28일입니다.");
			break;
		default:
			System.out.println("잘못입력했습니다.");
		}
		
		scan.close();

	}

}
