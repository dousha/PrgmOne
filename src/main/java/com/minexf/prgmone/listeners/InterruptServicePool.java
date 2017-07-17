package com.minexf.prgmone.listeners;

import org.bukkit.entity.Player;

import com.minexf.prgmone.utils.MultiMap;
import com.minexf.prgmone.vm.*;

public class InterruptServicePool {
	
	public InterruptServicePool()
	{
		_map = new MultiMap<VirtualMachine, Interrupt>();
	}
	
	public boolean Register(Player p, VirtualMachine vm, Interrupt i)
	{
		if(!p.hasPermission("prgmone.use.interrupt")) return false;
		else
		{
			_map.put(vm, i);
			return true;
		}
	}
	
	private MultiMap<VirtualMachine, Interrupt> _map;
}
