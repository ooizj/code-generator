package me.ooi.codegenerator;

/**
 * @author jun.zhao
 */
public class GenerateException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public GenerateException() {
		super() ; 
	}
	
	public GenerateException(String message) {
		super(message) ; 
	}
	
	public GenerateException(Throwable cause) {
		super(cause) ; 
	}
	
	public GenerateException(String message, Throwable cause) {
		super(message, cause) ; 
	}

}
