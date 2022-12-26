package javacore.OOP;

/**
 *
 * @author thang
 */

public class Student extends Person implements Work, Play {

	private String studentCode;
	private innerStudent student;

	public Student(String studentCode, String name, Byte age, Float weight) {
		super(name, age, weight);
		this.studentCode = studentCode;
		student = new innerStudent();
	}

	public Student() {
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	@Override
	public void work() {
		System.out.println("Student do homework");
	}

	// Overloading
	public void infor() {
		System.out.println("I am student");
	}

	public void infor(String major) {
		System.out.printf("I am student %s", major);
	}

	@Override
	public void play() {
		System.out.printf("The student is playing game");
	}

	@Override
	public String toString() {
		return "Student{" + "studentCode=" + studentCode + ", student=" + student + '}';
	}

	class innerStudent {

		public void print() {
			System.out.println("Inner class ");
		}
	}
}
