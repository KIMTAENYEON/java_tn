package day8;

import java.util.Arrays;
import java.util.Scanner;

public class LottoEx1 {
	//로또 등수 확인
	public static void main(String[] args) {
		/* 1~45사이의 중복되지 않은 6개의 로또 번호와 1개의 보너스번호를 생성
		 * 
		 * */
		int min = 1, max = 45, size = 6;
		int [] lotto = randomArray(min, max, size);	
		int [] user = new int [size];
		int bonus = createBonus(min,max,lotto);
		//당첨번호와 중복되지 않게 보너스 번호를 랜덤으로 생성하여 저장
		
		//당첨번호 출력
		System.out.println("당첨번호 : " + Arrays.toString(lotto));
		//보너스 번호 출력
		System.out.println("보너스 번호 : " + createBonus(min,max,lotto));
		//사용자가 1~45사이의 숫자 6개를 중복되지 않게 콘솔에서 입력(메소드x)
		Scanner scan = new Scanner(System.in);
		System.out.print("선택번호 : ");
		for(int i = 0; i < user.length; i ++)
		{
			user[i] = scan.nextInt();
		}
		System.out.println("입력번호 : " + Arrays.toString(user));
		//등수를 출력
		/* 1등 : 당첨번호 6개 전부 일치
		 * 2등 : 당첨번호 5개와 보너스 번호 일치
		 * 3등 : 당첨번호 5개 일치
		 * 4등 : 당첨번호 4개 일치
		 * 5등 : 당첨번호 3개 일치
		 * 꽝 : 나머지 
		 * */
		rank(lotto, bonus, user);
		
		scan.close();
	}
	public static boolean containArray(int [] arr , int num, int n)//0번지 부터 n번지까지 비교확인
	{
		//배열의 길이보다 검사하는 갯수가 많으면 검사 갯수를 배열의 길이로, 아니면 원래 검사 갯수로 변경
		n = arr.length < n ? arr.length : n;
		for(int i = 0; i < n; i++)
		{
			if(arr[i] == num)
			{
				return true;
			}
		}
		return false;
	}
	public static int[] randomArray(int min, int max, int size)//(size-1)번지까지 중복되지않는 배열 생성
	{
		int []arr = new int[size];
		for(int count = 0; count < size; )
		{
			int random = (int)(Math.random()*(max-min+1)+min);
			//random과 배열을 비교하여 중복된 숫자가 없으면
			if(!containArray(arr,random,count))
			{
				arr[count++] = random;
			}
		}
		return arr;
	}
	public static int createBonus(int min, int max, int [] arr)//보너스번호추출메소드
	{
		int bonus = 0;
		for( ; ; )
		{
			bonus = (int)(Math.random()*(max-min+1)+min);
			//당첨번호에 보너스번호가 있으면 조건식으로 이동
			if(containArray(arr,bonus,arr.length))
			{
				continue;	
			}
			return bonus;
		}	
	}
	/* 기능 : 두 배열이 주어지면, 두 배열에서 일치하는 정수의 갯수를 알려주는 메소드
	 * 매개변수 : 두 배열 => int []arr1, int [] arr2
	 * 리턴타입 : 일치하는 정수의 갯수 => int
	 * 메소드명 : check
	 * */
	public static int check(int []arr1, int[]arr2)//맞은 갯수 확인
	{
		int count = 0;
		for(int tmp : arr1)
		{
			//배열 arr2에 배열 arr1에서 꺼낸 tmp가 있으면 count를 증가
			if(containArray(arr2, tmp, arr2.length))
			{
				count++;
			}
		}
		return count;
	}
	/* 기능 : 로또번호와 사용자번호를 이용하여 당첨등수를 출력하는 메소드
	 * 매개변수 : 로또번호와 보너스번호, 사용자번호
	 * 			=> int[]lotto, int bonus, int[]user
	 * 리턴타입 : void
	 * 메소드명 : rank
	 * */
	public static void rank(int []lotto, int bonus, int[]user)//등수 확인
	{
		int count = check(lotto,user);
		String result ;
		switch(count)
		{
		case 6 : result = "1등 당첨!!";
			break;
		case 5 : result = containArray(user, bonus, user.length) ? "2등 당첨!!" : "3등 당첨";
			break;
		case 4 : result = "4등 당첨!!";
			break;
		case 3 : result = "5등 당첨!!";
			break;
		default: result = "꽝";
		}
		System.out.println(result);
	}
}
