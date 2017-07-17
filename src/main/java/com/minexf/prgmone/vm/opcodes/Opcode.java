package com.minexf.prgmone.vm.opcodes;

import com.minexf.prgmone.vm.VirtualMachineState;
import com.minexf.prgmone.vm.exceptions.BadSyntaxException;

public interface Opcode {
	
	public void Execute(VirtualMachineState state, String param)
	throws BadSyntaxException;

}
