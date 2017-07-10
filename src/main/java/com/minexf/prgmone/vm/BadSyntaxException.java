package com.minexf.prgmone.vm;

public class BadSyntaxException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public BadSyntaxException(String code, int line, String reason)
	{
		_code = code;
		_line = line;
		_reason = reason;
	}
	
	public String what()
	{
		return "At line: " 
				+ String.valueOf(_line) 
				+ ": Syntax error: " 
				+ _code 
				+ " : " 
				+ _reason;
	}
	
	private final String _code, _reason;
	private final int _line;
}
