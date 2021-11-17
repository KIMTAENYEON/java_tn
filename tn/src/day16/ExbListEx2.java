package day16;

import java.util.*;

public class ExbListEx2 {

	public static void main(String[] args) {
		/* 그린고등학생의 국어, 영어, 수학 성적을 관리하려 한다.
		 * 관리하기 위한 리스트를 만들어 보세요.
		/* 국어, 영어, 수학 성적을 같이 다룰 수 있는 클래스를 만들어서 활용하는 방법
		 * */
		ArrayList<ExbStudent> stdList = new ArrayList<ExbStudent>();
		Scanner scan = new Scanner(System.in);

		/* 학생 성적을 관리하는 프로그램을 만들어 보세요.
		 * 메뉴
		 * 1. 학생정보 추가
		 * 2. 전체 학생정보 출력
		 * 3. 프로그램 종료
		 * */
		int menu = 0;
		do {
			menu = printMenu(scan);
			switch(menu) {
			case 1 :
				char next = 'y';
				while(next == 'y' || next == 'Y') {
					inputStudent(scan, stdList);
					
					System.out.print("학생 정보를 더 입력하겠습니까? ");
					next = scan.next().charAt(0);
				}
				break;
			case 2 :
				printStudentList(stdList);
				break;
			case 3 : 
				break;
			default : 
				System.out.println("메뉴를 잘못 선택했습니다.");
			}
		}while(menu != 3);
		System.out.println("프로그램을 종료합니다.");
		
		scan.close();
	}
	public static ExbStudent inputStudent(Scanner scan) {	//학생정보 저장
		ExbStudent std;
		System.out.println("학생 정보를 입력하세요.");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.println("성적을 입력하세요.");
		System.out.print("국어 : ");
		int kor = scan.nextInt();
		System.out.print("영어 : ");
		int eng = scan.nextInt();
		System.out.print("수학 : ");
		int math = scan.nextInt();
		std = new ExbStudent(grade, classNum, num, kor, eng, math, name);
		
		return std;
	}
	public static void inputStudent(Scanner scan, ArrayList<ExbStudent> stdList) {	//학생정보 리스트에저장
		ExbStudent std = inputStudent(scan);
		stdList.add(std);
		
	}
	public static void printStudentList(ArrayList<ExbStudent> stdList) {	//출력
		Iterator<ExbStudent> it = stdList.iterator();
		while(it.hasNext()) {
			//리스트에서 하나씩 꺼내서 tmp에 저장
			ExbStudent tmp = it.next();
			System.out.println(tmp);
		}
	}
	public static int printMenu(Scanner scan) {		//메뉴판출력
		System.out.println("--------------");
		System.out.println("[메뉴]");
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 전체 학생정보 출력");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = scan.nextInt();
		System.out.println("--------------");
		return menu;
	}
}