
public class Student {

	private int studentIdNumber;
	private String studentFirstName;
	private String studentLastName;
	private int mathGrade;
	private int scienceGrade;
	private int historyGrade;

	public Student() {

	}

	public Student(int studentIdNumber, String studentFirstName, String studentLastName, int mathGrade,
			int scienceGrade, int historyGrade) {

		this.studentIdNumber = studentIdNumber;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.mathGrade = mathGrade;
		this.scienceGrade = scienceGrade;
		this.historyGrade = historyGrade;
	}

	public int getStudentIdNumber() {
		return studentIdNumber;
	}

	public void setStudentIdNumber(int studentIdNumber) {
		this.studentIdNumber = studentIdNumber;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public int getMathGrade() {
		return mathGrade;
	}

	public void setMathGrade(int mathGrade) {
		this.mathGrade = mathGrade;
	}

	public int getScienceGrade() {
		return scienceGrade;
	}

	public void setScienceGrade(int scienceGrade) {
		this.scienceGrade = scienceGrade;
	}

	public int getHistoryGrade() {
		return historyGrade;
	}

	public void setHistoryGrade(int historyGrade) {
		this.historyGrade = historyGrade;
	}

	@Override
	public String toString() {
		return "Student [studentIdNumber=" + studentIdNumber + ", studentFirstName=" + studentFirstName
				+ ", studentLastName=" + studentLastName + ", mathGrade=" + mathGrade + ", scienceGrade=" + scienceGrade
				+ ", historyGrade=" + historyGrade + ", hashCode=" + hashCode() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + historyGrade;
		result = prime * result + mathGrade;
		result = prime * result + scienceGrade;
		result = prime * result + ((studentFirstName == null) ? 0 : studentFirstName.hashCode());
		result = prime * result + studentIdNumber;
		result = prime * result + ((studentLastName == null) ? 0 : studentLastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (historyGrade != other.historyGrade)
			return false;
		if (mathGrade != other.mathGrade)
			return false;
		if (scienceGrade != other.scienceGrade)
			return false;
		if (studentFirstName == null) {
			if (other.studentFirstName != null)
				return false;
		} else if (!studentFirstName.equals(other.studentFirstName))
			return false;
		if (studentIdNumber != other.studentIdNumber)
			return false;
		if (studentLastName == null) {
			if (other.studentLastName != null)
				return false;
		} else if (!studentLastName.equals(other.studentLastName))
			return false;
		return true;
	}

}
