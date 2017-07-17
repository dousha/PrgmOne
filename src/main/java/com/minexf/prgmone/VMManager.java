package com.minexf.prgmone;

import java.util.HashMap;

import org.bukkit.block.Block;

import com.minexf.prgmone.vm.VirtualMachine;
import com.minexf.prgmone.vm.opcodes.OpcodeIndexer;

public class VMManager {

	public VMManager(OpcodeIndexer ins)
	{
		_vm = new HashMap<Block, VirtualMachine>();
		_ins = ins;
	}
	
	public VirtualMachine Create(Block b)
	{
		if(!_vm.containsKey(b))
		{
			VirtualMachine vm = new VirtualMachine(128, _ins);
			_vm.put(b, vm);
			return vm;
		}
		else
		{
			return _vm.get(b);
		}
	}
	
	public void Remove(Block b)
	{
		_vm.remove(b);
	}
	
	private HashMap<Block, VirtualMachine> _vm;
	private final OpcodeIndexer _ins;
	
}
