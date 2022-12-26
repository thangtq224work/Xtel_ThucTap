package javacore.exception;

/**
 *
 * @author thang
 */
public class Main {
	public static void main(String[] args) {
		try {
			throw new RuntimeException();
		} catch (IndexOutOfBoundsException e) {
			// xu lý
			System.out.println("IndexOutOfBoundsException");
		} catch (RuntimeException rt) {
			// xu lý
			System.out.println("RuntimeException");
		} catch (Exception io) {
			// xu lý
			System.out.println("Exception");
		}
		// xu ly ngoai le chuyen tiep
		try {
			new ThrowException().method2();
		} catch (Exception e) {
			// xu lý
			System.out.println("can not divide 0");
		}
	}
}
