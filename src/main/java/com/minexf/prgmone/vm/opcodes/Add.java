package com.minexf.prgmone.vm.opcodes;

import com.minexf.prgmone.utils.Commaplexer;
import com.minexf.prgmone.utils.NotationParser;
import com.minexf.prgmone.utils.Checkings;
import com.minexf.prgmone.vm.VirtualMachineState;
import com.minexf.prgmone.vm.exceptions.BadSyntaxException;

public class Add implements Opcode {

	@Override
	public void Execute(VirtualMachineState state, String param) throws BadSyntaxException {
		String[] opands = Commaplexer.Plex(param);
		Checkings.ParameterCount(opands, 2);
		Checkings.LeftValueVariable(opands[0]);
		int left = NotationParser.GetValue(state, opands[0]);
		int right = NotationParser.GetValue(state, opands[1]);
		left += right;
		NotationParser.SetValue(state, opands[0], left);
	}

}
