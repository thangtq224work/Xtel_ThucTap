package javacore.exception;

/**
 *
 * @author thang
 */
public class CustomException extends Exception {
	private String name;

	public CustomException(String name) {
		super("Exception : " + name);
		this.name = name;
	}

}
