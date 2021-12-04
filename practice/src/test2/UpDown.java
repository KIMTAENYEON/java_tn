package test2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpDown {

	public static void main(String[] args) {
		/* 랜덤으로 숫자를 만든 후 만들어진 숫자를 맞추는 게임
			- 숫자 범위는 1~100사이
			- 예시(랜덤으로 만들어진 수 49)
		 * */
		Scanner scan = new Scanner(System.in);
		int min = 1, max = 100;
		int randomNum;
		//랜덤 숫자 생성 	
		randomNum = randomNum(min, max);
		//정수 입력, 결과
		inputNum(scan, randomNum);
		//프로그램 종료
		System.out.println("프로그램을 종료합니다.");
		
	}
	public static int randomNum(int min, int max) {	//랜덤수 생성 
		if(min > max) {	// 최대값과 최소값을 반대로 입력하면 맞춰줌
			int tmp = min;
			min = max;
			max = tmp;
		}
		int randomNum = (int)(Math.random() * (max - min + 1) + min);
		return randomNum;
	}
	public static void inputNum(Scanner scan, int randomNum) {	//정수 입력 (반복), 결과 출력
		int num;
		do {
			num = 0;
			System.out.print("정수 : ");
			try {
				num = scan.nextInt();
				//결과 
				check(randomNum, num);
			}catch(InputMismatchException e) {
				System.out.println("잘못 입력했습니다.");
			}catch(Exception e) {
				System.out.println("예외발생");
			}
			scan.nextLine();
		}while(num != randomNum);
	}
	public static void check(int randomNum, int num) {	//정답 판별	
		System.out.println("==============");
		if(num > randomNum) {
			System.out.println("down");
		}else if(num < randomNum) {
			System.out.println("up");
		}else if(num == randomNum) {
			System.out.println("정답입니다.");
		}
		System.out.println("==============");
	}
}
