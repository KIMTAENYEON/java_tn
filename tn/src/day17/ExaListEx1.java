package day17;

import java.util.*;

import day16.ExbStudent;

public class ExaListEx1 {

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
		 * 4. 학생 정보 수정
		 * 5. 프로그램 종료
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
			//특정 학생 정보 수정 : 
			//이름, 성적만 수정할건지, (선택) 
			//학년, 반, 번호, 이름, 성적을 수정할건지 생각
			case 4 : 	//학생 정보 수정 기능
				if(modifyStudent(scan, stdList)) {
					System.out.println("학생 정보를 수정되었습니다.");
				}else {
					System.out.println("일치하는 학생 정보가 없습니다.");
				}
				break;
			case 5 : 
				break;
			default : 
				System.out.println("메뉴를 잘못 선택했습니다.");
			}
		}while(menu != 5);
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
	public static boolean deleteStudent(Scanner scan, ArrayList<ExbStudent> stdList) {	//학생 정보 삭제
		//삭제할 학생 정보를 입력
		System.out.println("삭제할 학생 정보를 입력하세요");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		ExbStudent std = new ExbStudent(grade, classNum, num, 0, 0, 0, "");
		return stdList.remove(std);
	}
	/* 기능 : Scanner를 이용하여 수정할 학생 정보와 성적, 이름을 입력받고,
	 * 		입력받은 학생 정보를 주어진 리스트에서 수정하여 수정 됐는지 안됐는지 알려주는 메소드
	 * 매개변수 : Scanner scan, ArrayList<ExbStudent> stdList
	 * 리턴타입 : boolean
	 * 메소드명 : modifyStudent
	 * */
	public static boolean modifyStudent(Scanner scan, ArrayList<ExbStudent> stdList) {
		//특정 학생 정보 입력
		System.out.println("학생 정보를 입력하세요.");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		
		ExbStudent std = new ExbStudent(grade, classNum, num, 0, 0, 0, "");
		int index = stdList.indexOf(std);
		//특정 학생 정보가 있으면 이름, 성적을 입력 받음
		//특정 학생 정보의 번지가 0이상이면 이름, 성적을 입력 받음
		if(index >= 0) {
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
			//학생 정보 수정
			//방법1	get()
			//리스트에서 학생 정보를 가져와서 이름과 성적만 수정
//			std = stdList.get(index);
//			std.setName(name);
//			std.setKor(kor);
//			std.setEng(eng);
//			std.setMath(math);
			//방법2	set()
			//입력받은 학생 정보와 이름, 성적을 하나의 객체로 만들어서
			//리스트에 수정하는 방법
			std = new ExbStudent(grade, classNum, num, kor, eng, math, name);
			stdList.set(index, std);
			return true;
		}
		//없으면 끝
		return false;
	}
	public static int printMenu(Scanner scan) {		//메뉴판출력
		System.out.println("--------------");
		System.out.println("[메뉴]");
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 전체 학생정보 출력");
		System.out.println("3. 학생 정보 삭제");
		System.out.println("4. 학생 정보 수정");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = scan.nextInt();
		System.out.println("--------------");
		return menu;
	}
}