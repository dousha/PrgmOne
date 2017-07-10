package com.minexf.prgmone.vm;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

/**
 * This is the entry of PrgmOne VM.
 * This class takes a single book item for construction.
 * @author dousha
 * @since 0.1-alpha
 */
public class BookProcessor {
	
	public BookProcessor(ItemStack book)
	{
		if(book.getType() != Material.BOOK_AND_QUILL)
		{
			throw new IllegalArgumentException();
		}
		
		BookMeta meta = (BookMeta) book.getItemMeta();
		_title = meta.hasTitle() ? meta.getTitle() : "Program";
		_author = meta.hasAuthor() ? meta.getAuthor() : "Anonymous";
		_content = meta.getPages();
	}
	
	private String _title;
	private String _author;
	private List<String> _content;
	
}
