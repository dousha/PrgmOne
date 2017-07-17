package com.minexf.prgmone.vm.exceptions;

public class BadSyntaxException extends VMException {
	private static final long serialVersionUID = 1L;
	
	public BadSyntaxException(String reason)
	{
		_reason = reason;
	}
	
	public String what()
	{
		return "Syntax error: " 
				+ _reason;
	}
	
	private final String _reason;
}
