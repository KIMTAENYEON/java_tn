package day7;

public class MethodPrimeNumEx1 {
	//메소드 소수판별
	public static void main(String[] args) {
		/* 주어진 정수가 소수인지 아닌지 판별하는 메소드를 만들고 호출하여 확인하세요.
		 * */
		int num = 2;
		if(prime(num))
		{
			System.out.println(num + " = 소수");
		}
		else
		{
			System.out.println(num + " = 소수가 아님");
		}
		
		System.out.println(num + " = " + prime2(num));
		
	}
	/* 기능 : 주어진 정수가 소수이면 참, 아니면 거짓으로 알려주는 메소드
	 * 매개변수 : 주어진 정수 => int num
	 * 리턴타입 : boolean
	 * 메소드명 : prime
	 * 
	 * */
	public static boolean prime(int num)
	{
		int count = 0;
		if(num <= 0)
		{
			return false;
		}
		for(int i = 1; i <= num; i++)
		{
			if(num % i == 0)
			{
				count++;
			}
		}
		boolean prime = count == 2 ? true : false;
		return prime;
	}
	/* 기능 : 주어진 정수가 소수인지 아닌지 판별해서 알려주는 메소드
	 * 매개변수 : 주어진 정수 => int num
	 * 리턴타입 : String
	 * 메소드명 : prime2
	 * 
	 * */
	public static String prime2(int num)
	{
		int i;
		int count = 0;
		for(i = 1; i <= num; i++)
		{
			if(num % i == 0)
			{
				count++;
			}
		}
		String str = count == 2 ? "소수" : "소수가 아님";
		return str;
	}
	/* 기능 : 고속버스 티켓을 예매
	 * 필요한 것 : 출발지, 도착지, 시간, 좌석번호
	 * 결과 : 예매 내역
	 * */
	
}
