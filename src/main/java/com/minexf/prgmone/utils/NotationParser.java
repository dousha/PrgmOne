package com.minexf.prgmone.utils;

import com.minexf.prgmone.vm.NotationType;
import com.minexf.prgmone.vm.VirtualMachineState;
import com.minexf.prgmone.vm.exceptions.BadSyntaxException;

public class NotationParser {

	public static NotationType Parse(String name)
	{
		switch(name.trim().charAt(0))
		{
		case '%':
			return NotationType.REGISTER;
		case '@':
			return NotationType.MEMORY;
		case '$':
			return NotationType.IMMEDIATE;
		case '&':
			return NotationType.SIDE;
		default:
			return NotationType.LABEL;
		}
	}
	
	public static int GetValue(VirtualMachineState state, String name) throws BadSyntaxException
	{
		switch(NotationParser.Parse(name))
		{
		case REGISTER:
			return state.getRegisters().GetContent(name.substring(1));
		case MEMORY:
			return state.RamReadInt(NumberParser.ParseInt(name.substring(1)));
		case IMMEDIATE:
			return NumberParser.ParseInt(name.substring(1));
		case SIDE:
			return 0; // FIXME: you know what to do...
		case LABEL:
			throw new BadSyntaxException("Cannot use label for value");
		default:
			throw new BadSyntaxException("This should not happen...");
		}
	}
	
	public static void SetValue(VirtualMachineState state, String name, int value) throws BadSyntaxException
	{
		NotationType leftType = NotationParser.Parse(name);
		if(leftType.equals(NotationType.REGISTER))
		{
			state.getRegisters().SetContent(name, value);
		}
		else if(leftType.equals(NotationType.MEMORY))
		{
			state.RamWriteInt(NumberParser.ParseInt(name.substring(1)), value);
		}
	}
	
}
