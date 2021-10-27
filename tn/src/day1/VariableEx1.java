package day1;

public class VariableEx1 {

	public static void main(String[] args) {
		// 한줄 주석
		/* 여러줄
		 * 주석
		 * */
		char score1;
		char score2 = 'F';
		int age1;
		int age2 = 1;
		double avg1;
		double avg2 = 0.0;
		float avg3 = 0.0f;
		boolean isAdult1;
		boolean isAdult2 = true;//true : 참, false : 거짓
		int num = 1000;
		score1 = 'A';
		//System.out.println(isAdult);//에러 발생 : 변수 초기화를 하지 않아서
		int num2 = 0x11;
		System.out.println("num2 = " + num2);
		int num3 = 011;
		System.out.println("num3 = " + num3);
		int num4 = 0b11;
		System.out.println("num4 = " + num4);

	}

}
