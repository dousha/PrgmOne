package com.minexf.prgmone.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BookChecker {
	
	public static boolean CheckBook(ItemStack item)
	{
		Material m = item.getType();
		return m.equals(Material.BOOK) 
				|| m.equals(Material.BOOK_AND_QUILL) 
				|| m.equals(Material.WRITTEN_BOOK);
	}
	
}
