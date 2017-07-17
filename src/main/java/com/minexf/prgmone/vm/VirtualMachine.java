package com.minexf.prgmone.vm;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.minexf.prgmone.vm.exceptions.VMException;
import com.minexf.prgmone.vm.opcodes.OpcodeIndexer;

import xyz.upperlevel.spigot.book.BookUtil.BookBuilder;

/**
 * This class is the foundation of PrgmOne VM.
 * @author dousha
 * @since v0.1-alpha
 */
public class VirtualMachine extends Thread {
	
	public VirtualMachine(int size, OpcodeIndexer ins)
	{
		_ins = ins;
		_state = new VirtualMachineState(size);
	}
	
	@Override
	public void run()
	{
		_processor = new BookProcessor(_book);
		_code = _processor.getContent();
		_running = true;
		try {
			for(_state._line = 0; 
					_state._line < _code.size() && _running;
					_state._line++)
			{
				String curLine = _code.get(_state._line).trim();
				if(curLine.startsWith("#")) continue;
				if(curLine.contains(" "))
				{
					_ins.GetCode(curLine.split(" ", 1)[0])
						.Execute(_state, curLine.split(" ", 1)[1]);
				}
				else
				{
					_ins.GetCode(curLine).Execute(_state, null);
				}
			}
		}
		catch (VMException ex)
		{
			_runner.sendMessage(TellException(ex));
			Halt();
		}
	}
	
	public void Halt()
	{
		_running = false;
	}
	
	public void Debug()
	{
		Halt();
		// TODO: write a book for this
		BookBuilder book = xyz.upperlevel.spigot.book.BookUtil.writtenBook();
		book.author("Your computer");
		book.title("Debug output");
		
		book.build();
	}
	
	public void LoadCode(List<String> code)
	{
		_code = code;
	}
	
	public void LoadCodeFromBook(ItemStack book)
	{
		// _processor = new BookProcessor(book);
		// _code = _processor.getContent();
		// the method above is too expensive to execute
		// in the main thread
		_book = book;
	}
	
	public String getLine()
	{
		return _code.get(_state._line);
	}
	
	public int getLineNo()
	{
		return _state._line;
	}
	
	public void SetRunner(Player p)
	{
		_runner = p;
	}
	
	private String TellException(VMException ex)
	{
		return ex.what() + " at line " + String.valueOf(_state._line);
	}

	private final OpcodeIndexer _ins;
	private final VirtualMachineState _state;
	private ItemStack _book;
	private BookProcessor _processor;
	private List<String> _code;
	private volatile boolean _running;
	private Player _runner;

}
