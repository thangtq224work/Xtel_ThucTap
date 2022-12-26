package javacore.OOP;

/**
 *
 * @author thang
 */
public class Main {
	public static void main(String[] args) {
		Student student = new Student("P123", "Teo", (byte) 20, 52.7f);
		student.toString();
		student.play();
	}
}
