package com.minexf.prgmone.vm;

import com.minexf.prgmone.utils.NumberParser;

/**
 * This class is the collection of registers.
 * @author dousha
 * @since 0.1-alpha
 */
public class Registers {
	
	public final int REGISTER_SIZE = 8;
	public final int FLAG_SIZE = 4;
	
	public Registers()
	{
		_ints = new int[REGISTER_SIZE];
		_flags = new boolean[FLAG_SIZE];
	}
	
	public int GetContent(String name)
	{
		// name could be r[0-7]
		Integer i = Integer.valueOf(name.charAt(1));
		return _ints[i];
	}
	
	public void SetContent(String name, String value)
	{
		Integer i = Integer.valueOf(name.charAt(1));
		Integer v = NumberParser.ParseInt(value);
		_ints[i] = v.intValue();
	}
	
	public void SetContent(String name, int value) {
		Integer i = Integer.valueOf(name.charAt(1));
		_ints[i] = value;
	}
	
	public int GetFlag()
	{
		int i = 0;
		int x = 0;
		for(boolean flag : _flags)
		{
			if(flag)
			{
				i |= (1 << x);
				x++;
			}
		}
		return i;
	}
	
	public void SetFlag(String name)
	{
		// int i = GetContent(name);
		
	}

	private int[] _ints;
	private boolean[] _flags;

}
