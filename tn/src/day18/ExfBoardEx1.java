package day18;

import java.util.*;

public class ExfBoardEx1 {

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
		int menu = 0;
		//프로그램 시작
		do{
			//메뉴 출력
			menu = printMenu(scan);
			//메뉴 입력
			//메뉴에 따른 기능 실행
			switch(menu) {
			case 1:
				System.out.println("===게시글 등록===");
				//게시글 정보 입력 : 제목, 내용, 작성자
				scan.nextLine();
				System.out.print("제목 : ");
				String title = scan.nextLine();
				System.out.print("내용 : ");
				String contents = scan.nextLine();
				System.out.print("작성자 : ");
				String writer = scan.nextLine();
				//입력한 정보를 이용하여 게시글 하나 생성
				ExfBoard board = new ExfBoard(title, contents, writer);
				//생성된 게시글을 리스트에 추가
				boardList.add(board);
				System.out.println("게시글이 등록되었습니다.");
				System.out.println("============");
				break;
			case 2:
				for(ExfBoard tmp : boardList) {
					System.out.println("============");
					System.out.println(tmp);
					System.out.println("============");
				}
				break;
			case 3:
				//수정할 게시글 정보를 입력
				System.out.println("게시글을 수정합니다.");
				System.out.print("번호 : ");
				int num = scan.nextInt();
				scan.nextLine();
				System.out.print("제목 : ");
				title = scan.nextLine();
				System.out.print("내용 : ");
				contents = scan.nextLine();
				//리스트에서 수정할 게시글 정보를 가져옴
				ExfBoard tmp = new ExfBoard();
				tmp.setNum(num);
				int index = boardList.indexOf(tmp);
				//수정할 게시글이 있으면 수정 후 안내문구 출력
				if(index >= 0) {
					boardList.get(index).modify(title, contents);
					System.out.println("게시글 수정이 완료되었습니다.");
					System.out.println("============");
				}
				//없으면 없다고 안내문구 출력
				else {
					System.out.println("없는 게시글입니다.");
					System.out.println("============");
				}
				break;
			case 4:
				//게시글 번호를 입력
				System.out.print("삭제할 게시글 번호를 입력하세요 : ");
				num = scan.nextInt();
				//리스트에 해당 게시글이 있는지 확인
				ExfBoard tmp2 = new ExfBoard();
				tmp2.setNum(num);
				int index2 = boardList.indexOf(tmp2);
				
				//리스트에 게시글이 있으면 삭제 후 삭제되었습니다라고 안내문구
				if(index2 >= 0) {
					boardList.remove(index2);
					System.out.println("게시글이 삭제되었습니다.");
					System.out.println("============");
				}
				//리스트에 게시글이 없으면 해당 게시글이 없습니다라고 안내문구
				else {
					System.out.println("해당 게시글이 없습니다.");
					System.out.println("============");
				}
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				System.out.println("============");
				break;
			default :
				System.out.println("메뉴를 잘못 입력했습니다.");
			}
		}while(menu != 5);
		//프로그램 종료
	}
	public static int printMenu(Scanner scan) {	//메뉴판 출력
		System.out.println("============");
		System.out.println("[메뉴]");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 조회");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 게시글 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 (1~5) : ");
		int menu = scan.nextInt();
		System.out.println("============");
		return menu;
	}

}
