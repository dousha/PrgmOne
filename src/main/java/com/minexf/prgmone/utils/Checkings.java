package com.minexf.prgmone.utils;

import com.minexf.prgmone.vm.NotationType;
import com.minexf.prgmone.vm.exceptions.BadSyntaxException;

public class Checkings {

	public static void ParameterCount(String[] params, int count) throws BadSyntaxException
	{
		if(params.length != count) 
			throw new BadSyntaxException("Argument count mismatch: requires "
											+ String.valueOf(count)
											+ ", provided " 
											+ String.valueOf(params.length));
	}
	
	public static void LeftValueVariable(String name) throws BadSyntaxException
	{
		NotationType leftType = NotationParser.Parse(name);
		if(!(leftType.equals(NotationType.REGISTER) 
				|| leftType.equals(NotationType.MEMORY)))
			throw new BadSyntaxException("Left argument must be a register or memory");
	}
}
