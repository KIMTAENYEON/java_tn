package java_test1;

public class JavaTest1 {

	public static void main(String[] args) {
		HighSchoolStudent st1 = new HighSchoolStudent("그린고등학교", 1, 1, 1, "홍길동");
		st1.print();
	}
}
class HighSchoolStudent{
	private int grade, classNum, num;
	private String schoolName, name;
	
	public HighSchoolStudent(String schoolName, int grade, int classNum, int num,  String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.schoolName = schoolName;
		this.name = name;
	}		
	
	public void print () {
		System.out.println("------학생 정보------");
		System.out.println("학교 : " + schoolName);
		System.out.println("학년 : " + grade);
		System.out.println("반  : " + classNum);
		System.out.println("번호 : " + num);
		System.out.println("이름 : " + name);
		System.out.println("-------------------");
	}
}