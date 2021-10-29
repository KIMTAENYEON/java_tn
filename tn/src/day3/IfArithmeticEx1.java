package day3;

import java.util.Scanner;

public class IfArithmeticEx1 {
	//if문 산술연산자
	public static void main(String[] args) {
		/* 두 정수와 산술연산자(+,-,*,/,%) 중 하나를 입력하여 입력한 연산자가 +이면
		 * 두 정수를 계산을 출력하고,
		 * 산술연산자가 아니면 산술연산자가 아닙니다라고 출력하는 코드를 작성하세요.
		 * 예시)
		 * 두 정수와 산술 연산자를 입력하세요 (예: 1 + 2) : 1 + 2
		 * 1 + 2 = 3
		 * 예시2)
		 * 두 정수와 산술 연산자를 입력하세요 (예: 1 / 2) : 1 / 2
		 * */
		Scanner scan = new Scanner(System.in);
				
		System.out.print(" 두 정수와 산술 연산자를 입력하세요.(예: 1 + 2) :");
		int num1 = scan.nextInt();
		char ch = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		if(ch == '+')
		{
			System.out.println(num1 + " " + ch + " " + num2 + " = " + (num1 + num2));			
		}
		else if(ch == '-')
		{
			System.out.println(num1 + " " + ch + " " + num2 + " = " + (num1 - num2));		
		}
		else if(ch == '*')
		{
			System.out.println(num1 + " " + ch + " " + num2 + " = " + (num1 * num2));		
		}
		else if(ch == '/')
		{
			System.out.println(num1 + " " + ch + " " + num2 + " = " + (num1 / (double)num2));		
		}
		else if(ch == '%')
		{
			System.out.println(num1 + " " + ch + " " + num2 + " = " + (num1 % num2));		
		}
		else
		{
			System.out.println(ch + "는 산술연산자가 아닙니다.");
		}
		
		scan.close();
	}

}
