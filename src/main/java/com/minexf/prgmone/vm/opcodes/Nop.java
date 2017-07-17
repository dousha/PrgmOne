package com.minexf.prgmone.vm.opcodes;

import com.minexf.prgmone.vm.VirtualMachineState;

public class Nop implements Opcode {

	@Override
	public void Execute(VirtualMachineState state, String param) {
		; // do absolutely nothing
	}

}
