package day17;

import java.util.*;

public class ExaLottoEx1 {

	public static void main(String[] args) {
		/* 로또 프로그램을 day17 패키지의 야구 게임을 활용하여 만드세요.
		 * */
		List<Integer> lotto = new ArrayList<Integer>();
		List<Integer> user = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int min = 1, max = 45, count = 6, total = 0, bonus = 0;
		char ch = 'y';
		//1~45까지 랜덤한 수 6개 출력(중복x)
		ExeBaseBallEx1.createRandomList(lotto, min, max, count);
		Collections.sort(lotto);
		System.out.println("당첨 번호 : " + lotto);
		
		//보너스번호 출력 (6개숫자와 중복x)
		while(true) {
			bonus = (int)(Math.random() * (max - min + 1) + min);
			if(!lotto.contains(bonus)) {
				break;
			}
		}
		System.out.println("보너스 번호 : " + bonus);
		//1~45까지 랜덤한 수 6개 입력
		while(ch == 'y' || ch == 'Y') {
			System.out.print("6개 입력 : ");
			int inputResult = ExeBaseBallEx1.inputList(user, min, max, count, scan);
			switch(inputResult){
			case -1 :
				System.out.println("중복된 값을 입력했습니다.");
				break;
			case 1 :
				System.out.println("잘못된 범위의 정수를 입력했습니다.");
				break;
			}
		//맞은 갯수 확인
			total = ExeBaseBallEx1.getBall(lotto, user) + ExeBaseBallEx1.getStrike(lotto, user);
			//등수 확인
			switch(total) {
			case 6:
				System.out.println("1등 당첨");
				break;
			case 5:
				if(user.contains(bonus)) {
					System.out.println("2등 당첨");
				}else {
					System.out.println("3등 당첨");
				}
				break;
			case 4:
				System.out.println("4등 당첨");
				break;
			case 3:
				System.out.println("5등 당첨");
				break;
			default:
				System.out.println("꽝");
			}
			//더 할건지 말건지 물어보는 코드
			System.out.print("더 하시겠습니까?(y/n) : ");
			ch = scan.next().charAt(0);
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
