package com.minexf.prgmone.vm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import com.minexf.prgmone.utils.BookChecker;
import com.minexf.prgmone.vm.exceptions.BadSyntaxException;

/**
 * This is the entry of PrgmOne VM.
 * This class takes a single book item for construction.
 * @author dousha
 * @since 0.1-alpha
 */
public class BookProcessor {
	
	public BookProcessor(ItemStack book)
	{
		if(BookChecker.CheckBook(book))
		{
			throw new IllegalArgumentException();
		}
		
		BookMeta meta = (BookMeta) book.getItemMeta();
		_title = meta.hasTitle() ? meta.getTitle() : "Program";
		_author = meta.hasAuthor() ? meta.getAuthor() : "Anonymous";
		_content = meta.getPages();
		_ScanLabels();
	}
	
	public ItemStack BurnDisk(ItemStack inserted)
	{
		if(inserted.getItemMeta().hasLore())
		{
			
		}
		List<String> lore = new ArrayList<String>();
		lore.add(_title);
		lore.add(_author);
		lore.add("");
		inserted.getItemMeta().setLore(lore);
		return inserted;
	}
	
	public List<String> getContent()
	{
		return _content;
	}
	
	public int ResolveLabel(String lbl) throws BadSyntaxException
	{
		if(!_labels.containsKey(lbl))
		{
			throw new BadSyntaxException("label " + lbl + " doesn't exist");
		}
		return _labels.get(lbl);
	}
	
	private void _ScanLabels()
	{
		_labels = new HashMap<String, Integer>();
		String line = null;
		for(int i = 0; i < _content.size(); i++)
		{
			line = _content.get(i);
			if(line.trim().endsWith(":"))
			{
				// it should be a label
				_labels.put(line.substring(0, line.length() - 1), i);
			}
		}
	}
	
	private String _title;
	private String _author;
	private List<String> _content;
	private HashMap<String, Integer> _labels;
	
}
