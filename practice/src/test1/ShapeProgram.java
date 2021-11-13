package test1;

import java.util.Scanner;

public class ShapeProgram {

	public static void main(String[] args) {
		/*day12일차에서 만든 ExaShape, ExaEllipse, ExaRect를 이용하여 
		 * 도형을 그리는 프로그램을 만들어보세요.
		 */
		Scanner scan = new Scanner(System.in);
		Shape list = new Shape(10);
		int menu = 0;
		do {
			//메뉴를 입력
			menu = printMenu(scan);
			//입력받은 메뉴에 따른 기능 실행 
			switch(menu) {
			case 1: 
				list.draw();	//도형그리기
				break;
			case 2: 
				list.rewind();	//다시실행	
				break;
			case 3: 
				list.cancel();	//실행취소
				break;
			case 4: 
				list.check();	//도형확인
				break;
			case 5: 
				break;
			default:
				System.out.println("메뉴를 잘못 선택했습니다.");
			}
		}while(menu != 5);//5번 메뉴를 선택하면 반복문 종료
		System.out.println("프로그램을 종료합니다.");
	}
	public static int printMenu(Scanner scan) {	//메뉴판 출력메소드
		System.out.println("--------------");
		System.out.println("[메뉴]");
		System.out.println("1. 도형그리기");
		System.out.println("2. 다시실행");
		System.out.println("3. 실행취소");
		System.out.println("4. 도형확인");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = scan.nextInt();
		System.out.println("--------------");
		return menu;
	}
}
