package com.minexf.prgmone.vm.exceptions;

public class BadDeviceOperationException extends VMException {
	
	public BadDeviceOperationException(String reason)
	{
		_reason = reason;
	}
	
	@Override
	public String what() {
		return "Bad device operation: " + _reason;
	}
	
	private final String _reason;
	private static final long serialVersionUID = 7580118040950208035L;
}
