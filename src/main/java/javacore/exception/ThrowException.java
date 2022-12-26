package javacore.exception;

import java.io.IOException;

/**
 *
 * @author thang
 */
public class ThrowException {

	public void method1() throws IOException {
		try {
			int i = 1 / 0;
		} catch (Exception e) {
			throw new IOException();
		}
	}

	// chuyen tiep ngoai le
	public void method2() throws ArithmeticException {
		int i = 1 / 0;
	}

	public void method3() {
		try {
			throw new IOException();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
