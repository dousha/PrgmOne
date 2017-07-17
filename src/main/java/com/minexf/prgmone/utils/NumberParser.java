package com.minexf.prgmone.utils;

public class NumberParser {
	
	public static int ParseInt(String value)
	{
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
				break;
			}
		}
		else
		{
			v = Integer.valueOf(value);
		}
		return v;
	}
}
