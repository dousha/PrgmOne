package com.minexf.prgmone.vm.exceptions;

public class RegisterNotFoundException extends VMException {
	
	public RegisterNotFoundException(String name)
	{
		_name = name;
	}
	
	public String what()
	{
		return "Register not found : " + _name;
	}
	
	private final String _name;
	private static final long serialVersionUID = 194520124185514266L;
}
