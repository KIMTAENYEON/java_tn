package day17;

import java.util.*;

public class ExeBaseBallEx1 {

	public static void main(String[] args) {
		/* 컬렉션 프레임워크를 이용하여 숫자 야구 게임을 구현해보세요.
		 * */
		//컴퓨터가 랜덤으로 만든 숫자 3개 생성
		//생성된 숫자를 저장할 리스트 선언 및 생성
		Scanner scan = new Scanner(System.in);
		List<Integer> com = new ArrayList<Integer>();
		List<Integer> user = new ArrayList<Integer>();
		int min = 1, max = 9;
		int count = 3;
		int strike = 0, ball = 0;
		
		try {
			createRandomList(com, min, max, count);
		}catch(Exception e) {
			System.out.println("=======================");
			System.out.println("예외 발생!! : " + e.getMessage());
			System.out.println("=======================");
			System.out.println("숫자 생성에 실패하여 게임을 할 수 없습니다.");
			return;
		}
		//반복 : 다 맞출때까지 반복 => 3스트라이크가 될 때까지
		while(strike != count) {
			//사용자가 숫자 3개를 입력
			System.out.print("입력(예 : 1 2 3) : ");
			int inputResult = inputList(user, min, max, count, scan);
			
			switch(inputResult){
			case -1 :
				System.out.println("중복된 값을 입력했습니다.");
				break;
			case 1 :
				System.out.println("잘못된 범위의 정수를 입력했습니다.");
				break;
			}
			//스트라이크 갯수 확인
			strike = getStrike(com, user);
			//볼의 갯수 확인 : 같은 숫자의 갯수 - 스트라이크 갯수
			ball = getBall(com, user);
			//판별
			printResult(strike, ball);
		}
		//프로그램 종료라고 알림
		System.out.println("프로그램 종료");
		
		scan.close();
	}
	public static void createRandomList(List<Integer> list, int min, int max, int count) {	//컴퓨터 랜덤숫자 출력
		if(list == null) {
			throw new NullPointerException("리스트가 null입니다.");
		}
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(count > max - min + 1) {
			throw new RuntimeException("범위가 리스트의 크기보다 작아서 만들 수 없습니다.");
		}
		Set<Integer> tmp = new HashSet<Integer>();
		while(tmp.size() < count) {
			int r = (int)(Math.random()*(max - min + 1) + min);
			if(tmp.add(r)) {
				list.add(r);
			}
		}
	}
	
	public static int inputList(List<Integer> list, int min, int max, int count, Scanner scan) {	//사용자 숫자 입력
		if(list == null) {
			throw new NullPointerException("리스트가 null입니다.");
		}
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(count > max - min + 1) {
			throw new RuntimeException("범위가 리스트의 크기보다 작아서 만들 수 없습니다.");
		}
		if(scan == null) {
			throw new NullPointerException("scan이 null입니다.");
		}
		list.clear();
		
		int i = 0;
		Set<Integer> userSet = new HashSet<Integer>();
		boolean isOutOfBounds = false;
		while(i < count) {
			int tmp = scan.nextInt();
			userSet.add(tmp);
			list.add(tmp);
			//isOutOfBounds = tmp >= min && tmp <= max ? isOutOfBounds : true;
			if(tmp < min || tmp > max) {
				isOutOfBounds = true;
			}
			i++;
			
		}
		if(userSet.size() != count) {
			return -1;
		}
		return isOutOfBounds ? 1 : 0;
		//0 : 제대로 입력, 1 : 범위 잘못, -1 : 중복
	}

	public static int getStrike(List<Integer> list1, List<Integer> list2) {	//스트라이크 갯수 확인
		int strike = 0;
		for(int i = 0; i < list1.size(); i++) {
			if(list1.get(i).equals(list2.get(i))) {
				strike++;
			}
		}
		return strike;
	}
	public static int getBall(List<Integer> list1, List<Integer> list2) {	//볼 갯수 확인
		int ball = 0;
		for(int i = 0; i < list1.size(); i++) {
			if(list1.contains(list2.get(i))) {
				ball++;
			}
		}
		ball = ball - getStrike(list1, list2);
		return ball;
	}
	public static void printResult(int strike, int ball) {	//판별 출력
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("3O");
		}
		System.out.println();
	}
	
}