package com.minexf.prgmone.vm;

import java.util.List;

import org.bukkit.entity.Player;

/**
 * This class is the foundation of PrgmOne VM.
 * It takes a string for construction.
 * @author dousha
 *
 */
public class VirtualMachine extends Thread {
	
	public VirtualMachine(List<String> code, int size)
	{
		_code = code;
		_ram = new Byte[size];
		_line = 0;
	}
	
	@Override
	public void run()
	{
		
	}
	
	public void Pause()
	{
		
	}
	
	public void Resume()
	{
		
	}
	
	public void Halt()
	{
		
	}
	
	public void Debug(Player p)
	{
		Pause();
	}
	
	public Byte RamRead(int offset)
	{
		return _ram[offset % _ram.length];
	}
	
	public void RamWrite(int offset, Byte data)
	{
		_ram[offset % _ram.length] = data;
	}
	
	public String getLine()
	{
		return _code.get(_line);
	}
	
	public int getLineNo()
	{
		return _line;
	}
	
	private final List<String> _code;
	private final Byte[] _ram;
	private volatile Registers _reg;
	private volatile int _line;
}
