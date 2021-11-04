package day7;

public class MethodSumEx2 {
	//메소드 1~10까지 합 출력
	public static void main(String[] args) {
		/* 1부터 10까지 합을 출력하는 코드를 메소드를 이용하여 작성해보세요.
		 * */
		sumAll1();
		sumAll2(1,10);
		int begin = 1, end = 10;
		System.out.println(begin + "부터 " + end + "까지 합 : " + sumAll3(begin,end));
		int sum = sumAll3(1,10) + sumAll3(21,30);
		System.out.println("1에서 10까지의 합과 21에서 30까지의 합을 더한 값 : " + sum);
	}
	/* 기능 : 1부터 10까지 합을 출력하는 메소드(1과 10은 고정)
	 * 매개변수 : 없음
	 * 리턴타입 : void
	 * 메소드명 : sumAll1
	 * */
	public static void sumAll1()//재사용이 안좋은 메소드
	{
		int sum = 0;
		for(int i = 1; i <= 10; i++)
		{
			sum += i;
		}
		System.out.println("1부터 10까지 합 : " + sum);
	}
	/* 기능 : begin부터 end까지 합을 콘솔에 출력하는 메소드
	 * 매개변수 : 시작수와 마지막수 => int begin, int end
	 * 리턴타입 : void
	 * 메소드명 : sumAll2
	 * */
	public static void sumAll2(int begin, int end)
	{
		int sum = 0;
		for(int i = begin; i <= end; i++)
		{
			sum += i;
		}
		System.out.println(begin + "부터 " + end + "까지 합 : " + sum);
	}
	/* 기능 : begin부터 end까지 합을 콘솔에 알려주는 메소드
	 * 매개변수 : 시작수와 마지막수 => int begin, int end
	 * 리턴타입 : 누적합 => int
	 * 메소드명 : sumAll3
	 * */
	public static int sumAll3(int begin, int end)//가장좋음
	{
		int sum = 0;
		for(int i = begin; i <= end; i++)
		{
			sum += i;
		}
		return sum;
	}
}
