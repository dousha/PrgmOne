package com.minexf.prgmone.vm;

/**
 * This class is the collection of registers.
 * @author dousha
 * @since 0.1-alpha
 */
public class Registers {
	
	public Registers(VirtualMachine vm)
	{
		_vm = vm;
		_ints = new int[8];
	}
	
	public int GetContent(String name) throws BadSyntaxException, RegisterNotFoundException
	{
		// name could be r[0-7]
		if(name.length() != 2)
		{
			throw new BadSyntaxException(_vm.getLine(), _vm.getLineNo(), "Bad register name");
		}
		Integer i = Integer.valueOf(name.charAt(1));
		if(i < 0 || i > 7)
		{
			throw new RegisterNotFoundException();
		}
		return _ints[i];
	}
	
	public void SetContent(String name, String value) throws BadSyntaxException, RegisterNotFoundException
	{
		// name could be r[0-7]
		if(name.length() != 2)
		{
			throw new BadSyntaxException(_vm.getLine(), _vm.getLineNo(), "Bad register name");
		}
		Integer i = Integer.valueOf(name.charAt(1));
		if(i < 0 || i > 7)
		{
			throw new RegisterNotFoundException();
		}
		Integer v = new Integer(0);
		if(value.charAt(0) == '0')
		{
			switch(value.charAt(1))
			{
			case 'x':
				v = Integer.valueOf(value.substring(2), 16);
				break;
			case 'o':
				v = Integer.valueOf(value.substring(2), 8);
				break;
			case 'b':
				v = Integer.valueOf(value.substring(2), 2);
				break;
			default:
				throw new BadSyntaxException(_vm.getLine(), _vm.getLineNo(), "Bad immediate format");
			}
		}
		else
		{
			v = Integer.valueOf(value);
		}
		_ints[i] = v.intValue();
	}

	private final VirtualMachine _vm;
	private int[] _ints;
}
