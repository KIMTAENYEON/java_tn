package day9;

public class ClassEx5 {
	//클래스 사용이유
	public static void main(String[] args) {
		/* 학생 1명의 정보를 관리하는 예제 : 클래스 사용 x
		 * */
		int size = 5;
		String sName[] = new String[size], name [] = new String[size];
		int grade[] = new int[size], classNum[] = new int [size], num[] = new int [size];

		/* 학생 1명의 정보를 관리하는 예제 : 클래스 사용 HighSchoolStudent
		 * */
		HighSchoolStudent std[] = new HighSchoolStudent[size];
	}

}
