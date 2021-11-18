package day17;

public class ExbScore {
	private String subjectTitle;
	private int grade;
	private int point;
	private int term;
	
	public ExbScore(String subjectTitle, int term, int grade, int point) {
		this.subjectTitle = subjectTitle;
		this.point = point;
		this.grade = grade;
		this.term = term;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExbScore other = (ExbScore) obj;
		if (grade != other.grade)
			return false;
		if (subjectTitle == null) {
			if (other.subjectTitle != null)
				return false;
		} else if (!subjectTitle.equals(other.subjectTitle))
			return false;
		if (term != other.term)
			return false;
		return true;
	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "ExbScore [subjectTitle=" + subjectTitle + ", grade=" + grade + ", point=" + point + ", term=" + term
				+ "]";
	}
	
}
