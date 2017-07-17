package com.minexf.prgmone.vm;

public class VirtualMachineState {
	
	public VirtualMachineState(int ram)
	{
		_ram = new Byte[ram];
		_reg = new Registers();
		_line = 0;
	}
	
	public Byte RamRead(int offset)
	{
		return _ram[offset % _ram.length];
	}
	
	public void RamWrite(int offset, Byte data)
	{
		_ram[offset % _ram.length] = data;
	}
	
	public int RamReadInt(int offset)
	{
		int value = 0;
		for (int i = 0; i < 4; i++) 
		{
			int shift = (4 - 1 - i) * 8;
			value += (_ram[i + offset] & 0x000000FF) << shift;
		}
		return value;
	}
	
	public void RamWriteInt(int offset, int data)
	{
		_ram[offset] = (byte) ((data >> 24) & 0xff);
		_ram[offset + 1] = (byte) ((data >> 16) & 0xff);
		_ram[offset + 2] = (byte) ((data >> 8) & 0xff);
		_ram[offset + 3] = (byte) (data & 0xff);
	}
	
	public Registers getRegisters()
	{
		return _reg;
	}
	
	private volatile Byte[] _ram;
	private volatile Registers _reg;
	public volatile int _line;
	
}
