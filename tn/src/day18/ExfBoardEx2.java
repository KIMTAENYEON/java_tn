package day18;

import java.util.*;

public class ExfBoardEx2 {

	public static void main(String[] args) {
		/* 게시글을 관리하는 프로그램을 만드세요.
		 * 배열x, 리스트o
		 * 기능
		 * 1. 게시글 등록
		 * 2. 게시글 확인 (전체)
		 * 3. 게시글 수정
		 * 4. 게시글 삭제
		 * 5. 프로그램 종료
		 * */
		//게시글 리스트 생성
		Scanner scan = new Scanner(System.in);
		List<ExfBoard> boardList = new ArrayList<ExfBoard>();
		String[] strMenu = {
				"1. 게시글 등록",
				"2. 게시글 조회",
				"3. 게시글 수정",
				"4. 게시글 삭제",
				"5. 프로그램 종료"
		};
		int menu = 0;
		//프로그램 시작
		do{
			//메뉴 출력
			printMenu(strMenu);
			try {
				//메뉴 입력
				menu = scan.nextInt();
				bar();
				//메뉴에 따른 기능 실행
				switch(menu) {
				case 1:	//게시글 등록
					register(boardList, scan);
					break;
				case 2:	//게시글 조회
					display(boardList);
					break;
				case 3:	//게시글 수정
					modify(boardList, scan);
					break;
				case 4:	//게시글 삭제
					delete(boardList, scan);
					break;
				case 5:	//프로그램 종료
					System.out.println("프로그램을 종료합니다.");
					bar();
					break;
				default :
					System.out.println("메뉴를 잘못 입력했습니다.");
				}
			}catch(InputMismatchException e) {
				System.out.println("예외 발생!! 잘못 입력했습니다.");
				bar();
				scan.nextLine();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}while(menu != 5);
	}
	public static void printMenu(String[] strMenu) {	//메뉴판 출력
		bar();
		System.out.println("[메뉴]");
		for(String tmp : strMenu) {
			System.out.println(tmp);
		}
		bar();
		System.out.print("메뉴를 선택하세요 (1~5) : ");
	}
	public static void bar() {
		System.out.println("============");
	}
	public static void register(List<ExfBoard> boardList, Scanner scan) {	//게시글 등록 기능
		System.out.println("===게시글 등록===");
		scan.nextLine();
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String contents = scan.nextLine();
		System.out.print("작성자 : ");
		String writer = scan.nextLine();
		ExfBoard board = new ExfBoard(title, contents, writer);
		boardList.add(board);
		System.out.println("게시글이 등록되었습니다.");
		bar();
	}
	public static void display(List<ExfBoard> boardList){	//게시글 조회 기능
		for(ExfBoard tmp : boardList) {
			bar();
			System.out.println(tmp);
			bar();
		}
	}
	public static void modify(List<ExfBoard> boardList, Scanner scan) {	//게시글 수정 기능
		System.out.println("게시글을 수정합니다.");
		System.out.print("번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String contents = scan.nextLine();
		ExfBoard tmp = new ExfBoard();
		tmp.setNum(num);
		int index = boardList.indexOf(tmp);
		if(index >= 0) {
			boardList.get(index).modify(title, contents);
			System.out.println("게시글 수정이 완료되었습니다.");
			bar();
		}
		else {
			System.out.println("없는 게시글입니다.");
			bar();
		}
	}
	public static void delete(List<ExfBoard> boardList, Scanner scan) {	//게시글 삭제 기능
		System.out.print("삭제할 게시글 번호를 입력하세요 : ");
		int num = scan.nextInt();
		ExfBoard tmp2 = new ExfBoard();
		tmp2.setNum(num);
		int index2 = boardList.indexOf(tmp2);
		if(index2 >= 0) {
			boardList.remove(index2);
			System.out.println("게시글이 삭제되었습니다.");
			bar();
		}
		else {
			System.out.println("해당 게시글이 없습니다.");
			bar();
		}
	}
	
}
