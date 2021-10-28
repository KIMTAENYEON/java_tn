package day2;

public class IfNumEx1 {
	//if else if문
	public static void main(String[] args) {
		/* (num가 0보다 크)면 [양수라고 출력]하고 
		 * (num가 0이)면 [0이라고 출력]하고
		 * (num가 0보다 작으)면 [음수라고 출력]하는 코드를 작성하세요.
		 * */
		int num = -1;
		if(num > 0) 
		{
			System.out.println(num + " = 양수");
		}
		else if(num == 0)
		{
			System.out.println(num);
		}
		else
		{
			System.out.println(num + " = 음수");
		}
		

	}
	//정수가 0보다 크지않고, 정수가 0과 같지 않은 수 = 음수
}
