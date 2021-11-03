package day6;

import java.util.Scanner;

public class ArrayScoreAverageEx1 {
	//5명의 성적평균
	public static void main(String[] args) {
		/* 배열을 이용하여 5명의 학생의 국어 성적을 입력받아 평균을 구하는 코드를 작성하세요.
		 * 단 성적을 배열에 저장해야 하고, 성적은 정수입니다.
		 * */
		//5개짜리 정수형 배열을 생성
		//배열에 성적을 입력
		//배열의 합을 구함
		//합을 이용하여 평균을 구한 후 출력
		Scanner scan = new Scanner(System.in);
		int [] score = new int[5];
		int i;
		int sum = 0;
		for(i = 0; i < 5; i++)
		{
			System.out.print("학생" + (i + 1) + "의 성적을 입력하세요 : ");
			score[i] = scan.nextInt();
			sum += score[i];
		}
		double ave = sum / 5.0;
		System.out.println("평균은 " + ave + "점입니다.");
		
		scan.close();
	}

}
