package day7;

public class MethodStarEx1 {
	//메소드 문자,횟수출력
	public static void main(String[] args) {
		/*  다음을 출력하는 메소드를 만들고, 호출하여 테스트해보세요.
		 *  *****
		 *  ********
		 *  -----
		 * */
		star('*', 5);
		star('*', 7);
		star('-', 5);
		
	}
	/* 기능 : 문자가 주어지면 주어진 문자를 주어진 횟수만큼 한줄에 출력하는 메소드
	 * 매개변수 : 문자, 횟수 => char ch, int count
	 * 리턴타입 : 없음 => void
	 * 메소드명 : star
	 * */

	public static void star(char ch, int count)
	{
		for(int i = 1; i <= count; i++)
		{
			System.out.print(ch);
		}
		System.out.println();
	}
	
}
