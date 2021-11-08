package day9;

public class ClassEx3 {
	//클래스 학생정보
	public static void main(String[] args) {
		//고등학교 학생 정보를 관리하기 위한 클래스를 생성하고, 테스트해보세요.
		//그린고등학교에 다니는 1학년 1반 1번 홍길동 학생 객체를 생성하고, 학생정보를 출력해보세요.
		HighSchoolStudent std1 = new HighSchoolStudent(1,1,1,"그린고등학교","홍길동");
		std1.printInfo();
	}

}
/* 클래스 : 고등학교 학생 정보를 관리하기 위한 클래스
 * 클래스명 : HighSchoolStudent
 * 멤버변수 : 학교명, 학년, 반, 번호, 이름 등
 * 멤버메소드 : 
 * 	- 정보 출력 기능
 * */
class HighSchoolStudent{
	int grade, classNum, num;
	String schoolName, name;
	
	HighSchoolStudent() {
		/*schoolName = "고등학교";
		name = "";
		grade = 1; classNum = 1; num = 1;
		*/
		this(1,1,1,"고등학교","");
		System.out.println("this()");
		
	}
	HighSchoolStudent(int grade, int classNum, int num, String schoolName, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.schoolName = schoolName;
		this.name = name;
		
	}
	void printInfo() {
		System.out.println("학교명 : " + schoolName);
		System.out.println("이름 : " + name);
		System.out.println("학년 : " + grade);
		System.out.println("반 : " + classNum);
		System.out.println("번호 : " + num);
	}
}