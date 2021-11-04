package day7;

import java.util.Arrays;
import java.util.Random;

public class ArrayRandomEx1 {
	//랜덤숫자 배열저장
	public static void main(String[] args) {
		/* 1~9사이의 랜덤한 수를 3개 생성하여 배열에 저장하는 코드를 작성하세요. 
		 * 3개짜리 배열을 생성
		 * 
		 * 3번 반복
		 * 		랜덤한 수를 생성
		 * 		배열에 랜덤한 수를 저장
		 * 배열을출력
		 * */
		int min = 1, max = 9;
		int []num = new int [3];
		Random r = new Random();
		for(int i = 0; i < num.length; i++)
		{
			num[i] = r.nextInt(max-min+1)+min;
		}
		System.out.println(Arrays.toString(num));
		
		
	}

}
