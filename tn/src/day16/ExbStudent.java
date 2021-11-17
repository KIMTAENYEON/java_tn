package day16;

public class ExbStudent {
	//private으로 설정 : 외부에서 멤버변수에 직접 접근하지 못하게 하기 위해서
	private int grade, classNum, num;
	private int kor, eng, math;
	private String name;
	//생성자를 추가 : 멤버 변수를 쉽게 초기화 하기 위해서
	public ExbStudent(int grade, int classNum, int num, int kor, int eng, int math, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.name = name;
	}
	//toString을 추가 : 멤버변수를 문자열로 쉽게 확인하기 위해서
	@Override
	public String toString() {
		return "[" + name + "]" 
				+ "[" + grade + " 학년 " + classNum + " 반 " + num + "번]" 
				+ "[국어 : " + kor + ", 영어 : " + eng + ", 수학 : " + math + "]"; 
	}
	//getter와 setter 추가 : 외부에서 멤버변수의 값을 확인하거나 수정하기 위해서
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExbStudent other = (ExbStudent) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}


	
	
}