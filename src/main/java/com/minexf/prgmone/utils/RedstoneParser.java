package com.minexf.prgmone.utils;

public class RedstoneParser {
	
	public static int ParseLevel(byte data)
	{
		int level = 0, mask = 0;
		for(int i = 0; i < 4; i++)
		{
			mask = 1 << (i + 1);
			if((data & mask) == mask)
				level += mask;
		}
		return level;
	}
}
