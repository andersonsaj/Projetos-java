package exceptions;

import java.io.IOException;

public class ExceptionB extends ExceptionA{
	private static final long serialVersionUID = 1L;
	
	public ExceptionB(String string) throws IOException{
		super(string);
		throw new IOException("erro");
	}
}
