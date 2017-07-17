package com.minexf.prgmone.utils;

public class Commaplexer {

	public static String[] Plex(String conj)
	{
		if(!conj.contains(","))
			return new String[] {conj};
		else
		{
			String[] p1 = conj.split(",");
			String[] p2 = new String[p1.length];
			for(int i = 0; i < p1.length; i++)
			{
				p2[i] = p1[i].trim();
			}
			return p2;
		}
	}
	
}
