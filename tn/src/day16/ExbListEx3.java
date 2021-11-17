package day16;

import java.util.*;

public class ExbListEx3 {

	public static void main(String[] args) {
		/* 그린고등학생의 국어, 영어, 수학 성적을 관리하려 한다.
		 * 관리하기 위한 리스트를 만들어 보세요.
		/* 국어, 영어, 수학 성적을 같이 다룰 수 있는 클래스를 만들어서 활용하는 방법
		 * */
		ArrayList<ExbStudent> stdList = new ArrayList<ExbStudent>();
		Scanner scan = new Scanner(System.in);

		/* 학생 성적을 관리하는 프로그램을 만들어 보세요.
		 * 메뉴
		 * 1. 학생 정보 추가
		 * 2. 전체 학생정보 출력
		 * 3. 학생 정보 삭제(삭제할 학생의 정보를 입력하여 일치하는 학생의 정보를 삭제)
		 * 4. 프로그램 종료
		 * Object 클래스의 equals()와 리스트의 remove()를 이용
		 * */
		int menu = 0;
		do {
			menu = printMenu(scan);
			switch(menu) {
			case 1 :	//학생 정보 추가 기능
				char next = 'y';
				while(next == 'y' || next == 'Y') {
					inputStudent(scan, stdList);
					
					System.out.print("학생 정보를 더 입력하겠습니까? ");
					next = scan.next().charAt(0);
				}
				break;
			case 2 :	//학생 정보 출력 기능
				printStudentList(stdList);
				break;
			case 3 :	//학생 정보 삭제 기능
				if(deleteStudent(scan, stdList)) {
					System.out.println("학생 정보를 삭제했습니다.");
				}else {
					System.out.println("일치하는 학생 정보가 없습니다.");
				}
				break;
			case 4 : 
				break;
			default : 
				System.out.println("메뉴를 잘못 선택했습니다.");
			}
		}while(menu != 4);
		System.out.println("프로그램을 종료합니다.");
		
		scan.close();
	}
	public static ExbStudent inputStudent(Scanner scan) {	//학생 정보 저장
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
	/* 기능 : 주어진 리스트에 Scanner를 통해 입력받은 학생정보를 삭제하여 삭제됐는지 알려주는 메소드
	 * 매개변수 : Scanner scan, ArrayList<ExbStudent> stdList
	 * 리턴타입 : boolean
	 * 메소드명 : deleteStudent
	 * */
	public static boolean deleteStudent(Scanner scan, ArrayList<ExbStudent> stdList) {
		//삭제할 학생 정보를 입력
		System.out.println("삭제할 학생 정보를 입력하세요");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		//방법1
		//삭제할 학생 정보가 몇번지에 있는지 확인하는 작업을 위해 
		//ExbStudent클래스의 equals를 오버라이딩 해야함
		//있으면 해당 번지에 있는 학생 정보를 삭제
		//리스트에 특정 객체가 있는지 확인할 때 사용하는 메소드 : contains, indexOf
		ExbStudent std = new ExbStudent(grade, classNum, num, 0, 0, 0, "");
//		int index = stdList.indexOf(std);
//		//있으면 해당 번지에 있는 학생 정보를 삭제
//		if(index >= 0) {
//			stdList.remove(index);
//			//System.out.println("학생 정보를 삭제했습니다.");
			//return true;
//		}else {
//			//System.out.println("일치하는 학생 정보가 없습니다.");
			//return false;
//		}
		//방법2
		//학생 정보를 삭제했을 때 해당 학생 정보가 있으면 삭제되었습니다.
		//없으면 삭제할 학생 정보가 없습니다를 출력
		return stdList.remove(std);
	}
	
	public static int printMenu(Scanner scan) {		//메뉴판출력
		System.out.println("--------------");
		System.out.println("[메뉴]");
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 전체 학생정보 출력");
		System.out.println("3. 학생 정보 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = scan.nextInt();
		System.out.println("--------------");
		return menu;
	}
}