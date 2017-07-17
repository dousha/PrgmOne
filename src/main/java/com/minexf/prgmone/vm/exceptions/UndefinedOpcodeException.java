package com.minexf.prgmone.vm.exceptions;

public class UndefinedOpcodeException extends VMException {
	
	public UndefinedOpcodeException(String code)
	{
		_code = code;
	}
	
	public String what()
	{
		return "Undefined Opcode " + _code;
	}
	
	private static final long serialVersionUID = 1L;
	private final String _code;
	
}
