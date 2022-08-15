package exceptions;

public class ExceptionA extends Exception{

	private static final long serialVersionUID = 1L;

	public ExceptionA(String string) {
		super(string);
		throw new NullPointerException();
	}

}
