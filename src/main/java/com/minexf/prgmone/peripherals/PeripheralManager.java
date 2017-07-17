package com.minexf.prgmone.peripherals;

import java.io.File;
import java.util.HashMap;

import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.minexf.prgmone.vm.StorageManager;

public class PeripheralManager {
	
	public PeripheralManager(JavaPlugin plg, StorageManager store)
	{
		_mgr = new HashMap<Block, Peripheral>();
		_sto = store;
		_plg = plg;
	}
	
	public void LoadPeripherals()
	{
		YamlConfiguration yml = YamlConfiguration
								.loadConfiguration(
									new File(
										_sto.GetBase(), 
										"peri/peri.yml"));
		if(yml == null)
		{
			throw new RuntimeException("");
		}
	}
	
	public void Register(Block b, Peripheral p)
	{
		_mgr.put(b, p);
	}
	
	public Peripheral GetPeripheral(Block b)
	{
		return _mgr.get(b);
	}
	
	private HashMap<Block, Peripheral> _mgr;
	private StorageManager _sto;
	private JavaPlugin _plg;
	
}
