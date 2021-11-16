package day15;

import java.util.Arrays;
import java.util.Scanner;

public class ExcExceptionEx1 {

	public static void main(String[] args) {
		/* 정수 5개짜리 배열에 정수를 5개 입력받아 지정한 후
		 * 원하는 번지에 정수를 수정하는 코드를 작성하세요.
		 * 예외 처리를 이용해보세요.
		 * 예시
		 * 정수를 5개 입력하세요(예 : 1 2 3 4 5) : 1 2 3 4 5
		 * 수정할 번지와 수정할 정수를 입력하세요 : 0 5
		 * 5 2 3 4 5 
		 * 수정할 번지와 수정할 정수를 입력하세요 : 6 5
		 * 잘못된 번지입니다.
		 * 수정할 번지와 수정할 정수를 입력하세요 : -1 5
		 * 프로그램을 종료합니다.
		 * */
		Scanner scan = new Scanner(System.in);
		int [] nums = new int[5];		
		int index = 0, num = 0;
		try {
			inputArray(scan, nums);
			
			do {
				try {
					System.out.print("수정할 번지와 수정할 정수를 입력하세요 : ");
					index = scan.nextInt();
					num = scan.nextInt();
					if(index >= 0) {
						nums[index] = num;
					}
					System.out.println(Arrays.toString(nums));
				}catch(ArrayIndexOutOfBoundsException e) {
					//e.printStackTrace();
					System.out.println("잘못된 번지입니다.");
				}
			}while(index >= 0);
			
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("프로그램을 종료합니다.");
		
		scan.close();
	}
	/* 기능 : Scanner를 이용하여 배열의 크기만큼 정수를 입력받아 배열에 저장하는 메소드
	 * 매개변수 : Scanner와 배열 => Scanner scan, int []nums
	 * 리턴타입 : void
	 * 메소드명 : inputArray
	 * */
	public static void inputArray(Scanner scan, int[]nums) {
		//배열이 없으면 배열이 없다고 예외를 발생
		if(nums == null) {
			throw new NullPointerException("배열이 만들어지지 않았습니다.");
		}
		if(scan == null) {
			throw new NullPointerException("스캐너가 만들어지지 않았습니다.");
		}
		System.out.print("정수를 " + nums.length + "개 입력하세요 : ");
		//배열의 크기만큼 반복하여 정수를 입력받아 저장
		for(int i = 0; i < nums.length; i++) {
			nums[i] = scan.nextInt();
		}
	}

}
