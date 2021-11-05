package day8;

import java.util.Random;

public class MethodRandomEx1 {
	//메소드 1~10랜덤출력
	public static void main(String[] args) {
		/* 1부터 10사이의 랜덤한 수를 생성하여 코드를 작성하세요.
		 * 단 랜덤한 수를 메소드를 이용하여 생성하세요.
		 * */
		int min = 1, max = 10;
		random1();
		System.out.println("random2 : " + random2());
		random3(1,10);
		System.out.println("random4 : " + random4(min,max));
		

	}
	/* 기능 : 1부터 10사이의 랜덤한 수를 생성하여 출력하는 메소드
	 * 선생님 : "학생1에게 정수를 칠판에 적으세요."
	 * 학생 : 1에서 10사이의 정수를 칠판에 적음.
	 * 매개변수 : 없음
	 * 			선생님이 학생1에게 알려준 정보가 없음
	 * 리턴타입 : 없음 => void
	 * 			학생이 선생님에게 알려준 정보가 없음
	 * 메소드명 : random1
	 * */
	public static void random1()
	{
		int min = 1, max = 10;
		Random r = new Random();
		int num = r.nextInt(max-min+1)+min;
		System.out.println("random1 : " + num);
	}
	/* 기능 : 1부터 10사이의 랜덤한 수를 생성하여 알려주는 메소드
	 * 선생님 : "학생1, 정수를 생각해서 나에게 말해주세요."
	 * 학생 : 1에서 10사이의 정수를 선생님에게 알려줌
	 * 매개변수 : 없음
	 * 			선생님이 학생1에게 알려준 정보가 없음
	 * 리턴타입 : 정수 => int
	 * 			1에서 10사이의 정수를 선생님에게 알려줌
	 * 메소드명 : random2
	 * */
	public static int random2()
	{
		int min = 1, max = 10;
		Random r = new Random();
		int num = r.nextInt(max-min+1)+min;
		
		return num;
	}
	/* 기능 : min부터 max사이의 랜덤한 수를 생성하여 출력하는 메소드
	 * 선생님 : "학생1, 1부터 10사이의 정수를 생각해서 칠판에 적으세요"
	 * 학생 : 1에서 10사이의 정수를 칠판에 적음.
	 * 매개변수 : int min, int max
	 * 			선생님이 1과 10이라는 정보를 학생에게 알려줌.
	 * 리턴타입 : 없음 => void
	 * 메소드명 : random3
	 * */
	public static void random3(int min, int max)
	{
		Random r = new Random();
		int num = r.nextInt(max-min+1)+min;
		System.out.println("random3 : " + num);
	}
	/* 기능 : min부터 max사이의 랜덤한 수를 생성하여 알려주는 메소드
	 * 선생님 : "학생1, 1부터 10사이의 정수를 생각해서 말해주세요."
	 * 학생 : 1에서 10사이의 정수를 말함.
	 * 매개변수 : int min, int max
	 * 			선생님이 1과 10이라는 정보를 학생에게 알려줌.
	 * 리턴타입 : int
	 * 			학생이 생각한 정수를 선생님에게 말해줘야함.
	 * 메소드명 : random4
	 * */
	public static int random4(int min, int max)
	{
		Random r = new Random();
		int num = r.nextInt(max-min+1)+min;
		return num;
		//return r.nextInt(max-min+1)+min;
	}
	

}
