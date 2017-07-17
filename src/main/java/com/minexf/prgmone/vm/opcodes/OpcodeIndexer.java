package com.minexf.prgmone.vm.opcodes;

import java.util.HashMap;

import com.minexf.prgmone.vm.exceptions.UndefinedOpcodeException;

public class OpcodeIndexer {
	
	public OpcodeIndexer()
	{
		_ins = new HashMap<String, Opcode>();
		// TODO: fill up the form!!!
	}
	
	public Opcode GetCode(String name) throws UndefinedOpcodeException
	{
		if(!_ins.containsKey(name))
			throw new UndefinedOpcodeException(name);
		return (Opcode) _ins.get(name);
	}
	
	private HashMap<String, Opcode> _ins;
}
